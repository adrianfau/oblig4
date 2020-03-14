class IntegrasjonsTest {

  public static void main(String[] args) {
    Vanedannende l1 = new Vanedannende("Beduin", 21.7, 0.02, 10);
    Narkotisk l2 = new Narkotisk("Betong", 109, 0.03, 4);
    Vanlig l3 = new Vanlig("Banan", 12.7, 0.01);

    System.out.println(l1.toString());
    System.out.println(l2.toString());
    System.out.println(l3.toString());

    l1.settNyPris(2000);
    System.out.println(l1.toString());

    Lege testlege = new Lege("Knut");
    Spesialist testSpes = new Spesialist("Arne", 90);

    System.out.println(testlege.toString());
    System.out.println(testSpes.toString());

    BlaaResept bl1 = new BlaaResept(l2, testlege, 7, 2);
    HvitResept hv1 = new HvitResept(l1, testlege, 5318008, 4);

    MilitaerResept mr1 = new MilitaerResept(l1, testlege, 2, 7);
    PResept pr1 = new PResept(l2, testlege, 19);
    PResept pr2 = new PResept(l1, testlege, 9);

    System.out.println(bl1.toString());
    System.out.println(hv1.toString());

    System.out.println(mr1.toString());
    System.out.println(pr1.toString());
    System.out.println(pr2.toString());

    pr1.bruk();
    pr1.bruk();
    pr1.bruk();
    pr1.bruk(); //Disse returnerer også true eller false, men for testens skyld har de print

  }
}

// Den overskrevne toString() - metoden som jeg har definert den bruker alle metodene
// til et opprettet objekt, så i underveistestene har jeg bruk den.
