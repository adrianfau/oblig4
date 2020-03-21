abstract class Resept {
  protected Legemiddel legemiddel;
  protected Lege utskrivendeLege;
  protected Pasient pasient;
  protected int reit;

  protected static int id_count = 0;
  protected int id = 0;

  public Resept(Legemiddel lm, Lege ul, Pasient p, int r) {

    legemiddel = lm;
    utskrivendeLege = ul;
    pasient = p;
    reit = r;

    id = id_count++;
  }

  public int hentId() {
    return id;
  }

  public Legemiddel /*String*/ hentLegemiddel() {
    return legemiddel;
    //return legemiddel.toString();
  }

  public Lege /*String*/ hentLege() {
    return utskrivendeLege;
    //return utskrivendeLege.toString();
  }

  public int hentPasientId() {
    return pasient.hentId();
  }

  public int hentReit() {
    return reit;
  }

  public boolean bruk() {
    if (reit <= 0) {
      System.out.println("Resepten er oppbrukt!");
      return false;
    }
    else {
      reit = reit - 1;
      System.out.println("ReseptId " + id + " brukt! Ny mengde reit: " + reit);
      return true;
    }
  }

  abstract public String farge();

  abstract public double prisAaBetale();

  @Override
  public abstract String toString();

}
