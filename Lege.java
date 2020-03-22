class Lege implements Comparable<Lege> {

  protected String navn;
  protected Lenkeliste<Resept> utskrevedeResepter;

  public Lege(String n) {
    navn = n;
    utskrevedeResepter = new Lenkeliste<Resept>();
  }

  public Lenkeliste<Resept> hentUtskrevedeResepter() {
    return utskrevedeResepter;
  }


  public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
    // HvitResept resept = n;

    if ((legemiddel instanceof Narkotisk) && !(this instanceof Spesialist)){
      throw new UlovligUtskrift(this, legemiddel);
    }
    
    HvitResept nyHvitResept = new HvitResept(legemiddel, this, pasient.id, reit);
    utskrevedeResepter.leggTil(nyHvitResept);
    return nyHvitResept;
  }
  public MilitaerResept skrivMilitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
    // MilitaerResept resept = n;

    if ((legemiddel instanceof Narkotisk) && !(this instanceof Spesialist)){
      throw new UlovligUtskrift(this, legemiddel);
    }

    MilitaerResept nyMilitaerResept = new MilitaerResept(legemiddel, this, pasient.id, reit);
    utskrevedeResepter.leggTil(nyMilitaerResept);
    return nyMilitaerResept;
  }
  public Presept skrivPresept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
    // Presept resept = n;

    if ((legemiddel instanceof Narkotisk) && !(this instanceof Spesialist)){
      throw new UlovligUtskrift(this, legemiddel);
    }

    Presept nyPresept = new Presept(legemiddel, this, pasient.id, reit);
    utskrevedeResepter.leggTil(nyPresept);
    return nyPresept;
  }
  public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
    // BlaaResept resept = n;

    if ((legemiddel instanceof Narkotisk) && !(this instanceof Spesialist)){
      throw new UlovligUtskrift(this, legemiddel);
    }

    BlaaResept nyBlaaResept = new BlaaResept(legemiddel, this, pasient.id, reit);
    utskrevedeResepter.leggTil(nyBlaaResept);
    return nyBlaaResept;
  }

  public String hentNavn() {
    return navn;
  }
  public int compareTo(Lege lege) {
    return navn.compareTo(lege.hentNavn());
  }


  @Override
  public String toString() {
    return "LEGE \n" + " Navn: " + this.hentNavn() + "\n";
  }
}
