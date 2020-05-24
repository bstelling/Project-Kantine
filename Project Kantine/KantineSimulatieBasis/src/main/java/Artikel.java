public class Artikel {

    private String naam;
    private int prijs;

    //  declaratie die declareert iets en initialisatie maak je iets aan om later te laten declareren.

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
