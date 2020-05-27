public class Docent extends Persoon {

    private String afkorting;
    private String afdeling;

    public Docent(int BSN, String voornaam, String achternaam, Datum geboortedatum, char geslacht, String afkorting, String afdeling) {
        //Antwoord 4b: De subclass is een instantie van de superclass en de constructor van de superclass moet dan eerst aangeroepen worden.
        //Als de code van een subclass gerund kan worden voor de superclass dan zou het de initialisatie van de superclass kunnen verpesten.
        super(BSN, voornaam, achternaam, geboortedatum, geslacht);
        setAfkorting(afkorting);
        setAfdeling(afdeling);
    }

    public void setAfkorting(String newAfkorting){
        this.afkorting = newAfkorting.substring(0, 3);
    }

    public void setAfdeling(String newAfdeling){
        this.afdeling = newAfdeling;
    }

    public String getAfkorting(){
        return afkorting;
    }

    public String getAfdeling(){
        return afdeling;
    }


}
