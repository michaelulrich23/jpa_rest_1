package rest;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;

public class Jedlo implements Serializable {
    
    private String nazov;
    private double cena;
    
    @XmlElement
    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
    
    @XmlElement
    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public Jedlo() {
    }

    public Jedlo(String nazov, double cena) {
        this.nazov = nazov;
        this.cena = cena;
    }
}
