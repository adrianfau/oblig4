class Pasient {
  String navn;
  String fodselsNr;
  int id;
  Stabel<Resept> resepter;

  static int id_count = 0;

  public Pasient(String n, String fNr) {
    resepter = new Stabel<Resept>();

    navn = n;
    fodselsNr = fNr;

    id = id_count++;
  }

  public String hentNavn() {
    return navn;
  }

  public String hentFodselsnr() {
    return fodselsNr;
  }

  public int hentId() {
    return id;
  }

  public void leggTilRespet(Resept r) {
    resepter.leggPaa(r);
  }

  public void fjernResept() {
    resepter.taAv();
  }

  public void hentResepter() {
    for (int i = 0; i < resepter.stoerrelse(); i++) {
      System.out.println(resepter.hent(i));
    }
  }
}
