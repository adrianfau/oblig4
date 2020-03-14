class Narkotisk extends Legemiddel {

  private int styrke;

  public Narkotisk(String n, double p, double v, int s) {
    super(n, p, v);

    styrke = s;
  }

  public int hentNarkotiskStyrke() {
    return styrke;
  }

  @Override
  public String toString() {
    return "NARKOTISK\n" + "Navn: " + this.hentNavn() + " Pris: " + this.hentPris()
    + " Virkestoff: " + this.hentVirkestoff() + " Styrke: "
    + this.hentNarkotiskStyrke() + " Id: " + this.hentId() + "\n";
  }

}
