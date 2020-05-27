public class KantineMedewerker extends Persoon {

    private int medewerkersNummer;
    private boolean achterDeKassa;

    public KantineMedewerker(int BSN, String voornaam, String achternaam, Datum geboortedatum, char geslacht, int medewerkersNummer, boolean achterDeKassa) {
        super(BSN, voornaam, achternaam, geboortedatum, geslacht);
        setMedewerkersNummer(medewerkersNummer);
        setAchterDeKassa(achterDeKassa);
    }

    public void setMedewerkersNummer(int newMedewerkersNummer){
        this.medewerkersNummer = newMedewerkersNummer;
    }

    public void setAchterDeKassa(boolean newAchterDeKassa){
        this.achterDeKassa = newAchterDeKassa;
    }

    public int getMedewerkersNummer(){
        return medewerkersNummer;
    }

    public boolean getAchterDeKassa(){
        return achterDeKassa;
    }

}
