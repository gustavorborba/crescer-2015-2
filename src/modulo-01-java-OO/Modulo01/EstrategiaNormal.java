import java.util.ArrayList;
/**
 * Write a description of class EstrategiaNormal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EstrategiaNormal extends EstrategiaPreparacao implements EstrategiaDeAtaque{
    private ArrayList<Elfo> ultimoAtaque=new ArrayList<>();
    public EstrategiaNormal(){}
    public void atacar(ArrayList<Dwarf> anoesHorda,ArrayList<Elfo> elfosArmy){
        this.ultimoAtaque.clear();
        int intencao=anoesHorda.size()*elfosArmy.size();
        int elfosNoturnosQuePodem=(int)(intencao*0.3);
        int contadorElfos=0;
        for(Elfo elfo : elfosArmy){
            for(Dwarf anao : anoesHorda){
                if(eElfoNoturno(elfo)){
                    if(contadorElfos<=elfosNoturnosQuePodem){
                        contadorElfos++;
                        elfo.atirarFlecha(anao);
                        ultimoAtaque.add(elfo);
                    }
                        
                }else{
                    elfo.atirarFlecha(anao);
                    ultimoAtaque.add(elfo);
                }
        }
    }
    }
    public ArrayList<Elfo> getUltimoAtaque(){
        return ultimoAtaque;
    }
}
