
import java.util.ArrayList;
public class EstrategiaFriamenteCalculado extends EstrategiaPreparacao implements EstrategiaDeAtaque{
    ArrayList<Elfo> ultimoAtaque=new ArrayList<>();
  
    public void atacar(ArrayList<Dwarf> anoesHorda,ArrayList<Elfo> elfosArmy){
        int vidaLimite=70;
        for(Elfo elfo : elfosArmy){
            ultimoAtaque.add(elfo);
            for(Dwarf anao : anoesHorda){
                if(eElfoNoturno(elfo) && (int)elfo.getVida()<=vidaLimite){
                      break;
                }else{
                    elfo.atirarFlecha(anao);
                }
            }
        }
    }
    public ArrayList<Elfo> getUltimoAtaque(){
        return ultimoAtaque;
    }
}
