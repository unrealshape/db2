package point;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Kunde {
    @Id
    private Long id;
    private String vorname;
    private String nachname;
    @ManyToMany
    private Set<Konto> konten = new HashSet();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Set<Konto> getKonten() {
        return konten;
    }

    public void setKonten(Set<Konto> konten) {
        this.konten = konten;
    }
}

