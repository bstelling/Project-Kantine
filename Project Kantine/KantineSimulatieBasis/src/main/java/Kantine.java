import java.util.ArrayList;
public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineAanbod;
    private Persoon klant;

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
     * In deze methode wordt een Persoon en Dienblad gemaakt en aan elkaar gekoppeld. Maak twee
     * Artikelen aan en plaats deze op het dienblad. Tenslotte sluit de Persoon zich aan bij de rij
     * voor de kassa.
     */

    public void loopPakSluitAan(Dienblad klant, String[] artikelen) {
        if (artikelen.length>0) {
            //aantal artikelen bij langs lopen
            for (int i=0; i<artikelen.length; i++)
            {
                Artikel artikel = kantineAanbod.getArtikel(artikelen[i]);
                klant.voegToe(artikel);
            }
        }
        kassarij.sluitAchteraan(klant);
    }

    /**
     * Deze methode handelt de rij voor de kassa af.
     */
    public void verwerkRijVoorKassa() {
        while (kassarij.erIsEenRij() == true) {
            kassa.rekenAf(kassarij.eerstePersoonInRij());
        }
    }

    /**
     * Deze methode telt het geld uit de kassa
     *
     * @return hoeveelheid geld in kassa
     */
    public double hoeveelheidGeldInKassa() {
    return kassa.hoeveelheidGeldInKassa();
    }

    /**
     * Deze methode geeft het aantal gepasseerde artikelen.
     *
     * @return het aantal gepasseerde artikelen
     */
    public int aantalArtikelen() {
    return kassa.aantalArtikelen();
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
