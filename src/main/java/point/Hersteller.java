package point;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Hersteller {
    @Id
    private Long id;
    private String herstellerName;
    @OneToMany(mappedBy = "hersteller")
    private Set<Produkt> produkte = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHerstellerName() {
        return herstellerName;
    }

    public void setHerstellerName(String name) {
        this.herstellerName = name;
    }
}
