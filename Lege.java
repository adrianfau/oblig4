class Lege {

  protected String navn;

  public Lege(String n) {
    navn = n;
  }

  public String hentNavn() {
    return navn;
  }

  @Override
  public String toString() {
    return "LEGE \n" + " Navn: " + this.hentNavn() + "\n";
  }
}
