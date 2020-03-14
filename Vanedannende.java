class Vanedannende extends Legemiddel {

  private int styrke;

  public Vanedannende(String n, double p, double v, int s) {
    super(n, p, v);

    styrke = s;
  }

  public int hentVanedannendeStyrke() {
    return styrke;
  }

  @Override
  public String toString() {
    return "VANEDANNENDE\n" + "Navn: " + this.hentNavn() + " Pris: " + this.hentPris()
     + " Virkestoff: " + this.hentVirkestoff() + " Styrke: "
      + this.hentVanedannendeStyrke() + " Id: " + this.hentId() + "\n";
  }
}
