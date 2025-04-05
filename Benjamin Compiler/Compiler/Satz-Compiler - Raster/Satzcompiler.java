public class Satzcompiler {

  // Anfang Attribute
  String satz="";
  String tokenliste="";
  
  String[] artikel = {"der","die","das","den"};
  String[] substantiv = {"hund","katze","maus"};
  String[] praedikat = {"frisst","beiﬂt","jagt"};
  // Ende Attribute

  // Anfang Methoden
  public Satzcompiler(String satz) {
    this.satz = satz;
  }
  
  public boolean istArtikel(String terminal) {
    for (int i = 0; i < artikel.length; i++) {
      if (terminal.equals(artikel[i])) return true;
    }
    return false;
  }

  public boolean istSubstantiv(String terminal) {
    for (int i = 0; i < substantiv.length; i++) {
      if (terminal.equals(substantiv[i])) return true;
    }
    return false;
  }

  public boolean istPraedikat(String terminal) {
    for (int i = 0; i < praedikat.length; i++) {
      if (terminal.equals(praedikat[i])) return true;
    }
    return false;
  }

  public boolean scannen(){
    String[] terminale = satz.split(" ");
    for (int i = 0; i < terminale.length; i++) {
      if (istArtikel(terminale[i])) {
        tokenliste += "A";
      } 
      else if (istSubstantiv(terminale[i])){
        tokenliste += "S";
      }
      else if (istPraedikat(terminale[i])) {
        tokenliste += "P";
      }
      else {
        return false;    
      }
    }
    return true;
  }
  
  public boolean parsen() {
    return (tokenliste.equals("ASPAS") || tokenliste.equals("ASP"));
  }
  // Ende Methoden
}
