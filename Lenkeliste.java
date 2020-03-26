class Lenkeliste<T> implements Liste<T>{
  public Node ny_node = new Node(null);
  public class Node{
    public Node node = null;
    public T t;
    Node(T x){
      this.t = x;
    }
  }

  //Sjekker størrelsen av opgitt liste
  public int stoerrelse(){
    Node a = ny_node;
    int b = 0;
    while (a.node!=null){
      b++;
      a = a.node;
    }
    return b;
  }

  //metoden legger elementet i slutten av lista
  public void leggTil(T x){
    if (ny_node.node==null){
      ny_node.node = new Node(x);
      System.out.println(ny_node.node.t);
    }else{
      Node a = ny_node;
      while (a.node!=null){
        a = a.node;
      }
      a.node = new Node(x);
    }
  }

  //Metoden legger inn et ny_nodett element i listen og skyver neste elementet ett hakk lenger bak
  public void leggTil(int pos, T x){
    if (pos<0||pos>stoerrelse()){
      throw new UgyldigListeIndeks(pos);
    }
    if (pos==0){
      Node a = new Node(x);
      a.node = ny_node.node;
      ny_node.node = a;
    }else{
      Node a = ny_node;
      for (int i=0;i<pos;i++){
        a = a.node;
      }
      Node ny_nodeere  = new Node(x);
      ny_nodeere.node = a.node;
      a.node = ny_nodeere;
    }
  }


  //Metoden setter inn elementet(int pos) på en gitt posisjon og oveskriver det som blir opgitt i "T x"
  public void sett(int pos, T x){
    if (pos<0||pos>=stoerrelse()){
      throw new UgyldigListeIndeks(pos);
    }
    Node a = ny_node;
    for (int i=0;i<pos;i++){
      a = a.node;
    }
    a.node.t = x;
  }

  //Henter ut elemente på opgitt indeks
  public T hent(int pos){
    if (pos<0||pos>=stoerrelse()){
      throw new UgyldigListeIndeks(pos);
    }
    Node a = ny_node.node;
    for (int i=0;i<pos;i++){
      a = a.node;
    }
    return a.t;
  }

  //Metoden fjerner
  public T fjern(){
    if (ny_node.node==null){
      throw new UgyldigListeIndeks(-1);
    }else{
      Node a = ny_node.node;
      ny_node.node = a.node;
      return a.t;
    }
  }

  //Metoden fjerner på gitt indeks i listen
  public T fjern(int pos){
    if (pos<0||pos>=stoerrelse()){
      throw new UgyldigListeIndeks(pos);
    }
    Node a = ny_node;
    for (int i=0;i<pos;i++){
      a = a.node;
    }
    Node fjern = a.node;
    a.node = fjern.node;
    return fjern.t;
  }

  //new, C3
  //public Iterator<T> iterator(){
  //  return new LenkelisteIterator();
  //}
}
