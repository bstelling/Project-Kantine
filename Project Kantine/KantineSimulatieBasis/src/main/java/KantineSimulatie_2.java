
import java.util.*;

public class KantineSimulatie_2 {

    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    // artikelen
    private static final String[] artikelnamen =
            new String[] {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};

    // prijzen
    private static double[] artikelprijzen = new double[] {1.50, 2.10, 1.65, 1.65};

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10000;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20000;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;

    //variables voor de administratie
    private int[] aantalpersonenTotaal;
    private double[] omzet;
    private double[] dagomzet;


    /**
     * Constructor
     *
     */
    public KantineSimulatie_2() {
        kantine = new Kantine();
        random = new Random();
        int[] hoeveelheden =
                getRandomArray(AANTAL_ARTIKELEN, MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod = new KantineAanbod(artikelnamen, artikelprijzen, hoeveelheden);

        kantine.setKantineAanbod(kantineaanbod);
    }

    /**
     * Methode om een array van random getallen liggend tussen min en max van de gegeven lengte te
     * genereren
     *
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for (int i = 0; i < lengte; i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl) en max(incl) te genereren.
     *
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array artikelnamen de bijhorende array
     * van artikelnamen te maken
     *
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for (int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];

        }

        return artikelen;
    }

    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen
     * @return
     */
    public void simuleer(int dagen) {

        aantalpersonenTotaal = new int[dagen];
        omzet = new double[7];
        dagomzet = new double[7];


        // for lus voor dagen
        for(int i = 0; i < dagen; i++) {

            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);
            // variabelen maken voor het aantal studenten, docenten, medewerkers (klanten)
            int aantalStudenten = 89;
            int aantalDocenten = 10;
            int aantalMedewerkers = 1;

            // laat de personen maar komen...
            for (int j = 0; j < aantalpersonen; j++) {

                //Persoon object aanmaken
                Persoon p1 = new Persoon();

                // maak personen en dienblad aan, koppel ze
                // en bedenk hoeveel artikelen worden gepakt
                if(j < aantalMedewerkers) {
                    p1 = new KantineMedewerker(1, "Piet", "Friet", new Datum(1, 03, 2001), 'm', 2, false);
                }
                else if(j < aantalDocenten) {
                    p1 = new Docent(2, "Klaas", "de Klein", new Datum(03, 05, 1992), 'm', "KLKL", "INF");
                }
                else if(j < aantalStudenten){
                    p1 = new Student(3, "Joost", "Proost", new Datum(02, 04, 2002), 'm', 387107);
                }
                //System.out.println(p1.toString());
                Dienblad dienblad = new Dienblad();

                int aantalartikelen = getRandomValue(MIN_ARTIKELEN_PER_PERSOON, MAX_ARTIKELEN_PER_PERSOON);

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken = getRandomArray(aantalartikelen, 0, AANTAL_ARTIKELEN-1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);

                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
                kantine.loopPakSluitAan(dienblad, artikelen);
            }

            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();

            // druk de dagtotalen af en hoeveel personen binnen
            // zijn gekomen
//            System.out.println("Aantal artikelen verkocht: " + kantine.getKassa().aantalArtikelen() + "\nTotale balans in de kassa: " + kantine.getKassa().hoeveelheidGeldInKassa() + "\nAantal personen geserveerd: " + aantalpersonen +
//                    "\n");

            //dagtotalen voor de kassa opgeslagen in variabelen:
            aantalpersonenTotaal[i] = aantalpersonen;
            omzet[i] = kantine.getKassa().hoeveelheidGeldInKassa();
            dagomzet[i] = kantine.getKassa().hoeveelheidGeldInKassa();

            // reset de kassa voor de volgende dag
            kantine.resetKassa();

        }

        double gemPersoon = Administratie.berekenGemiddeldAantal(aantalpersonenTotaal);
        System.out.println("Gemiddelde aantal personen per dag: " + gemPersoon + "\n");

        double gemOmzet = Administratie.berekenGemiddeldeOmzet(omzet);
        System.out.println("Gemiddelde omzet per dag: " + gemOmzet + "\n");

        double[] gemDagOmzet = Administratie.berekenDagOmzet(omzet);
        String[] dagVanDeWeek = new String[]{"maandag", "dinsdag", "woensdag", "donderdag", "vrijdag", "zaterdag", "zondag"};
        for(int i =0; i < dagVanDeWeek.length; i++) {
            System.out.println("Op " + dagVanDeWeek[i] + " was de dagomzet: " + gemDagOmzet[i]);
        }



    }
    public static void main(String[] args){
        KantineSimulatie_2 kantineSimulatie = new KantineSimulatie_2();
        kantineSimulatie.simuleer(7);
    }
}
