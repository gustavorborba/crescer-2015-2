
/**
 * Write a description of class ExercitoElfico here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.HashMap;
import java.util.ArrayList;
public class ExercitoElfico
{
    private  HashMap<String,Elfo> exercito = new HashMap<String,Elfo>();
    private  HashMap<Status,ArrayList<Elfo>> agrupado = new HashMap<Status,ArrayList<Elfo>>();
    public ExercitoElfico(){}
    public void alistarElfo(Elfo elfo){
        exercito.put(elfo.getNome(),elfo);
    }
    public Elfo getElfoPorNome(String nome){
       Elfo elfo=exercito.get(nome);
       return elfo;
    }
    public void agruparPorStatus(){
        for(Elfo elf : exercito.values()){
            if(!agrupado.containsKey(elf.getStatus())){
                agrupado.put(elf.getStatus(),new ArrayList<Elfo>());
            }
            agrupado.get(elf.getStatus()).add(elf);
        }
    }
    public HashMap<Status,ArrayList<Elfo>> getAgrupado(){
        return agrupado;
    }
    public boolean equals(Object obj){
        ExercitoElfico outroExercito=(ExercitoElfico)obj;
        return this.agrupado.equals(outroExercito.getAgrupado());
    }
    public ArrayList<Elfo> buscar(Status status){
        if(agrupado.isEmpty()){
            agruparPorStatus();
        }
        return agrupado.get(status);
    }
}
