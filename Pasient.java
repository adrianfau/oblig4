class Pasient {
  String navn;
  String fodselsNr;
  int id;

  static id_count = 0;

  public Pasient(String n, String fNr) {
    Stabel<Resept> resepter = new Stabel<Resept>();

    navn = n;
    fodseslNr = fNr;

    id = id_count++;
  }

  public String hentNavn() {
    return navn;
  }

  public String hentFodselsnr() {
    return fodseslNr;
  }

  public int hentId() {
    return id;
  }

  public void leggTilRespet(Resept r) {
    resepter.leggTil(r);
  }

  public void fjernResept() {
    resepter.fjern();
  }

  public Resept hentResepter() {
    for (int i = 0; i < resepter.stoerrelse(); i++) {

    }
  }

}

