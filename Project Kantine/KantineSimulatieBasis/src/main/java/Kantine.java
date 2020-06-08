import java.util.ArrayList;
public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineaanbod;
//    private Persoon klant;

    public static double hoeveelheidGeld =0;
    public static int hoeveelheidArtikelen = 0;
    /**
     * Constructor
     */
    public Kantine() {
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij);
    }

    /**
     * Setter om de kantineaanbod variabele te setten.
     *
     * @param newKantineAanbod nieuwe kantineaanbod variabele
     */
    public void setKantineAanbod(KantineAanbod newKantineAanbod){
        this.kantineaanbod = newKantineAanbod;
    }

    /**
     * Getter om de kantineaanbod variabele te returnen.
     *
     * @return kantineaanbod
     */
    public KantineAanbod getKantineAanbod(){
        return kantineaanbod;
    }


    /**
     * In deze methode wordt een Persoon en Dienblad gemaakt en aan elkaar gekoppeld. Maak twee
     * Artikelen aan en plaats deze op het dienblad. Tenslotte sluit de Persoon zich aan bij de rij
     * voor de kassa.
     */

    public void loopPakSluitAan(Persoon persoon, String[] artikelnamen) {
//        Persoon klant = new Persoon(412, "Peter", "de Groot", new Datum(28,3,2001), 'm');
//        Dienblad dienblad = new Dienblad(klant);
//
//        Artikel artikel1 = new Artikel("Brood", 2);
//        Artikel artikel2 = new Artikel("Koffie", 4);
//
//        dienblad.voegToe(artikel1);
//        dienblad.voegToe(artikel2);
//
//        kassarij.sluitAchteraan(dienblad);

        //for-loop om door alle artikelnamen te gaan
        for(int i = 0; i < artikelnamen.length; i++){
            //artikel object die bij de artikel string hoort ophalen
            Artikel artikel = kantineaanbod.getArtikel(artikelnamen[i]);
            //artikel toevoegen aan het dienblad
            persoon.getDienblad().voegToe(artikel);
            //dienblad achteraan aansluiten
            kassarij.sluitAchteraan(persoon);
        }
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while (kassarij.erIsEenRij()) {
            kassa.rekenAf(kassarij.eerstePersoonInRij());
        }
    }

    /**
     * Getter om de kassa variabele te returnen.
     *
     * @return de kassa variabele
     */
    public Kassa getKassa(){
        return kassa;
    }

    /**
     * Deze methode reset de bijgehouden telling van het aantal artikelen en "leegt" de inhoud van
     * de kassa.
     */
    public void resetKassa() {
        hoeveelheidArtikelen = 0;
        hoeveelheidGeld = 0;
    }
}
