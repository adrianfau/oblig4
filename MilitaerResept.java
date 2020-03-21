class MilitaerResept extends HvitResept {

  public MilitaerResept(Legemiddel lm,  Lege ul, Pasient p, int reit) {
    super(lm, ul, p, reit);
  }

  public double prisAaBetale() {
    return 0;
  }

  @Override
  public String toString() {
    return "MILITAERRESEPT\n" + "Farge: " + this.farge() +  " Legemiddel: "
     + legemiddel.toString() + "\n Lege: " + utskrivendeLege.toString() + "\n ReseptId: "
      + this.hentId() + " PasientId: " + this.hentPasientId() + " Pris aa betale: "
       + this.prisAaBetale() + " Reit: " + this.hentReit() + "\n";
  }
}
