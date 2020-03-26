class Pasient {
  String navn;
  String fodselsNr;
  int id;
  Stabel<Resept> resepter = new Stabel<Resept>();

  static int id_count = 0;

  public Pasient(String n, String fNr) {

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

  public Stabel<Resept> hentResepter() {
    for (int i = 0; i < resepter.stoerrelse(); i++) {
      System.out.println(resepter.hent(i));
    }

    return resepter;
  }
}