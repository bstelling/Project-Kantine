import javax.persistence.*;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Factuur implements Serializable {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("KantineSimulatie");
     private EntityManager manager;

    @Id
    private Long id;

    private LocalDate datum;

    @ManyToOne
    private ArrayList<FactuurRegel> regels;

    private double korting;

    private double totaal;

         public Factuur() {
         totaal = 0;
         korting = 0;
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
         private void verwerkBestelling(Dienblad klant) {
             Iterator<Artikel> artikelen = klant.getIterator();
             double totaal = 0;
             boolean hasKorting = false;

             while (artikelen.hasNext()) {
                 Artikel artikel = artikelen.next();
                 if (artikel.getKorting() != 0) {
                     totaal += artikel.getPrijs() * 0.8;
                     hasKorting = true;
                 } else {
                     totaal += artikel.getPrijs();
                 }
                 FactuurRegel artikelregel = new FactuurRegel(new Factuur(), artikel);
             }
             //kijkt of er korting moet worden gegeven en hoeveel dat dan is.
             // and nog maximum nu kirjgt kantinemedewerker geen geld
             if (!hasKorting) {
                 if (klant instanceof KortingskaartHouder) {
                     double korting = totaal * (((KortingskaartHouder) klant).geefKortingsPercentage());
                     if (((KortingskaartHouder) klant).heeftMaximum()) {
                         if (korting > ((KortingskaartHouder) klant).geefMaximum()) {
                             korting = ((KortingskaartHouder) klant).geefMaximum();
                         }
                     }
                     totaal -= korting;
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
 46 * @return de toegepaste korting
 47 */
         public double getKorting() {
         return korting;
         }

         /**
 53 * @return een printbaar bonnetje
 54 */
         public String toString() {
         // method body omitted
             //FactuurRegel.toString();
             String bonnetje = regels.toString() + "\n" + "U heeft: " + totaal + " betaald.\n" + "U heeft: " + korting + " aan korting gehad.";
             return bonnetje;
         }
 }
