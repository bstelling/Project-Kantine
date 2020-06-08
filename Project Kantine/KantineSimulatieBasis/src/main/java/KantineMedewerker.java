public class KantineMedewerker extends Persoon implements KortingskaartHouder {

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

    @Override
    public double geefKortingsPercentage() {
        return 0.35;
    }

    @Override
    public boolean heeftMaximum() {
        return false;
    }

    @Override
    public double geefMaximum() {
        return 0;
    }
}