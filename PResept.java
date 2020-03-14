class PResept extends HvitResept {

  public PResept(Legemiddel lm,  Lege ul, int pId) {
    super(lm, ul, pId, 3);
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
     + legemiddel.toString() + "\n Lege: " + utskrivendeLege.toString() + "\n ReseptId: "
      + this.hentId() + " PasientId: " + this.hentPasientId() + " Pris aa betale: "
       + this.prisAaBetale() + " Reit: " + this.hentReit() + "\n";
  }
}
