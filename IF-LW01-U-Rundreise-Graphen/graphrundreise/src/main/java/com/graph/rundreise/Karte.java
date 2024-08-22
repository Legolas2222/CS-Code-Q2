package com.graph.rundreise;
public class Karte{

    private Graph karte;
    
    public Karte(){
        karte = new Graph();        
        neuerOrt("L");
        neuerOrt("A");
        neuerOrt("B");
        neuerOrt("C");
        neuerOrt("D");
        neuerOrt("E");
        neuerOrt("F");
        neueStrasse("L", "A", 14.0);
        neueStrasse("L", "B", 69.0);
        neueStrasse("L", "C", 26.0);
        neueStrasse("L", "D", 31.0);
        neueStrasse("L", "E", 16.0);
        neueStrasse("A", "B", 47.0);
        neueStrasse("A", "C", 66.0);
        neueStrasse("A", "D", 33.0);
        neueStrasse("A", "E", 52.0);        
        neueStrasse("B", "C", 58.0);
        neueStrasse("B", "D", 52.0);
        neueStrasse("B", "E", 23.0);
        neueStrasse("C", "D", 45.0);
        neueStrasse("C", "E", 27.0);
        neueStrasse("D", "E", 59.0);
    }

    
    public void starteRundreise(String startId){
        karte.setAllVertexMarks(false);
        Vertex k = karte.getVertex(startId); 
        System.out.print(k.getID() + " - ");
        rundreise(k);        
    }
    

  
    public void rundreise(Vertex start) {
        // Setze den Start auf besucht
        start.setMark(true);
        
        Vertex current = start;
        while (!karte.allVerticesMarked()) {
            // Bekomme die Nachbarn des aktuellen Vertex
            List<Vertex> nachbarn = karte.getNeighbours(current);
            nachbarn.toFirst();
            
            // Suche den benachbarten, unmarkierten Vertex, der am nächsten dran ist.
            Vertex naechsterNachbar = nachbarn.getContent();
            while (nachbarn.hasAccess()) {
                // Sodass nur unmarkierte Nachbarn generell in Frage kommen
                if (nachbarn.getContent().isMarked()) {
                    nachbarn.next();
                    continue;
                }
                if (naechsterNachbar.isMarked()) {
                    naechsterNachbar = nachbarn.getContent();
                }
                // Vergleich um den nächsten Nachbarn zu finden
                if (karte.getEdge(current, nachbarn.getContent()).getWeight() < karte.getEdge(current, naechsterNachbar).getWeight()) {
                    naechsterNachbar = nachbarn.getContent();
                }
                nachbarn.next();
            }

            // Final check 
            if (naechsterNachbar.getID().equals(start.getID())) {
                break;
            }
            // Als besucht markieren
            naechsterNachbar.setMark(true);
            System.out.print(naechsterNachbar.getID() + " - ");
            current = naechsterNachbar;
        }
        System.out.println(start.getID());


    }
    
    
    private void neuerOrt(String pId){
        karte.addVertex(new Vertex(pId));
    }
    
    private void neueStrasse(String vonId, String nachId, double laenge){
        Vertex v1 = karte.getVertex(vonId);
        Vertex v2 = karte.getVertex(nachId);
        karte.addEdge(new Edge(v1, v2, laenge));
    }
    

    public static void main(String[] args) {
        Karte k = new Karte();
        k.starteRundreise("L");
    }
}





























