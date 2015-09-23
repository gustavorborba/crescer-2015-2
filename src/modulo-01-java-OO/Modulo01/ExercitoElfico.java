
/**
 * Write a description of class ExercitoElfico here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.HashMap;
public class ExercitoElfico
{
    private  HashMap<String,Elfo> exercito = new HashMap<String,Elfo>();
    public ExercitoElfico(){}
    public void alistarElfo(Elfo elfo){
        exercito.put(elfo.getNome(),elfo);
    }
    public Elfo getElfoPorNome(String nome){
       Elfo elfo=exercito.get(nome);
       return elfo;
    }
}
