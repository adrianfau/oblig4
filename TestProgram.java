class TestProgram{
  public static void main(String[] args) {
    Lege legekid = new Lege("legenavn");
    Lege spesialistkid = new Spesialist("Spesialisten", 234);
    Legemiddel legemiddellet = new Narkotisk("legemiddelnavn,", 250.0, 4.0, 2);
    Pasient pasienten = new Pasient("PasientNavn", "16089234567");
    HvitResept hviteResepten;

    try {
      hviteResepten = legekid.skrivHvitResept(legemiddellet, pasienten, 3);
    }catch(Exception e){
      e.printStackTrace();
    }

    try {

      hviteResepten = spesialistkid.skrivHvitResept(legemiddellet, pasienten, 3);

    }catch(Exception e){
      e.printStackTrace();
    }
    Lenkeliste reseptliste = legekid.hentUtskrevedeResepter();
    Lenkeliste spesialistListe = spesialistkid.hentUtskrevedeResepter();

    System.out.println(reseptliste.stoerrelse());
    System.out.println(spesialistListe.stoerrelse());

  }
}