class TestLegemiddel {
  public static void main(String[] args) {

    Vanlig l1 = new Vanlig("Banan", 12.7, 0.01);
    System.out.println( l1.toString() );
    l1.settNyPris(12.1);
    System.out.println( l1.toString() );

    Vanedannende l2 = new Vanedannende("Beduin", 21.7, 0.02, 10);
    System.out.println( l2.toString() );

    Narkotisk l3 = new Narkotisk("Betong", 71.2, 0.03, 4);
    System.out.println("Forventning: ");
    System.out.println( l3.toString() );
  }

}
