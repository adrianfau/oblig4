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

  public static void E3() {
    return;
  }

  public static void E4() {
    return;
  }

  public static void E5() {
    return;
  }

  public static void E6() {
    //Printer antall vanedannende og narkotiske
    System.out.println("Antall utskrevede vandedannende legemidler: " + antallVanedannende);
    System.out.println("Antall utskrevede narkotiske legemidler: " + antallNarkotiske);

    //Printer alle leger som har skrevet ut narkotiske, inkl hvor mange
    System.out.println("Leger:");
    for (int i = 0; i < legeListe.stoerrelse(); i++) {

      Lege tempLege = legeListe.hent(i);
      int tempLegeNark = 0;
      Liste<Resept> tempLegeListe = tempLege.hentUtskrevedeResepter();

      for (int j = 0; j < tempLegeListe.stoerrelse(); j++) {
        if (tempLegeListe.hent(j).hentLegemiddel() instanceof Narkotisk) {
          tempLegeNark++;
        }
      }

      if (tempLegeNark > 0) {
        System.out.println("Lege " + tempLege.hentNavn() + " har skrevet ut " + tempLegeNark
         + " narkotiske legemidler");
      }
    }

    //Printer alle pasienter som har fått narkotiske, inkl hvor mange
    System.out.println("Pasienter:");
    for (int i = 0; i < pasientListe.stoerrelse(); i++) {
      Pasient tempPas = pasientListe.hent(i);
      int tempPasNark = 0;
      Liste<Resept> tempPasListe = tempPas.hentResepter();

      for (int j = 0; j < tempPasListe.stoerrelse(); j++) {
        if (tempPasListe.hent(j).hentLegemiddel() instanceof Narkotisk) {
          tempPasNark++;
        }
      }
      if (tempPasNark > 0) {
        System.out.println("Pasient " + tempPas.hentNavn() + " har fått utskrevet "
        + tempPasNark + " narkotiske resepter");
      }
    }

  }

  public static void E8() {
    throws IOException {
      PrintWriter writer = new PrintWriter("utFil.txt", "UTF-8");

      int i = 0;
      int j = 0;
      int k = 0;
      int l = 0;

      writer.println("# Pasienter (navn,fnr)");
      while (i < pasientListe.stoerrelse()) {
        Pasient temp = pasientListe.hent(i);
        writer.println(temp.hentNavn() + "," + temp.hentFodselsnr());
        i++
      }

      writer.println("# Legemidler (navn,type,pris,virkestoff,[styrke])");
      while (j < legemiddelListe.stoerrelse()) {
        Legemiddel temp = legemiddelListe.hent(j);
        if (temp instanceof Vanlig) {
          writer.println(temp.hentNavn() + "," + "vanlig" + "," + temp.hentPris() + "," + temp.hentVirkestoff());
        } else if (temp instanceof Narkotisk) {
          writer.println(temp.hentNavn() + "," + "narkotisk" + temp.hentPris() + ","
          + temp.hentVirkestoff() + "," + temp.hentNarkotiskStyrke());
        } else if (temp instanceof Vanedannende) {
          writer.println(temp.hentNavn() + "," + "vanedannende" + "," + temp.hentPris() + ","
          + temp.hentVirkestoff() + "," + temp.hentVanedannendeStyrke())
        }
      }

      writer.println("# Leger (navn,kontrollid / 0 hvis vanlig lege)");
      while (k < legeListe.stoerrelse();) {

      }

      writer.println("# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])");
      while (l < reseptListe.stoerrelse()) {

      }
    }
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
