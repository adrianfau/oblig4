class TestResept {
  public static void main(String[] args) {

    Vanedannende l1 = new Vanedannende("Beduin", 21.7, 0.02, 10);
    Narkotisk l2 = new Narkotisk("Betong", 109, 0.03, 4);

    Lege testlege = new Lege("Knut");

    HvitResept hv1 = new HvitResept(l1, testlege, 5318008, 4);
    BlaaResept bl1 = new BlaaResept(l2, testlege, 7, 2);

    MilitaerResept mr1 = new MilitaerResept(l1, testlege, 2, 7);
    PResept pr1 = new PResept(l2, testlege, 19);
    PResept pr2 = new PResept(l1, testlege, 9);

    System.out.println(hv1.toString());
    System.out.println(bl1.toString());

    System.out.println(mr1.toString());
    System.out.println(pr1.toString());
    System.out.println(pr2.toString());
    //System.out.println();
    //System.out.println();
    pr2.bruk();
    pr2.bruk();
    pr2.bruk();
    pr2.bruk();

    //mr1.toString();
    //pr1.toString();
    //pr2.toString();
  }
}
