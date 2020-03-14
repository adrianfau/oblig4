class BlaaResept extends Resept {
  
  public BlaaResept(Legemiddel lm,  Lege ul, int pId, int reit) {
    super(lm, ul, pId, reit);
  }

  public String farge() {
    return "BLAA";
  }

  public double prisAaBetale() {
    return legemiddel.hentPris() * 0.25;
  }

  @Override
  public String toString() {
    return "BLAARESEPT\n" + "Farge: " + this.farge() + " Legemiddel: "
     + legemiddel.toString() + "\n Lege: " + utskrivendeLege.toString() + "\n ReseptId: "
      + this.hentId() + " PasientId: " + this.hentPasientId() + " Pris aa betale: "
       + this.prisAaBetale() + " Reit: " + this.hentReit() + "\n";
  }
}
