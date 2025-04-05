/**
 * Klasse für den Scanner des Compilers. Der Scannerautomat arbeitet nach
 * dem unten angegebenen Prinzip.
 *
 * @author Daniel Garmann
 * @version 1.0 vom 08.02.2009
 */

//                +--+
//                |  | a..z, A..Z, 0..9
//                |  V
//               +----+  a..z, A..Z
//               | S4 |<----+
//               +----+     |
//                          |
//         +----+   0..9   +----+
//    +--> | S3 | <------- | S0 |    ()*/;{}=    +----+
//    |    +----+      +-- +----+ -------------> | S1 |
//    |     |  A 0..9  |    |  A                 +----+
//0..9|     |  |       |    |  |
//    |     +--+       |    +--+
//    +--- +----+ <----+     #09
//         | S2 |   +,-      #13
//         +----+            #32
//

 public class Scanner {
   // Datenfelder
   private Symboltabelle symboltabelle;
   private Tokenliste tokenliste;

   // Konstruktoren
   public Scanner(Tokenliste tokenliste, Symboltabelle symboltabelle) {
     this.symboltabelle =symboltabelle;
     this.tokenliste = tokenliste;
   }
   
   // Methoden
   /**
    * Methode zum scannen eines Quelltextes
    * @param quelltext - String
    * @return Fehlernummer als int
    */
   public int scan(String quelltext) {

     ZeichenLeser zeichenLeser = new ZeichenLeser(quelltext);
     int fehlerNr = 0;

     do {
       int zustand = 0;
       boolean endzustand = false;
       String zeichenkette = "";

       do {
          char zeichen = zeichenLeser.gibZeichen();
          zeichenkette = zeichenkette + zeichen;
          switch (zustand) {
            case 0: if (zeichen == ' ' || zeichen == (char)9 || zeichen == '\n' ) {
                      zustand = 0;
                      zeichenkette = "";
                    } else if (zeichen == '(' || zeichen == ')' || zeichen == '{' || zeichen == '}' ||
                               zeichen == '*' || zeichen == '/' || zeichen == ';' || zeichen == '=') {
                      zustand = 1;
                    } else if (zeichen == '+' || zeichen == '-' ) {
                      zustand = 2;
                    } else if (zeichen >= '0' && zeichen <= '9') {
                      zustand = 3;
                    } else if ( (zeichen >= 'a' && zeichen <= 'z') || (zeichen >= 'A' && zeichen <= 'Z') ) {
                      zustand = 4;
                    } else {
                      fehlerNr = 1;
                    }
                    break;
            case 1: endzustand = true;
            case 2: ...


// .....................................
// Hier muss der Code ergänzt werden....
// .....................................



          }
       } while ( (fehlerNr == 0) && (endzustand == false) && (zeichenLeser.endeErreicht() == false) );

       if (endzustand == true) {
         zeichenkette = zeichenkette.substring(0,zeichenkette.length()-1);
         zeichenLeser.zeichenWiederholen();
       }
       
       if (zeichenkette.length() > 0) {
         if (fehlerNr > 0) {
           zeichenkette = "??"; // dann Fehlertoken eintragen
         }
         int symbolIndex = symboltabelle.zeichenketteSuchenUndErweitern(zeichenkette);
         tokenliste.symbolAnfuegen(symbolIndex);
       }
     } while ( (fehlerNr == 0) && (zeichenLeser.endeErreicht() == false) );

     return fehlerNr;
   }
   
   
   
   /**
    * Methode zur Rückgabe einer Fehlermeldung
    * @param fehlerNr - int
    * @return Fehlermeldung als String
    */
   public String fehlermeldung(int fehlerNr) {
     switch (fehlerNr) {
       case 0: return "Alles OK";
       case 1: return "Syntaxfehler! Zeichen unbekannt!";
       case 2: return "zuviele Bezeichner verwendet, Symboltabelle platzt aus allen Nähten...";
       default: return "";
     }
   }
 }