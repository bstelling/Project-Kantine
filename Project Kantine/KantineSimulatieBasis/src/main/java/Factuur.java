import javax.persistence.*;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table (name = "Factuur")
public class Factuur implements Serializable {

    /*
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("KantineSimulatie");
    private EntityManager manager;
*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column (name = "datum", nullable = false)
    private LocalDate datum;

    @OneToMany(targetEntity = FactuurRegel.class, mappedBy = "factuur",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FactuurRegel> regels;

    @Column (name = "kortingsbedrag", nullable = false)
    private double korting;

    @Column (name = "totaalbedrag", nullable = false)
    private double totaal;

    private int aantalArtikelen;

    public Factuur() {
        totaal = 0;
        korting = 0;

        regels = new ArrayList<>();
    }
    public Factuur(Dienblad klant, LocalDate datum) {
        this();
        this.datum = datum;

        verwerkBestelling(klant);
    }

    /**
     27 * Verwerk artikelen en pas kortingen toe.
     28 *
     29 * Zet het totaal te betalen bedrag en het
     30 * totaal aan ontvangen kortingen.
     31 *
     32 * @param klant
     33 */


    private void verwerkBestelling(Dienblad klant){

        aantalArtikelen = 0;

        Iterator<Artikel> it = klant.getDienblad();
        while(it.hasNext()){
            Artikel a = it.next();
            FactuurRegel regel = new FactuurRegel(this, a.getNaam());
            regels.add(regel);
            totaal += a.getPrijs();
            if(a.getKorting() > 0){
                korting += a.getKorting();
            }

            aantalArtikelen++;
        }

        Persoon persoon = klant.getKlant(); // de klant

        // korting berekenen

        if(persoon instanceof KortingskaartHouder){
            KortingskaartHouder klantMetKorting = (KortingskaartHouder) persoon; // casten

            if(klantMetKorting.heeftMaximum()){
                if((klantMetKorting.geefKortingsPercentage()*totaal) < klantMetKorting.geefMaximum()){
                    korting += (klantMetKorting.geefKortingsPercentage()*totaal); // haal korting van het bedrag af
                }else{
                    korting += klantMetKorting.geefMaximum(); // haal max van het bedrag af
                }
            }else{
                korting += (klantMetKorting.geefKortingsPercentage()*totaal); // haal korting van het bedrag af
            }
        }
    }

     
    /*
     * @return het totaalbedrag
     */
    public double getTotaal() {
        return totaal;
    }

    /**
      * @return de toegepaste korting
      */
    public double getKorting() {
        return korting;
    }

    public int getAantalArtikelen() {
        return aantalArtikelen;
    }

    /**
      * @return een printbaar bonnetje
      */
    public String toString() {
        // method body omitted
        //FactuurRegel.toString();
        String bonnetje = regels.toString() + "\n" + "U heeft: " + totaal + " betaald.\n" + "U heeft: " + korting + " aan korting gehad.";
        return bonnetje;
    }
}