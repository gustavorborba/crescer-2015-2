
/**
 * Write a description of class ElfoNoturno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoNoturno extends Elfo{
    public ElfoNoturno(String novoNome){
        super(novoNome);
    }
    public void atirarFlecha(Dwarf anao){
        if(vida > 1){
        super.atirarFlecha(anao);
        experiencia+=2;
        double perdeVida=vida*0.05;
        vida-=perdeVida;
    }else{
        status=Status.MORTO;
    }
   }
}
