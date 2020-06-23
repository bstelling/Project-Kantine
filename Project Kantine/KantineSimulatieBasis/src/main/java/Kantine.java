import javax.persistence.EntityManager;
import java.util.ArrayList;
public class Kantine {

    private Kassa kassa;
    private KassaRij kassarij;
    private KantineAanbod kantineaanbod;
    private EntityManager manager;
//    private Persoon klant;

    public static double hoeveelheidGeld =0;
    public static int hoeveelheidArtikelen = 0;
    /**
     * Constructor
     */
    public Kantine(EntityManager manager) {
        this.manager = manager;
        kassarij = new KassaRij();
        kassa = new Kassa(kassarij, manager);

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

    public void loopPakSluitAan(Dienblad dienblad, String[] artikelnamen) {
        //for-loop om door alle artikelnamen te gaan
        for(int i = 0; i < artikelnamen.length; i++){
            //artikel object die bij de artikel string hoort ophalen
            Artikel artikel = kantineaanbod.getArtikel(artikelnamen[i]);
         /*   //korting artikel
            if(artikel.getKorting() != 0){
                int nieuwePrijs = (int) (artikel.getPrijs() * 0.8);
                artikel.setPrijs(nieuwePrijs);
            } */
            //artikel toevoegen aan het dienblad
            dienblad.voegToe(artikel);
            //dienblad achteraan aansluiten
            kassarij.sluitAchteraan(dienblad);
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