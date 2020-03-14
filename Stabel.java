//Med å bruke extend så arver Stabel Lenkeliste<T>
class Stabel<T> extends Lenkeliste<T>{
  public int tall;

  public Stabel(){
    super(); //Gir tilgang til metodene/funksjonene fra Lenkeliste(Parent)
  }

  //Legger til elementer fra slutten av listen
  public void leggPaa(T x){
    leggTil(x);
  }

  //Fjerner elementer fra slutten av listen
  public T taAv(){
    tall = stoerrelse();
    return (fjern(tall-1));
  }
}
