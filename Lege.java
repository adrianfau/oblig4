
class Lege implements Comparable<Lege>{

  protected String navn;
  protected Lenkeliste<Resept> utskrevedeResepter = new Lenkeliste<Resept>();

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


  public Lenkeliste<Resept> hentUtskrevedeResepter() {
    for (int i = 0; i < utskrevedeResepter.stoerrelse(); i++) {
      System.out.println(utskrevedeResepter.hent(i));
    }
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
    }

    return nyBlaaResept;
  }

  @Override
  public String toString() {
    return "LEGE \n" + " Navn: " + this.hentNavn() + "\n";
  }

  @Override
  public int compareTo(Lege annen) {
    return this.hentNavn().compareTo(annen.hentNavn());
  }

}
