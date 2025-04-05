/**
 * Klasse für den gesmten Compiler. Dieser umfasst die Tokenliste, die
 * Symboltabelle und den Scanner. Später wird noch der Parser hinzukommen.
 *
 * @author Daniel Garmann
 * @version 1.0 vom 08.02.2009
 */


 public class Compiler {
   // Datenfelder
   Tokenliste tokenliste;
   Symboltabelle symboltabelle;
   Scanner scanner;

   // Konstruktoren
   public Compiler() {
     symboltabelle = new Symboltabelle();
     tokenliste = new Tokenliste(symboltabelle);
     scanner = new Scanner(tokenliste, symboltabelle);
   }
   
   // Methoden
   /**
    * Getter-Methode für den Scanner
    */
    public Scanner scanner() {
      return scanner;
    }
    
   /**
    * Getter-Methode für die Tokenliste
    */
    public Tokenliste tokenliste() {
      return tokenliste;
    }

   /**
    * Getter-Methode für die Symboltabelle
    */
    public Symboltabelle symboltabelle() {
      return symboltabelle;
    }


 }