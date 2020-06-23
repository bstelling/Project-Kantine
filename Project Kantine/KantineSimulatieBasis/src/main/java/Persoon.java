public class Persoon {

    private int BSN;
    private String voornaam;
    private String achternaam;
    private Datum geboortedatum;
    private char geslacht;
    private Betaalwijze betaalwijze;

    private Dienblad dienblad;
    /**
     * Constructor
     */
    public Persoon(int BSN, String voornaam, String achternaam, Datum geboortedatum, char geslacht) {
        this.BSN = BSN;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        setGeslacht(geslacht);
    }

    /**
     * Parameterloze constructor met foute waarden.
     */
    public Persoon() {
        this.geboortedatum = new Datum(34, 1, 1997);
        this.geslacht = 'K';
    }

    /**
     * Methode om BSN te setten.
     *
     * @param BSN Burgerservicenummer
     */
    public void setBSN(int BSN) {
        this.BSN = BSN;
    }

    /**
     * Setter om de voornaam in te stellen.
     *
     * @param voornaam voornaam van de persoon
     */
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    /**
     * Setter om de achternaam in te stellen.
     *
     * @param achternaam achternaam van de persoon
     */
    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    /**
     * Setter om de geboortedatum in te stellen.
     *
     * @param geboortedatum geboortedatum van de persoon
     */
    public void setGeboortedatum(Datum geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    /**
     * Setter om geslacht in te stellen.
     *
     * @param geslacht geslacht van de persoon
     */
    public void setGeslacht(char geslacht) {
        if(checkGeslacht(geslacht)){
            this.geslacht = geslacht;
        }
        else{
            System.out.println("Geslacht " + "\"" + geslacht + "\"" + "is onbekend." );
        }
    }

    /**
     * Methode die geslacht controleert.
     *
     * @param geslacht dat je wilt checken.
     */

    public boolean checkGeslacht(char geslacht){
        Character.toLowerCase(geslacht);
        return (geslacht == 'm') || (geslacht == 'v');
    }

    // private int BSN;
    //    private String voornaam;
    //    private String achternaam;
    //    private Datum geboortedatum;
    //    private char geslacht;

    /**
     * Methode om BSN-nummer terug te geven.
     *
     * @return het BSN nummer
     */
    public int getBSN(){
        return BSN;
    }

    /**
     * Methode om de voornaam terug te geven.
     *
     * @return de voornaam
     */
    public String getVoornaam(){
        return voornaam;
    }

    /**
     * Methode om de achternaam terug te geven.
     *
     * @return de achternaam
     */
    public String getAchternaam(){
        return achternaam;
    }

    /**
     * Methode om het geslacht weer te geven in volle benaming.
     *
     *
     */
    public void getGeslacht(){
        if(geslacht == 'm') {
            System.out.println("Man");
        }
        else if(geslacht == 'v'){
            System.out.println("Vrouw");
        }
        else{
            System.out.println("Onbekend");
        }
    }

    /**
     * Methode on geboortedatum als String te retourneren.
     *
     * @return geboortedatum als String.
     */
    public String getGeboortedatum() {
        String geboortedatumString;
        geboortedatumString = geboortedatum.getDatumAsString();
        return geboortedatumString;
    }

    @Override
    public String toString() {
        return "Persoon{" +
                "BSN=" + BSN +
                ", voornaam='" + voornaam + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", geboortedatum=" + geboortedatum +
                ", geslacht=" + geslacht +
                '}';
    }

    public Betaalwijze getBetaalwijze(){
        return betaalwijze;
    }

    public void setBetaalwijze(Betaalwijze betaalwijze) {
        this.betaalwijze = betaalwijze;
    }
    public void pakDienblad(Dienblad dienblad){
        if (dienblad != null)
        {
            this.dienblad = dienblad;
        }
    }

    public Dienblad getDienblad()
    {
        return dienblad;
    }


}



