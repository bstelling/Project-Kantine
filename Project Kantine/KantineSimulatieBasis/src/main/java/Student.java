public class Student extends Persoon {

    private int studentNummer;

    public Student(int BSN, String voornaam, String achternaam, Datum geboortedatum, char geslacht, int studentNummer) {
        super(BSN, voornaam, achternaam, geboortedatum, geslacht);
        setStudentNummer(studentNummer);
    }

    public Student() {
    }

    public void setStudentNummer(int newStudentNummer){
        this.studentNummer = newStudentNummer;
    }

    public int getStudentNummer(){
        return studentNummer;
    }
}
