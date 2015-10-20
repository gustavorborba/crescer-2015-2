import java.util.ArrayList;
public class EstrategiaPreparacao
{
    private ArrayList<Elfo> ultimoAtaque;
    public boolean eElfoNoturno(Elfo elfo){
        if(elfo instanceof ElfoNoturno){
            return true;
        }
        return false;
    }    
    public boolean eElfoVerde(Elfo elfo){
        if(elfo instanceof ElfoVerde){
            return true;
        }
        return false;
    }    
}
