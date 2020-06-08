import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    private Persoon klant;
    private Stack<Artikel> artikelen;

    /**
     * Constructor
     */
    public Dienblad() {
        // method body omitted
        artikelen = new Stack<Artikel>();
    }

    /**
     * Constructor om een klant bij een Dienblad te voegen
     *
     * @param klant die je toe wilt voegen.
     */
    /*
    public Dienblad(Persoon klant){
        setKlant(klant);
    }
*/


    /**
     * Methode om een klant te setten; setter
     *
     * @param newKlant die je wilt setten.
     */
/*
    public void setKlant(Persoon newKlant){
        this.klant = newKlant;
    }
*/
    /**
     * Methode om een klant terug te geven; getter
     *
     * @return de klant
     */
/*
    public Persoon getKlant(){
        return klant;
    }
*/
    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        // method body omitted
        artikelen.push(artikel);
    }

    public Iterator<Artikel> getIterator(){
        return artikelen.iterator();
    }
}
