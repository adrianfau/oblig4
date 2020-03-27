class PResept extends HvitResept {

  public PResept(Legemiddel lm,  Lege ul, Pasient p) {
    super(lm, ul, p, 3);
  }

  public double prisAaBetale() {
    if (legemiddel.hentPris() > 108.0) {
      return legemiddel.hentPris() - 108.0;
    }
    else {
      return 0;
    }
  }

  @Override
  public String toString() {
    return "P-RESEPT\n" + "Farge: " + this.farge() + " Legemiddel: "
     + legemiddel.toString() + "Lege: " + utskrivendeLege.toString() + "\nReseptId: "
      + this.hentId() + " PasientId: " + this.hentPasientId() + " Pris aa betale: "
       + this.prisAaBetale() + " Reit: " + this.hentReit() + "\n";
  }
}
