package dbapp;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Ucitel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String meno;
    @ManyToMany(mappedBy = "cviciaci")
    private Set<Predmet> cvicenie;         // cvicenie ktore vyucuje

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public Set<Predmet> getCvicenie() {
        return cvicenie;
    }

    public void setCvicenie(Set<Predmet> cvicenie) {
        this.cvicenie = cvicenie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ucitel)) {
            return false;
        }
        Ucitel other = (Ucitel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Osoba[ id=" + id + " ]";
    }

}
