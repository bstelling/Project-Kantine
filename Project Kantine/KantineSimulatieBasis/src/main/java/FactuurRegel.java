import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
@Entity
@Table (name = "FactuurRegel")
public class FactuurRegel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id", unique = true)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "factuurnr")
    private Factuur factuur;

    @Column (name = "artikel")
    private String artikel;

    public FactuurRegel() {}

    public FactuurRegel(Factuur factuur, String artikel) {
        this.factuur = factuur;
        this.artikel = artikel;
    }

  /*  private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("KantineSimulatie");
    private EntityManager manager;
/*
    /**
     * @return een printbare factuurregel
     */
    public String toString() {
        // method body omitted
        String artikelRegel = "\n Artikel: " + artikel;
        return artikelRegel;
    }
}