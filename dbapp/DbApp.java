package dbapp;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DbApp {

    // Implementovat
    public static Predmet novyPredmet(EntityManager em, String nazov, String meno) throws Exception {
        if(nazov == null || nazov.isEmpty()) throw new Exception("chyba");
        Query q = em.createQuery("select p from Predmet p WHERE p.nazov = :nazov", Predmet.class);
        q.setParameter("nazov", nazov);
        Predmet p = (Predmet) q.getSingleResult();
        if(p != null){
            throw new Exception("duplicita");
        }
        
        Predmet novypredmet = new Predmet();
        novypredmet.setNazov(nazov);
        if(meno == null || meno.isEmpty()) return novypredmet;
        Ucitel u = new Ucitel();
        u.setMeno(meno);
        novypredmet.setPrednasajuci((Docent) u);
        Set<Ucitel> c = new HashSet<>();
        c.add(u);
        novypredmet.setCviciaci(c);
        
        return novypredmet;
        //throw new Exception("TODO");
    }

    // len pre vase otestovanie. Mozete si upravit.
    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbappPU");
        EntityManager em = emf.createEntityManager();

        novyPredmet(em, "PT", "Jano");        
    }

}
