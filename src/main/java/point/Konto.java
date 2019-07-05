package point;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Konto {
    @Id
    private Long kontonummer;
    private BigDecimal kontostand;
    @ManyToMany(mappedBy = "konten")
    private Set<Kunde> kunden = new HashSet();
// getter- und setter-Methoden für alle Attribute


    public Long getKontonummer() {
        return kontonummer;
    }

    public void setKontonummer(Long kontonummer) {
        this.kontonummer = kontonummer;
    }

    public BigDecimal getKontostand() {
        return kontostand;
    }

    public void setKontostand(BigDecimal kontostand) {
        this.kontostand = kontostand;
    }

    public Set<Kunde> getKunden() {
        return kunden;
    }

    public void setKunden(Set<Kunde> kunden) {
        this.kunden = kunden;
    }
}
