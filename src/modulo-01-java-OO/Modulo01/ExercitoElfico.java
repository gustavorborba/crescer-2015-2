
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
    private ArrayList <Elfo> ultimoAtaque=new ArrayList<>();
    private EstrategiaDeAtaque ataque;
    public ExercitoElfico(){}
    public void alistarElfo(Elfo elfo){
        boolean podeAlistar= elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno;
        if(podeAlistar){
        exercito.put(elfo.getNome(),elfo);
    }
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
        agrupado.clear();
        agruparPorStatus();
        return agrupado.get(status);
    }
    
    public ArrayList<Elfo> getUltimoAtaque(){
        return ultimoAtaque;
    }
    public EstrategiaDeAtaque iniciarAtaque(){
        ataque=new EstrategiaNormal(this.buscar(Status.VIVO));
        return ataque;
    }
}
