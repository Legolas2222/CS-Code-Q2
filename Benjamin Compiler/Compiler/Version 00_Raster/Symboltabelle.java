/**
 * Klasse für eine Symboltabelle zur Speicherung der festen und variablen
 * Symbole während des Scann-Prozesses
 *
 * @author Daniel Garmann
 * @version 1.0 vom 08.02.2009
 */

 public class Symboltabelle {
   // Datenfelder
   private Token[] tabelle;
   private int anzahl;
   
   private static int MAX = 100;
   
   // Konstruktoren
   public Symboltabelle() {
     tabelle = new Token[MAX];
     tabelle[0] = new Token(Token.leer,"");
     tabelle[1] = new Token(Token.klasse,"class");
     tabelle[2] = new Token(Token.typ,"void");
     tabelle[3] = new Token(Token.typ,"int");
     tabelle[4] = new Token(Token.blockauf,"{");
     tabelle[5] = new Token(Token.blockzu,"}");
     tabelle[6] = new Token(Token.semikolon,";");
     tabelle[7] = new Token(Token.klammerauf,"(");
     tabelle[8] = new Token(Token.klammerzu,")");
     tabelle[9] = new Token(Token.zuweisungsop,"=");
     tabelle[10] = new Token(Token.punktop,"*");
     tabelle[11] = new Token(Token.punktop,"/");
     tabelle[12] = new Token(Token.modulo, "%");
     tabelle[13] = new Token(Token.strichop,"+");
     tabelle[14] = new Token(Token.strichop,"-");

     anzahl = 15;
   }

   // Methoden
   /**
    * Methode liefert zu einem Index den entsprechenden String aus der Symboltabelle
    * @üaram index - Index der zurückzugebenden Zeichenkette
    * @return die zum Index zugehörige Zeichenkette als String
    */
   public String zeichenketteVonIndex(int index) {
     return tabelle[index].gibZeichenkette();
   }


   /**
    * Methode sucht einen String in der Symboltabelle. Falls der String nicht
    * gefunden wird, so wird die Symboltabelle um diesen String ergänzt.
    * Der String wäre dann nämlich ein Bezeichner oder eine Zahl.
    * @param zeichenkette - Die zu suchende Zeichenkette
    * @return der zueghörige Index aus der Symboltabelle
    */
   public int zeichenketteSuchenUndErweitern(String zeichenkette) {
     for (int i = 0; i < anzahl; i++) {
       if (tabelle[i].gibZeichenkette().equals(zeichenkette)) {
         return i;
       }
     }
     // Zeichenkette wurde nicht gefunden, also Symboltabelle erweitern.
     if ((zeichenkette.charAt(0) >= '0' && zeichenkette.charAt(0) <= '9') || (zeichenkette.charAt(0) == '+' || zeichenkette.charAt(0) == '-') && zeichenkette.charAt(1) >= '0' && zeichenkette.charAt(1) <= '9') {
       tabelle[anzahl] = new Token(Token.zahl,zeichenkette);
     } else {
       tabelle[anzahl] = new Token(Token.name,zeichenkette);          
     }
     anzahl++;
     return anzahl-1;
   }
   
   /**
    * Meghode leifert zu einem Index das entsprechende Symbo aus der Symboltabelle
    * @praram index - Index des zurückzugebenden Symbols
    * @return das zum Index zugehörige Symbol als int
    */
    public int symbolVonIndex(int index) {
      return tabelle[index].gibSymbol();
    }


    /**
     * Methode zur Ausgabe der Symboltabelle als String
     * @return Symboltabelle als String
     */
    public String toString() {
      String s = "";
      for (int i = 0; i < anzahl; i++) {
        if (tabelle[i].gibSymbol() != Token.leer) {
          String nr = ""+i+".";
          s = s + i + "." + "         ".substring(0,6-nr.length()) + tabelle[i]+"\n";
        }
      }
      return s;
    }


 }