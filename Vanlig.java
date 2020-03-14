class Vanlig extends Legemiddel {

  public Vanlig(String n, double p, double v) {
    super(n, p, v);
  }

  @Override
  public String toString() {
    return "VANLIG\n" + "Navn: " + this.hentNavn() + " Pris: " + this.hentPris() + " Virkestoff: "
     + this.hentVirkestoff() + " Id: " + this.hentId() + "\n";
  }
}
