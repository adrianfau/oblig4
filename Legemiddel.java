abstract class Legemiddel {
  protected String navn;
  protected double pris;
  protected double virkestoff;

  protected static int id_count = 0;
  protected int id = 0;

  public Legemiddel(String n, double p, double v) {

    navn = n;
    pris = p;
    virkestoff = v;

    id = id_count++;
  }

  public int hentId() {
    return id;
  }

  public String hentNavn() {
    return navn;
  }

  public double hentPris() {
    return pris;
  }

  public double hentVirkestoff() {
    return virkestoff;
  }

  public void settNyPris(double nyp) {
    pris = nyp;
  }

  @Override
  public String toString(){
    String info = "Legemiddel navn: " + navn + "\n";
    info = info + "Pris " + pris + "\n";
    info = info + "Virkestoff: " + virkestoff + "\n";

    return info;
  }

}
