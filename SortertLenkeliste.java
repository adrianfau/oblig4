class SortertLenkeliste<T extends Comparable<T>> extends Lenkeliste<T> {
  public int tall;

  public SortertLenkeliste(){
    super();//Gir tilgang til metodene/funksjonene fra Lenkeliste(Parent)
  }

  //Setter inn elementer i sorterende måte fra minst til størst
  public void leggTil(T x){
    if (ny_node.node==null){
      ny_node.node = new Node(x);
      System.out.println(ny_node.node.t);
    }else{
      Node u = ny_node;
      while (u.node != null && u.node.t.compareTo(x) < 0){
        u = u.node;
      }
      Node ny_nodeere = new Node(x);
      if (u.node!=null){
        ny_nodeere.node = u.node;
      }
      u.node = ny_nodeere;
    }
  }

  //Det største elementet tas ut
  public T fjern(){
    tall = stoerrelse();
    return fjern(tall-1);
  }


  public void sett(int pos, T x ){
    throw new UnsupportedOperationException("Error");
  }


  public void leggTil(int pos, T x){
    throw new UnsupportedOperationException("Error");
  }
}
