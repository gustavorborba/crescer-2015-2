import java.util.ArrayList;
/**
 * Write a description of class EstrategiaNormal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EstrategiaNormal implements EstrategiaDeAtaque{
    private ArrayList<Elfo> elfosDisponivel=new ArrayList<>();
    public EstrategiaNormal(ArrayList<Elfo> novosElfos){
        elfosDisponivel=novosElfos;
    }
    public ArrayList<Elfo> getElfosNisponiveis(){
        return elfosDisponivel;
    }
    public int getQuantidadeNoturno(){
        int qtElfoNoturno=0;
        for(Elfo elfo : elfosDisponivel){
            if(elfo instanceof ElfoNoturno){
                qtElfoNoturno++;
            }
        }
        return qtElfoNoturno;
    }
    public boolean elfoNoturnoAtaque(Elfo elfo){
        if(elfo instanceof ElfoNoturno){
            return true;
        }
        return false;
    }
    public ArrayList<Elfo> getElfosQuePodemAtacar(ArrayList<Dwarf> anoesHorda){
        int intencao,contadorElfoNoturno=0;
        double elfosNoturnosPodem;
        ArrayList<Elfo> iraoAtacar=new ArrayList<>();
        intencao=(anoesHorda.size()*elfosDisponivel.size());
        elfosNoturnosPodem=(int)(intencao*0.3);
        for(Elfo elfo : elfosDisponivel){
            if(elfoNoturnoAtaque(elfo)){
                if(elfosNoturnosPodem>=contadorElfoNoturno){
                contadorElfoNoturno++;
                iraoAtacar.add(elfo);
                }
        }else{
             iraoAtacar.add(elfo);
        }
    }
        return iraoAtacar;
    
    }
    public void atacar(ArrayList<Dwarf> anoesHorda){
        ArrayList<Elfo> iraoAtacar=getElfosQuePodemAtacar(anoesHorda);
        for(Elfo elfo : iraoAtacar){
            for(Dwarf anao : anoesHorda){
                elfo.atirarFlecha(anao);
            }
        }
    }
 
}
