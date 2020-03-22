class Spesialist extends Lege implements Godkjenningsfritak {

  private int kontrollId;

  public Spesialist(String n, int kId) {
    super(n);

    kontrollId = kId;
  }

  @Override
  public int hentKontrollID() {
    return kontrollId;
  }

  @Override
  public String toString() {
    return "SPESIALIST \n" + " Navn: " + this.hentNavn() + " KontrollId: "
     + this.hentKontrollID() + "\n";
  }
}

// Det står noe om at spesialistleger kan skrive ut resepter på narkotiske
// legemidler i oppgaveteksten, men det står heller ingenting om at man skal
// implementere dette. Jeg gjør dermed ikke dette, men det kan lett gjøres med
// en if Legemiddel instanceof Narkotisk -> if Lege instanceof Spesialist
