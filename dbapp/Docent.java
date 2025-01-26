package dbapp;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Docent extends Ucitel implements Serializable {

    private static final long serialVersionUID = 1L;
    @ManyToOne
    private List<Predmet> prednasky;

    public List<Predmet> getPrednasky() {
        return prednasky;
    }

    public void setPrednasky(List<Predmet> prednasky) {
        this.prednasky = prednasky;
    }

}
