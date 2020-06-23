

import java.util.*;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class KantineSimulatie_2 {
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("KantineSimulatie");
    private EntityManager manager;

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
    private int[] aantalArtikelenTotaal;



    /**
     * Constructor
     *
     */
    public KantineSimulatie_2() {
        manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        kantine = new Kantine(manager);
        random = new Random();
        int[] hoeveelheden =
                getRandomArray(AANTAL_ARTIKELEN, MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod = new KantineAanbod(artikelnamen, artikelprijzen, hoeveelheden);

        kantine.setKantineAanbod(kantineaanbod);


    }

    public void dagelijsKortingArtikel(){
        int randomArtikel = random.nextInt(AANTAL_ARTIKELEN);
        artikelprijzen[randomArtikel] = artikelprijzen[randomArtikel] * 0.8;

        Artikel kortingsArtikel = new Artikel(artikelnamen[randomArtikel], (int) artikelprijzen[randomArtikel], 0.2);
    }

    public void runVoorbeeld() {
        manager = ENTITY_MANAGER_FACTORY.createEntityManager();

        // transactions omitted

        manager.close();
        ENTITY_MANAGER_FACTORY.close();
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
        omzet = new double[dagen];
        aantalArtikelenTotaal = new int[dagen];


        // for lus voor dagen
        for(int i = 0; i < dagen; i++) {

            // bedenk hoeveel personen vandaag binnen lopen
            int aantalpersonen = getRandomValue(MIN_PERSONEN_PER_DAG, MAX_PERSONEN_PER_DAG);
            // variabelen maken voor het aantal studenten, docenten, medewerkers (klanten)
            int aantalStudenten = 100;
            int aantalDocenten = 10;
            int aantalMedewerkers = 1;

            //random variabelen
//            int aantalStudentenRan = random.nextInt(100 - 89 + 1) + 89;
//            int aantalMedewerkersRan = random.nextInt(100 - 1 + 1) + 1;
//            int aantalDocentenRan = random.nextInt(100 - 10 + 1) + 10;

//            int randomVar = random.nextInt(100);

            // laat de personen maar komen...
            for (int j = 0; j < aantalpersonen; j++) {

                //random variabele voor de kansen
                int randomVar = random.nextInt(100);

                //Persoon object aanmaken
                Persoon p1;
                Dienblad dienblad;

                // maak personen en dienblad aan, koppel ze
                // en bedenk hoeveel artikelen worden gepakt
                if(randomVar == 1) {
                    p1 = new KantineMedewerker(1, "Piet", "Friet", new Datum(1, 03, 2001), 'm', 2, false);
                    Betaalwijze c = new Contant();
                    p1.setBetaalwijze(c);
                    c.setSaldo(getRandomValue(3, 50));
                }
                else if(randomVar > 1 && randomVar <= 11) {
                    p1 = new Docent(2, "Klaas", "de Klein", new Datum(03, 05, 1992), 'm', "KLKL", "INF");
                    Betaalwijze c = new Contant();
                    p1.setBetaalwijze(c);
                    c.setSaldo(getRandomValue(10, 25));
                }

                else {
                    p1 = new Student(3, "Joost", "Proost", new Datum(02, 04, 2002), 'm', 387107);
                    Pinpas p = new Pinpas();
                    p.setKredietLimiet(10);
                    p1.setBetaalwijze(p);
                    p.setSaldo(getRandomValue(6, 40));


                }
                //System.out.println(p1.toString() + "\n");
                dienblad = new Dienblad(p1);
                //  dienblad.setKlant(p1);
                p1.pakDienblad(dienblad);
                //System.out.println(dienblad.getKlant());
             /*   Betaalwijze betaalwijze;
                String typebetalwijze;
                int random = getRandomValue(1, 2);
                if (random == 1) {
                    betaalwijze = new Contant();
                    typebetalwijze = "contant";
                }
                else
                {
                    betaalwijze = new Pinpas();
                    ((Pinpas)betaalwijze).setKredietLimiet(getRandomValue(-10, 0));
                    typebetalwijze = "pinpas";
                }
                p1.setBetaalwijze(betaalwijze);
                betaalwijze.setSaldo(getRandomValue(10,100)); */


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
            aantalArtikelenTotaal[i] = kantine.getKassa().aantalArtikelen();


            // reset de kassa voor de volgende dag
            kantine.getKassa().resetKassa();

        }

        double gemPersoon = Administratie.berekenGemiddeldAantal(aantalpersonenTotaal);
        System.out.println("Gemiddelde aantal personen per dag: " + gemPersoon + "\n");

        double gemOmzet = Administratie.berekenGemiddeldeOmzet(omzet);
        System.out.println("Gemiddelde omzet per dag: " + gemOmzet + "\n");

        double gemArtikelen = Administratie.berekenGemiddeldAantal(aantalArtikelenTotaal);
        System.out.println("Gemiddelde artikelen verkocht per dag: " + gemArtikelen + "\n");

        double[] gemDagOmzet = Administratie.berekenDagOmzet(omzet);
        String[] dagVanDeWeek = new String[]{"maandag", "dinsdag", "woensdag", "donderdag", "vrijdag", "zaterdag", "zondag"};
        for(int i =0; i < dagVanDeWeek.length; i++) {
            System.out.println("Op " + dagVanDeWeek[i] + " was de dagomzet: " + gemDagOmzet[i]);
        }

        Query totaalQuery = manager.createNativeQuery("SELECT SUM(totaalbedrag) FROM Factuur f");
        Query kortingQuery = manager.createNativeQuery("SELECT SUM(kortingsbedrag) FROM Factuur f");
        Query gemOmzetQuery = manager.createNativeQuery("SELECT AVG(totaalbedrag) FROM Factuur f");
        Query gemKorting = manager.createNativeQuery("SELECT AVG(kortingsbedrag) FROM Factuur f");
        Query maxFactuur = manager.createNativeQuery("SELECT totaalbedrag FROM Factuur f ORDER BY totaalbedrag DESC lIMIT 3");
        Query aantalPerArtikel = manager.createNativeQuery("SELECT count(artikel) FROM Factuurregel f GROUP BY artikel");
        Query totaalPerDag = manager.createNativeQuery("SELECT count(fr.artikel) FROM Factuurregel fr join Factuur f on fr.factuurnr = f.id GROUP BY f.datum");
        Query topArtikelen = manager.createNativeQuery("SELECT distinct(artikel) FROM Factuurregel fr ORDER BY artikel DESC LIMIT 3");
        Query hoogsteOmzetArtikelen = manager.createNativeQuery("SELECT distinct(artikel) FROM Factuurregel fr join Factuur f on fr.factuurnr = f.id ORDER BY totaalbedrag DESC LIMIT 3");

        double rs = (double)totaalQuery.getSingleResult();
        double rs2 = (double)kortingQuery.getSingleResult();
        double rs3 = (double)gemOmzetQuery.getSingleResult();
        double rs4 = (double)gemKorting.getSingleResult();
        List<Object[]> rs5 = maxFactuur.getResultList();
        List<Object[]> rs6 = aantalPerArtikel.getResultList();
        List<Object[]> rs7 = totaalPerDag.getResultList();
        List<Object[]> rs8 = topArtikelen.getResultList();
        List<Object[]> rs9 = hoogsteOmzetArtikelen.getResultList();

        System.out.println("Totale omzet: " + (rs-rs2) + ". Toegepaste korting: " + rs2);
        System.out.println("Gemiddelde omzet per factuur: " + rs3 + ". Gemiddelde toegepaste korting per factuur: " + rs4);
        for(Object o : rs5){
            System.out.println("Top factuur bedragen: " + o.toString());
        }

        for(int y=0; y<5; y++){
            if(y == 0){
                System.out.println("Aantal broodjes kaas: " + rs6.get(y));
            }
            if(y == 1){
                System.out.println("Aantal broodjes pindakaas: " + rs6.get(y));
            }
            if(y == 2){
                System.out.println("Aantal appelsap: " + rs6.get(y));
            }
            if(y == 3){
                System.out.println("Aantal koffie: " + rs6.get(y));
            }
        }

        for(Object o : rs7){
            System.out.println("Omzet per dag: " + o.toString());
        }
        for(Object o : rs8){
            System.out.println("Top artikelen: " + o.toString());
        }
        for (Object o : rs9) {
            System.out.println("Top artikelen hoogste omzet: " + o.toString());
        }
        manager.close();
        ENTITY_MANAGER_FACTORY.close();
    }
    public static void main(String[] args){
        KantineSimulatie_2 kantineSimulatie = new KantineSimulatie_2();
        kantineSimulatie.simuleer(7);
    }




}