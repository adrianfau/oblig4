import java.util.*;
import java.io.*;

public class Legesystem {

  //Lager alle listene vi kan trenge i denne oppgaven
  static Liste<Pasient> pasientListe = new Lenkeliste<Pasient>();
  static Liste<Legemiddel> legemiddelListe = new Lenkeliste<Legemiddel>();
  static Liste<Lege> legeListe = new SortertLenkeliste<Lege>();
  static Liste<Resept> reseptListe = new Lenkeliste<Resept>();

  //Lager statistikk - tellere for programmet
  private static int antallVanedannende;
  private static int antallNarkotiske;

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

  //Les-fra-fil metode
  private void lesFraFil(File fil) {

    Scanner scanner = null;

    try {
      scanner = new Scanner(fil);
    } catch(FileNotFoundException e) {
      System.out.println("Ingen fil funnet");
      return;
    }

    String innlest = scanner.nextLine();

    while(scanner.hasNextLine()) {

      String[] info = innlest.split(" ");

      //Sjekker hvilket objekt som skal lages utifra informasjon i fil, og lager tilsvarende objekt
      if (info[1].compareTo("Pasienter") == 0) {

        while(scanner.hasNextLine()) {

          try {
            innlest = scanner.nextLine();
            info = innlest.split(",");

            if (innlest.charAt(0) == '#') {
              break;
            }
            //Pasient(String navn, int fnr);
            String navn = info[0];
            String fnr = info[1];

            Pasient nyPasient = new Pasient(navn, fnr);
            pasientListe.leggTil(nyPasient);
          } catch(Exception e) {
            System.out.println("Ignorerer ugyldig objekt. Forventet (navn, fnr), mottok " + info);
          }

        }

      }
      //Legger inn Legemidlene
      else if(info[1].compareTo("Legemidler") == 0){

          while(scanner.hasNextLine()){

            try {
              innlest = scanner.nextLine();
              info = innlest.split(",");
              Legemiddel x;


              if(innlest.charAt(0) == '#'){
                  break;
              }
              //Legemiddel(String navn, Type type, double pris, double virkestoff, int [styrke]);
              String navn = info[0];
              Double pris = Double.valueOf(info[2]);
              Double virkestoff = Double.valueOf(info[3]);
              int styrke;

              String[] legemiddel = innlest.split(", ");
              if(legemiddel[1].compareTo("vanlig") == 0){

                x = new Vanlig(navn, pris, virkestoff);
                legemiddelListe.leggTil(x);

              } else if(legemiddel[1].compareTo("vanedannende") == 0){

                styrke = Integer.parseInt(info[4]);
                x = new Vanedannende(navn, pris, virkestoff, styrke);
                antallVanedannende++;

                legemiddelListe.leggTil(x);

              } else if (legemiddel[1].compareTo("narkotisk") == 0){

                styrke = Integer.parseInt(info[4]);
                x = new Narkotisk(navn, pris, virkestoff, styrke);
                antallNarkotiske++;

                legemiddelListe.leggTil(x);

              }
            } catch(Exception e) {
              System.out.println("Ignorerer ugylidg objekt. Forventet (navn, type, pris, virkestoff, [styrke]), mottok " + info);
            }

          }

      }
      //Legger inn leger
      else if(info[1].compareTo("Leger") == 0){

          while(scanner.hasNextLine()){


            try {
              innlest = scanner.nextLine();
              info = innlest.split(",");
              Lege x;

              if(innlest.charAt(0) == '#'){
                  break;
              }
              //Lege(String navn, int [kontrollId])
              String navn = info[0];
              int kontrollId;

              int kontrollid = Integer.parseInt(info[1]);
              if(kontrollid == 0){

                x = new Lege(navn);
                legeListe.leggTil(x);

              } else {

                x = new Spesialist(navn, kontrollid);
                legeListe.leggTil(x);

              }

            } catch(Exception e) {
              System.out.println("Ignorerer ugyldig objekt. Forventet (navn, [kontrollId]), mottok " + info);
            }

          }

      }
      //Legger inn Resepter
      else if(info[1].compareTo("Resepter") == 0){

        while(scanner.hasNextLine()){

          try {
            innlest = scanner.nextLine();
            info = innlest.split(",");
            //Resepter(legemiddelNr, legeNavn, pasientId, type, [reit])

            Legemiddel legemiddel = null;
            Lege lege = null;
            Pasient pasient = null;
            int reit = 0;

            Resept nyResept = null;

            //Finner legemiddel
            for (int i = 0; i < legemiddelListe.stoerrelse(); i++) {
              if (legemiddelListe.hent(i).hentId() == Integer.parseInt(info[0])) {
                legemiddel = legemiddelListe.hent(i);
                break;
              }
            }

            //Finner lege
            for (int i = 0; i < legeListe.stoerrelse(); i++) {
              if (legeListe.hent(i).hentNavn().compareTo(info[1]) == 0) {
                lege = legeListe.hent(i);
                break;
              }
            }

            //Finner pasient
            for (int i = 0; i < pasientListe.stoerrelse(); i++) {
              if (pasientListe.hent(i).hentId() == Integer.parseInt(info[2])) {
                pasient = pasientListe.hent(i);
                break;
              }

            }

            //Sjekker type og lar lege skrive ny resept.
              try {
                if (info[3].compareTo("p") == 0) {
                  nyResept = lege.skrivPResept(legemiddel, pasient);
                } else {
                  reit = Integer.parseInt(info[4]);
                }

                if (info[3].compareTo("blaa") == 0) {
                  nyResept = lege.skrivBlaaResept(legemiddel, pasient, reit);
                } else if (info[3].compareTo("hvit") == 0) {
                  nyResept = lege.skrivHvitResept(legemiddel, pasient, reit);
                } else if (info[3].compareTo("millitaer") == 0) {
                  nyResept = lege.skrivMilitaerResept(legemiddel, pasient, reit);
                }

                reseptListe.leggTil(nyResept);
              } catch(UlovligUtskrift e) {}

          } catch(Exception f) {
            System.out.println("Ignorerer Ugyldig objekt. Forventet (legemiddelNr, legeNavn, type, [reit]), mottok " + info);
          }

        }

      }

    }

  }
   //Man, E4. LeggtilPasient,Leger,Legemiddler, og Resepter
  public static void E4(){
    Scanner input2 = new Scanner (System.in);

    System.out.println("oonsker du aa legge til: ");
    System.out.println("Lege, tast 1");
    System.out.println("Pasient, tast 2");
    System.out.println("Legemiddel, tast 3");
    System.out.println("Rasept, tast 4");
    String leggTilValg = input2.nextLine();


    if (leggTilValg.equals("1")){
      leggTilLege();
    } else if (leggTil.equals("2")) {
      leggTilPasient();
    } else if (leggTil.equals("3")) {
      leggTilLegemiddel();
    } else if (leggTil.equals("4")) {
      leggTilResept();
    } else {
      System.out.println("Du har skrevet ugyldig input");
    }
  }


  public void leggTilLege(){
    Scanner nylegescan = new Scanner(System.in);

    System.out.println("Hva er legens navn: ");
    String navn = nylegescan.nextLine();

    System.out.println("Er denne legen en fastlege");
    System.out.println("Tast 1 for ja");
    System.out.println("Tast 2 for nei");
    String legeType = nylegescan.nextLine();


    if (legeType.equals("1")) {
      System.out.println("Tast inn et kontrollid ");
      int kontrollid = nylegescan.nextInt();
      nylegescan.nextLine();
      Lege nyLege = new FastLege(navn, kontrollid);
      legeListe.leggTil(nyLege);
    } else if (legeType.equals("2")){
      Lege nyLege = new Lege(navn);
      legeListe.leggTil(nyLege);
    } else {
      System.out.println("Du har skrevet ugyldig input");
    }
    System.out.println("Legen ble oprettet.");
  }


  public static void leggTilPasient(){
    Scanner nyPasientInput = new Scanner(System.in);

    System.out.println("Hva er navnet til pasienten: ");
    String navn = nyPasientInput.nextLine();

    System.out.println("Hva er pasientens foodselsnummer: ");
    String foodselsnummer = nyPasientInput.nextLine();

    Pasient nyPasient = new Pasient(navn, foodselsnummer);
    pasientListe.leggTil(nyPasientInput); //navnet på objektet, trenger info
    System.out.println("Pasienten ble oprettet");
  }


  public static void leggTilLegemiddel(){
    Scanner nyLegemidler = new Scanner(System.in);

    System.out.println("Hva slags type legemiddel er det?");
    System.out.println("Skriv 1 for Narkotisk legemiddel");
    System.out.println("Skriv 2 for Vanedannende");
    System.out.println("Skriv 3 for Normal legemiddel");

    String typeLegemiddler = nyLegemidler.nextLine();

    if (typeLegemiddler.equals("1")) {
      System.out.println("Hva er navnet til Narkotisk legemiddel: ");
      String navn = nyLegemidler.nextLine();

      System.out.println("Hva er prisen til Narkotisk legemiddel: ");
      double pris = nyLegemidler.nextDouble();
      nyLegemidler.nextLine();

      System.out.println("Hvor mye Virkestoff(mg) i Narkotisk legemiddelet: ");
      double virkestoff = nyLegemidler.nextDouble();
      nyLegemidler.nextLine();

      System.out.println("Narkotisk styrke: ");
      int styrke = nyLegemidler.nextInt();
      nyLegemidler.nextLine();

      Narkotisk narkotisk = new Narkotisk(navn, pris, virkestoff, styrke);
      legemiddelListe.leggTil(narkotisk);
      System.out.println("Narkotisk Legemidlet ble oprettet");


    } else if (typeLegemiddler.equals("2")){
      System.out.println("Hva er navnet til vanedannende leggemiddel: ");
      String navn = nyLegemidler.nextLine();

      System.out.println("Hva er prisen til vanedannende legemiddel: ");
      double pris = nyLegemidler.nextDouble();
      nyLegemidler.nextLine();

      System.out.println("Hvor mye virkestoff(mg) i vanedannende legemiddel");
      double virkestoff = nyLegemidler.nextDouble();
      nyLegemidler.nextLine();

      System.out.println("Vannedanende styrke: ");
      int styrke = nyLegemidler.nextInt();
      nyLegemidler.nextLine();

      Vanedannende vanedannende = new LegemiddelB(navn, pris, virkestoff, styrke);
      legemiddelListe.leggTil(vanedannende);
      System.out.println("Vanedannende legemidlet ble oprettet");


    } else if (typeLegemiddler.equals("3")){
      System.out.println("Hva er navnet til normal leggemiddel: ");
      String navn = nyLegemidler.nextLine();

      System.out.println("Hva er prisen til normal legemiddel: ");
      double pris = nyLegemidler.nextDouble();
      nyLegemidler.nextLine();

      System.out.println("Hvor mye virkestoff(mg) i normal legemiddel ");
      double virkestoff = nyLegemidler.nextDouble();
      nyLegemidler.nextLine();

      Legemiddel legemiddel = new LegemiddelC(navn, pris, virkestoff);
      legemiddelListe.leggTil(legemiddel);
      System.out.println("Vanlig legemidlet ble oprettet");
    } else {
      System.out.println("Du har skrevet ugyldig input");
    }
  }
  //kodeblokken

  public static void leggTilResept(){
    Scanner nyReseptScanner = New Scanner(System.in);

    if (pasientListe.erTom()) {
      System.out.println("Det finnes ingen pasienter. Resept kan ikke oprettes.");
      return;
    }

    System.out.println("Hvilket pasient skal utskrives en resept til?");
    for (Pasient pasient : pasientListe) {
      System.out.println(pasient.hentId() + ": " + pasient.toString());
    }

    Pasient pasient = null;
    int pasientId = nyReseptScanner.nextInt();
    nyReseptScanner.nextLine();

    for (Pasient a : pasientListe) {
      if (a.hentId() = pasientid) {
        pasient = p;
      } else {
        System.out.println("Pasienten finnes ikke.");
        return;
      }
    }


    if (legeListe.erTom()){
      System.out.println("Det finnes ingen leger! Resept kan ikke oprettes.");
      return;
    }


    System.out.println("Hvilken lege utskriver denne resepten? ");
    for (Lege lege : legeListe) {
      System.out.println(lege.toString());
    }


    Lege lege = null;
    String legeNavn = nyReseptScanner.nextLine();


    for (Lege b : legeListe) {
      if (b.hentNavn()equal(legeNavn)){
        lege = b;
      } else {
        System.out.println("Legen finnes ikke.");
      }
    }

    if (legeListe.erTom()){
      System.out.println("Det finnes ingen legemidler! Resept kan ikke oprettes.");
      return;
    }

    System.out.println("Hvilket legemiddel skal brukes?");
    for (Legemiddel legemiddel : legeListe) {
      System.out.println(legemiddel.toString());
    }

    Legemiddel legemiddel = null;
    String legemiddelNavn = nyReseptScanner.nextLine();

    for Legemiddel c : legeListe) {
      if (c.hentNavn().equalsIgnoreCase(legemiddelNavn)) {
        legemiddel = c;
      } else {
        System.out.println("Legemidlet finnes ikke.");
        return;
      }
    }

    System.out.println("Hvor mange ganger kan resepten brukes?");
    int reit = nyReseptScanner.nextInt();
    nyReseptScanner.nextLine();

    System.out.println("Hva slags type resept er det? ");
    System.out.println("er det:");
    System.out.println("blaa Resept, tast 1");
    System.out.println("P resept, tast 2");
    System.out.println("Militaer resept, tast 3");

    String input3 = nyReseptScanner.nextLine();

    if(input3.equals("1")) {
      Resept blaaResept = new BlaaResept(legemiddel, lege, pasient, reit);
      lege.leggTilResept(blaaResept);
      pasient.leggTilResept(blaaResept);
      resepter.leggTil(blaaResept);
      System.out.println("Resepten ble lagret");
    }else if (input3.equals("2") {
      Resept pResept = new PResept(legemiddel, lege, pasient, reit);
      lege.leggTilResept(pResept);
      pasient.leggTilResept(pResept);
      resepter.leggTil(pResept);
      System.out.println("Resepten ble lagret");
    }else if (input3.equals("3")){
      Resept mResept = new MilitaerResept(legemiddel, lege, pasient, reit);
      lege.leggTilResept(mResept);
      pasient.leggTilResept(mResept);
      resepter.leggTil(mResept);
      System.out.println("Resepten ble lagret");
    } else {
      System.oput.println("Du har skrevet feil input.");
    }
  }


  //private void Statistikk() {
  //  for (Lege lege : legeListe) {
  //    legeListe = lege.hentUtskrevedeResepter();
  //    for (Resept resept : legeListe) {
  //      if (resept.hentLegemiddel() instanceof Narkotisk) {
  //        System.out.println("Denne legen har skrevet ut et narkotisk legemiddel");
  //        break;
  //      }
  //    }
  //  }
  //}

}
