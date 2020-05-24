import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    private Persoon klant;
    private ArrayList<Artikel> artikelen;

    /**
     * Constructor
     */
    public Dienblad() {
        // method body omitted
        artikelen = new ArrayList<Artikel>();
    }

    /**
     * Constructor om een klant bij een Dienblad te voegen
     *
     * @param klant die je toe wilt voegen.
     */
    public Dienblad(Persoon klant){

        this.klant = klant;
    }

    /**
     * Methode om een klant te setten; setter
     *
     * @param klant die je wilt setten.
     */

    public void setKlant(Persoon newKlant){

        this.klant = newKlant;
    }

    /**
     * Methode om een klant terug te geven; getter
     *
     * @return de klant
     */

    public Persoon getKlant(){

        return klant;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        // method body omitted
        artikelen.add(artikel);
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
        // method body omitted
        return artikelen.size();
    }

    /**
     * Methode om de totaalprijs van de artikelen op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {
        // method body omitted
        double totaalPrijs = 0.0;

        for(Artikel artikel : artikelen){
            totaalPrijs = totaalPrijs + artikel.getPrijs();
        }
        return totaalPrijs;
    }
}

