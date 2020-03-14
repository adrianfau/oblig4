class HvitResept extends Resept {

  public HvitResept(Legemiddel lm,  Lege ul, int pId, int reit) {
    super(lm, ul, pId, reit);
  }

  public String farge() {
    return "HVIT";
  }

  public double prisAaBetale() {
    return legemiddel.hentPris();
  }

  @Override
  public String toString() {
    return "HVITRESEPT\n" + "Farge: " + this.farge() + " Legemiddel: "
     + legemiddel.toString() + "\n Lege: " + utskrivendeLege.toString() + "\n ReseptId: "
      + this.hentId() + " PasientId: " + this.hentPasientId() + " Pris aa betale: "
       + this.prisAaBetale() + " Reit: " + this.hentReit() + "\n";
  }
}
