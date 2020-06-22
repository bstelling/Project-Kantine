import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.Iterator;

public class Kassa {

    /**
     * ArrayList kassarij voor de kassarij.
     * kassaBalans houdt het aantal geld in de kassa bij.
     * aantalKassaArtikelen houdt het aantal artikelen bij dat de kassa gepasseerd is.
     */
    private KassaRij kassarij;
    private double kassaBalans;
    private int aantalKassaArtikelen;
    private javax.persistence.EntityManager manager;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij, EntityManager manager) {
        // method body omitted
        this.kassarij = kassarij;
        aantalKassaArtikelen = 0;
        kassaBalans = 0;
        this.manager = manager;
    }

        public Dienblad getDienblad(Persoon persoon)
        {
            return persoon.getDienblad();
        }
    /**
     * Vraag het aantal artikelen en de totaalprijs op. Tel deze gegevens op bij de controletotalen
     * die voor de kassa worden bijgehouden. De implementatie wordt later vervangen door een echte
     * betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Persoon klant)
    {
        Factuur factuur = new Factuur();
        Dienblad dienblad = klant.getDienblad();
        Iterator<Artikel> artikelen = dienblad.getIterator();
        EntityTransaction transaction = null;

        double totaal = factuur.getTotaal();
        double korting = factuur.getKorting();



        try{
            klant.getBetaalwijze().betaal(totaal);
            kassaBalans += totaal;
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(totaal);
            manager.persist(korting);
            transaction.commit();
        }
        catch(TeWeinigGeldException e){
            System.out.println(klant.getVoornaam()+ " " + klant.getAchternaam()+" kan de artikelen niet betalen.");
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }



    }


    //klant.getAantalArtikelen();
        //klant.getTotaalPrijs();

//        kassaBalans += klant.getTotaalPrijs();
//        aantalKassaArtikelen += klant.getAantalArtikelen();


    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd, vanaf het moment dat de methode
     * resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
        // method body omitted
        return aantalKassaArtikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass zijn gepasseerd, vanaf het moment dat
     * de methode resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        // method body omitted
        return kassaBalans;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en de totale hoeveelheid geld in de
     * kassa.
     */
    public void resetKassa() {
        // method body omitted
        this.kassaBalans = 0;
        this.aantalKassaArtikelen = 0;

    }
}