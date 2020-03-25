import java.util.Scanner;

public class Legesystem {

    private Lenkeliste<Pasient> pasienter;
    private Lenkeliste<Resept> resepter;
    private Scanner scanner;


    public Legesystem() {
        pasienter = new Lenkeliste<Pasient>();
        resepter = new Lenkeliste<Resept>();
        scanner = new Scanner(System.in);
    }

    private void brukResept() {
        int antallPasienter = 0;

        //Melding til bruker om at ingen pasienter er lagt til i liste
        if(pasienter.stoerrelse() <= 0) {
            System.out.println("Ingen pasienter funnet");
            return;
        }

        //--------PASIENT---------
        System.out.println("Hvilken pasient vil du se resept for?");

        //Skriver ut pasienter bruker kan velge, tar inn valgt pasient
        for(Pasient pasient : pasienter) {
            System.out.println(pasient.hentId() + ": " + pasient.hentNavn() + "(fnr " + pasient.hentFodselsnr() + ")");
            antallPasienter++;
        }

        int valgtPasient;

        //Feilsjekking av input fra bruker
        try {
            valgtPasient = scanner.nextInt();
        }catch (NumberFormatException e){
            valgtPasient = -1;
        }

        //-----RESEPT------
        if(valgtPasient >= 0 && valgtPasient < antallPasienter) {
            Pasient pasient = pasienter.hent(valgtPasient);
            System.out.println("Valgt pasient: " + pasient.hentNavn() + "(fnr" + pasient.hentFodselsnr() + ")\n" + "Hvilken resept vil du bruke?");

            int antalltResepter = 0;

            for (Resept resept : pasient.hentResepter()) {
                System.out.println(antalltResepter + ": " + resept.hentLegemiddel().hentNavn() + " (" + resept.hentReit() + " reit)");
                antalltResepter++;
            }

            int valgtResept;

            try {
                valgtResept = scanner.nextInt();
            } catch (NumberFormatException e) {
                valgtResept = -1;
            }

            Resept oensketResept = pasient.hentResepter().hent(valgtResept);

            try {
                pasient.resepter.hent(valgtResept).bruk();

                System.out.println("Brukte resept paa " + oensketResept.hentLegemiddel().hentNavn() + ". Antall gjenværende reit: " + oensketResept.hentReit());

            } catch (Exception e) {
                System.out.println("Kunne ikke bruke resept paa " + oensketResept.hentLegemiddel().hentNavn() + " (ingen gjenvaerende reit).");
            }
        } else {
            System.out.println("Ugyldig valg. Gaar tilbake til hovedmeny");
        }
    }
}
