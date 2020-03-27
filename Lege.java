class Lege implements Comparable<Lege>{

  protected String navn;
  protected Lenkeliste<Resept> utskrevedeResepter = new Lenkeliste<Resept>();

  public Lege(String n) {
    navn = n;
  }

  public String hentNavn() {
    return navn;
  }

  public Lenkeliste<Resept> hentUtskrevedeResepter() {
    //for (int i = 0; i < utskrevedeResepter.stoerrelse(); i++) {
    //  System.out.println(utskrevedeResepter.hent(i));
    //}
    return utskrevedeResepter;
  }

  public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
    HvitResept nyHvitResept;

    if (legemiddel instanceof Narkotisk && !(this instanceof Spesialist)) {
      throw new UlovligUtskrift(this, legemiddel);
    }
    else {
      nyHvitResept = new HvitResept(legemiddel, this, pasient, reit);
      utskrevedeResepter.leggTil(nyHvitResept);
      pasient.leggTilResept(nyHvitResept);
    }
    return nyHvitResept;
  }

  public MilitaerResept skrivMilitaerResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
    MilitaerResept nyMilitaerResept;

    if (legemiddel instanceof Narkotisk && !(this instanceof Spesialist)) {
      throw new UlovligUtskrift(this, legemiddel);
    }
    else {
      nyMilitaerResept = new MilitaerResept(legemiddel, this, pasient, reit);
      utskrevedeResepter.leggTil(nyMilitaerResept);
      pasient.leggTilResept(nyMilitaerResept);
    }
    return nyMilitaerResept;
  }

  public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient) throws UlovligUtskrift {
    PResept nyPResept;

    if (legemiddel instanceof Narkotisk && !(this instanceof Spesialist)) {
      throw new UlovligUtskrift(this, legemiddel);
    }
    else {
      nyPResept  = new PResept(legemiddel, this, pasient);
      utskrevedeResepter.leggTil(nyPResept);
      pasient.leggTilResept(nyPResept);
    }
    return nyPResept;
  }

  public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) throws UlovligUtskrift {
    BlaaResept nyBlaaResept;

    if (legemiddel instanceof Narkotisk && !(this instanceof Spesialist)) {
      throw new UlovligUtskrift(this, legemiddel);
    }
    else {
      nyBlaaResept = new BlaaResept(legemiddel, this, pasient, reit);
      utskrevedeResepter.leggTil(nyBlaaResept);
      pasient.leggTilResept(nyBlaaResept);
    }
    return nyBlaaResept;
  }

  @Override
  public String toString() {
    return "LEGE" + " Navn: " + this.hentNavn();
  }

  @Override
  public int compareTo(Lege annen) {
    return this.hentNavn().compareTo(annen.hentNavn());
  }

}
