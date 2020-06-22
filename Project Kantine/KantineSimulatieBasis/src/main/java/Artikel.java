public class Artikel {

    private String naam;
    private int prijs;
    private double korting = 0;

    //  declaratie die declareert iets en initialisatie maak je iets aan om later te laten declareren.

    public Artikel(String naam, int prijs, double korting) {
        this.naam = naam;
        this.prijs = prijs;
        this.korting = korting;
    }


    public void setNaam(String newNaam){
        this.naam = newNaam;

    }
    public void setPrijs(int newPrijs){
        this.prijs = newPrijs;
    }

    public void setKorting(double newKorting){
        this.korting = newKorting;
    }

    public String getNaam() {
        return naam;
    }

    public double getPrijs(){
        return prijs;
    }

    public double getKorting(){
        return korting;
    }
}
