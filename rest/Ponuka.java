package rest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ponuka implements Serializable {
    private Map<String, List<Jedlo>> jedla;
    //private List<Jedlo> jedla;
    //private String datum;
    
    public Ponuka(){
        jedla = new HashMap<>();
        //jedla = new ArrayList<>();
    }

    /*public void addJedlo(Jedlo jedlo) {
        this.getJedla().add(jedlo);
    }*/

    @XmlElement(name="jedlo")
    public Map<String, List<Jedlo>> getJedla() {
        return jedla;
    }

    public void setJedla(Map<String, List<Jedlo>> jedla) {
        this.jedla = jedla;
    }

    

}
