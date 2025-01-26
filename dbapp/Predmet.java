package dbapp;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Predmet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String nazov;  
    @ManyToMany
    private Set<Ucitel> cviciaci;           // osoby ktore ucia predmet
    @OneToMany(mappedBy = "prednasky")
    private Docent prednasajuci;                   

   public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public Docent getPrednasajuci() {
        return prednasajuci;
    }

    public void setPrednasajuci(Docent prednasajuci) {
        this.prednasajuci = prednasajuci;
    }

    public Set<Ucitel> getCviciaci() {
        return cviciaci;
    }

    public void setCviciaci(Set<Ucitel> cviciaci) {
        this.cviciaci = cviciaci;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Predmet other = (Predmet) obj;
        if (!Objects.equals(this.nazov, other.nazov)) {
            return false;
        }
        return true;
    }

}
