import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

public class FactuurRegel implements Serializable {

    @Id
    private Long id;

    @OneToMany
    private Factuur factuur;

    private Artikel artikel;

    public FactuurRegel() {}

    public FactuurRegel(Factuur factuur, Artikel artikel) {
        this.factuur = factuur;
        this.artikel = artikel;
    }

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("KantineSimulatie");
    private EntityManager manager;

    /**
     * @return een printbare factuurregel
     */
    public String toString() {
        // method body omitted
        String artikelRegel = "\n Artikel: " + artikel;
        return artikelRegel;
    }
}
