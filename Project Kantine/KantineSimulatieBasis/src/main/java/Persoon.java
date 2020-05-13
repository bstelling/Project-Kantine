public class Persoon {

    private int BSN;
    private String voornaam;
    private String achternaam;
    private Datum geboortedatum;
    private char geslacht;


    /**
     * Methode om BSN te setten.
     *
     * @param BSN
     */
    public void setBSN(int BSN) {
        this.BSN = BSN;
    }

    /**
     * Setter om de voornaam in te stellen.
     *
     * @param voornaam
     */
    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    /**
     * Setter om de achternaam in te stellen.
     *
     * @param achternaam
     */
    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    /**
     * Setter om de geboortedatum in te stellen.
     *
     * @param geboortedatum
     */
    public void setGeboortedatum(Datum geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    /**
     * Setter om geslacht in te stellen. Converteert naar kleine letters en controleert op M/V voordat het geslacht geset wordt.
     *
     * @param geslacht
     */
    public void setGeslacht(char geslacht) {
        Character.toLowerCase(geslacht);
        if((geslacht == 'm') || (geslacht == 'v')) {
            this.geslacht = geslacht;
        }
        else{
            System.out.println("Geslacht " + "\"" + geslacht + "\"" + "is onbekend." );
        }
    }

    /**
     * Methode om het geslacht te retourneren als String.
     *
     * @return
     */
    public char getGeslacht(){
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
    }

