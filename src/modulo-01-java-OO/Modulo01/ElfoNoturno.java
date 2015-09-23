
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
      if(status==Status.VIVO){
      flechas--;
      experiencia+=3;
      anao.atacado();
      double vidaPerder=vida*0.05;
      this.vida-=vidaPerder;
    }
    if(this.vida<1){
        status=Status.MORTO;
    }
}
    public void perdeVida(){
      double vidaPerder=vida*0.05;
      this.vida-=vidaPerder;
    }  
}
