import java.util.*;
import java.io.*;

public class Legesystem {
  static Liste<Pasient> pasientListe = new Lenkeliste<Pasient>();
  static Liste<Legemiddel> legemiddelListe = new Lenkeliste<Legemiddel>();
  static Liste<Lege> legeListe = new SortertLenkeliste<Lege>();
  static Liste<Resept> reseptListe = new Lenkeliste<Resept>();

  private int antallVanedannende;
  private int antallNarkotiske;


  static void lesFraFil(File fil) {
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

      if (info[1].compareTo("Pasienter") == 0) {

        while(scanner.hasNextLine()) {

          System.out.println(info[0]);
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

        }

      }
      //Legger inn Legemidlene
      else if(info[1].compareTo("Legemidler") == 0){

          while(scanner.hasNextLine()){

              innlest = scanner.nextLine();
              info = innlest.split(",");
              Legemiddel x;
              //Om vi er ferdig med å legge til legemidler, bryt whileløkken,
              //slik at vi fortsetter til koden for å legge til leger
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
                legemiddelListe.leggTil(x);

              } else if (legemiddel[1].compareTo("narkotisk") == 0){

                styrke = Integer.parseInt(info[4]);
                x = new Narkotisk(navn, pris, virkestoff, styrke);
                legemiddelListe.leggTil(x);

              }

          }

      }
      //Legger inn leger
      else if(info[1].compareTo("Leger") == 0){

          while(scanner.hasNextLine()){

              innlest = scanner.nextLine();
              info = innlest.split(",");
              Lege x;
              //Om vi er ferdig med å legge til leger, bryt whileløkken,
              //slik at vi fortsetter til koden for å legge til resepter
              if(innlest.charAt(0) == '#'){
                  break;
              }
              //Lege(String navn, int [kontrollId])
              String navn = info[0];
              int kontrollId;

              int kontrollid = Integer.parseInt(info[1]);
              if(kontrollid == 0){
                  //
                  //MERK:  Her må du legge til et lege objekt i en sortert lenkeliste
                  //
                x = new Lege(navn);
                legeListe.leggTil(x);
              } else {
                  //
                  //MERK:  Her må du legge til et spesialist objekt i en sortert lenkeliste
                  //
                x = new Spesialist(navn, kontrollid);
                legeListe.leggTil(x);
              }

          }

      }
      //Legger inn Resepter
      else if(info[1].compareTo("Resepter") == 0){

          while(scanner.hasNextLine()){

              innlest = scanner.nextLine();
              info = innlest.split(",");
              //Resepter(legemiddelNr, legeNavn, pasientId, type, [reit])

              Legemiddel legemiddel;
              Lege lege;
              Pasient pasient;
              int reit;

              Resept nyResept;

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
              if (info[3].compareTo("p") == 0) {
                nyResept = lege.skrivPResept(legemiddel, lege, pasient)
              } else {
                reit = info[4];
              }

              if (info[3].compareTo("blaa") == 0) {
                nyResept = lege.skrivBlaaResept(legemiddel, lege, pasient, reit)
              } else if (info[3].compareTo("hvit") == 0) {
                nyResept = lege.skrivHvitResept(legemiddel, lege, pasient, reit);
              } else if (info[3].compareTo("millitaer") == 0) {
                nyResept = lege.skrivMilitaerResept(legemiddel, lege, pasient, reit);
              }

              reseptListe.leggTil(nyResept);

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
