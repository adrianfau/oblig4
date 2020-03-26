import java.util.Scanner;
public class Legesystem{

// funksjonaliteten til oppgave E*
  public static void E3(){
    return;
  }

  public static void E4(){
    return;
  }

  public static void E5(){
    return;
  }

  public static void E6(){
    return;
  }

  public static void E8(){
    return;
  }


  public static void main(String[] args){
    boolean avslutt = false;
    String input;
    int valg = 0;
    Scanner scan = new Scanner(System.in);

    while (!avslutt){
      System.out.println("Vennligst velg en av disse valgmulighetene:"
        + "\n1. Skrive ut en fullstendig oversikt over pasienter, leger, legemidler og resepter"
        + "\n2. Opprette og legg til nye elementer i systemet."
        + "\n3. Bruke en gitt resept fra listen til en pasient."
        + "\n4. Skrive ut forskjellige former for statistikk."
        + "\n5. Skrive all data til fil."
        + "\n0. Avslutt program.");
      try {
        input = scan.next();
        valg = Integer.parseInt(input);
        // Cases går til funksjonalitene i oppgavene
        switch (valg){
          case 1:
            E3();
            break;
          case 2:
            E4();
            break;
          case 3:
            E5();
            break;
          case 4:
            E6();
            break;
          case 5:
            E8();
            break;
          case 0:
            avslutt = true;
            break;
          default:
            System.out.println("Det er ikke et gyldig valg.");
        }
      }
      catch(Exception e) {
        System.out.println(e);
        System.out.println("Det er ikke et gyldig valg.");
      }
    }

  }

}
