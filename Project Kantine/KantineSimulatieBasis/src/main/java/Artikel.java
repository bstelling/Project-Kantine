public class Artikel {

    private String naam;
    private int prijs;

    //met initialisatie wordt bedoeld dat je iets initialiseert, wat voor langere tijd houdbaar is
    // en declaratie is een bewering die waar of onwaar is.

    public Artikel(String naam, int prijs) {

    }


    public void setNaam(String newNaam){
        this.naam = newNaam;

    }
    public void setPrijs(int newPrijs){
        this.prijs = newPrijs;
    }

    public String getNaam() {
        return naam;
    }

    public int getPrijs(){
        return prijs;

    }
}
