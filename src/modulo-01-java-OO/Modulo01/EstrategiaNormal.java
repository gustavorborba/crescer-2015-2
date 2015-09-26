import java.util.ArrayList;
/**
 * Write a description of class EstrategiaNormal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EstrategiaNormal implements EstrategiaDeAtaque{
    ArrayList<Elfo> ultimoAtaque=new ArrayList<>();
    public EstrategiaNormal(){}
    public boolean eElfoNoturno(Elfo elfo){
        if(elfo instanceof ElfoNoturno){
            return true;
        }
        return false;
    }    
    public void atacar(ArrayList<Dwarf> anoesHorda,ArrayList<Elfo> elfosArmy){
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
