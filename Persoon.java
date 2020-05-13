public class Persoon {
    private int BSN;
    private String Voornaam;
    private String Achternaam;
    private int Geboortedatum;
    private char Geslacht;

    public void setBSN(int BSN) {
        this.BSN = BSN;
    }

    public void setVoornaam(String voornaam) {
        Voornaam = voornaam;
    }

    public void setAchternaam(String achternaam) {
        Achternaam = achternaam;
    }

    public void setGeboortedatum(int geboortedatum) {
        Geboortedatum = geboortedatum;
    }

    public void setGeslacht(char geslacht) {
        if(Character.isLetter('M' )) {
            this.Geslacht = geslacht;
            else if (Character.isLetter('V')) {
                this.Geslacht = geslacht;
            }
        } else { this.Geslacht = '1'; }

    }
}
