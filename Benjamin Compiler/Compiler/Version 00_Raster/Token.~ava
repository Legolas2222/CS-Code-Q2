/**
 * Klasse für ein einzelnes Token. Gespeichert wird hier lediglich der Tokentyp
 * und die zugehörige Zeichenkette. Sinnvollerweise könnten hier Informationen
 * über den Typ z. B. eines Bezeichners oder Speicherinformationen abgelegt werden
 *
 * @author Daniel Garmann
 * @version 1.0 vom 08.02.2009
 */

 public class Token {
   // Datenfelder
   
   private String zeichenkette;
   private int symbol;
   
   public static final int leer =         0;
   public static final int klasse =       1;
   public static final int typ =          2;
   public static final int blockauf =     3;
   public static final int blockzu =      4;
   public static final int semikolon =    5;
   public static final int klammerauf =   6;
   public static final int klammerzu  =   7;
   public static final int zuweisungsop = 8;
   public static final int punktop =      9;
   public static final int modulo =       10;
   public static final int strichop =     11;
   public static final int zahl =         12;
   public static final int name =         13;

   
   // Konstruktoren
   public Token() {
     symbol = leer;
     zeichenkette = "";
   }
   
   public Token(int symbol, String zeichenkette) {
     this.symbol = symbol;
     this.zeichenkette = zeichenkette;
   }
   
   //Methoden

   /**
    * Methode, welche das Symbol als int zurückgibt
    * @return das entsprechende Symbol als int
    */
   public int gibSymbol() {
     return symbol;
   }
   
   /**
    * Methode, welche die entsprechende Zeichenkette zurückgibt
    * @return die entsprechende Zeichenkette
    */
   public String gibZeichenkette() {
     return zeichenkette;
   }
   
   
   /**
    * Methode zur Rückgabe eines Tokens als String
    * @return Token als String
    */
   public String toString() {
     String s = "";
     switch (symbol) {
       case leer: s = "leer"; break;
       case klasse: s = "klasse"; break;
       case typ: s = "typ"; break;
       case blockauf: s = "blockauf"; break;
       case blockzu: s = "blockzu"; break;
       case semikolon: s = "semikolon"; break;
       case klammerauf: s = "klammerauf"; break;
       case klammerzu: s = "klammerzu"; break;
       case zuweisungsop: s = "zuweisungsop"; break;
       case punktop: s = "punktop"; break;
       case modulo: s = "modulo"; break;
       case strichop: s = "strichop"; break;
       case zahl: s = "zahl"; break;
       case name: s = "name"; break;
       default: s = "";
     }
     
     s = s + "                             ".substring(0,15-s.length())+zeichenkette;
     return s;
   }
 }