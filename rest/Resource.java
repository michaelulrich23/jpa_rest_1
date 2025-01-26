package rest;

//import Jedlo;
//import Ponuka;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("ponuka")
public class Resource {

    //private List<String> ponuka;
    private Ponuka ponuka;

    public Resource() {
        this.ponuka = new Ponuka();
        List<Jedlo> l = new ArrayList<>();
        Jedlo j = new Jedlo("gulas", 3.5);
        l.add(1, j);
        ponuka.getJedla().put("20-5-2024", l);
    }

    
    @GET
    @Path("{datum}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getPocetJedal(@PathParam("datum") String d) {
        if(!ponuka.getJedla().containsKey(d)){
            return "" + 0;
        }
        return "" + ponuka.getJedla().get(d).size();
    }
    
    @POST
    @Path("{datum}")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.TEXT_PLAIN)
    public String newJedlo(@PathParam("datum") String d, Jedlo content) {
        if(ponuka.getJedla().get(d) == null){
            ponuka.getJedla().put(d, new ArrayList<>());
        }
        
        int i = 1;
        for(Jedlo j : ponuka.getJedla().get(d)){
            if(j == null){
                break;
            }
            if(content.getNazov().equals(j.getNazov())){
                return "" + i;
            }
            i++;
        }
        
        ponuka.getJedla().get(d).add(ponuka.getJedla().get(d).size(), content);
        return "" + (ponuka.getJedla().get(d).size()-1);
        
        
    }
    
    
    @GET
    @Path("{datum}/{n}")
    @Produces(MediaType.APPLICATION_XML)
    public Jedlo getJedlo(@PathParam("datum") String d, @PathParam("n") int n) {
        return ponuka.getJedla().get(d).get(n);
    }
    
    @DELETE
    @Path("{datum}/{n}")
    public void deleteJedlo(@PathParam("datum") String d, @PathParam("n") int n) {
        ponuka.getJedla().get(d).remove(n);
    }
    
    
    
   
}
