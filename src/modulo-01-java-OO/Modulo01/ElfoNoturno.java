
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
    public ElfoNoturno(String novoNome,int quantFlecha){
        super(novoNome,quantFlecha);
    }
    public void atirarFlecha(Dwarf anao){
        super.atirarFlecha(anao);
        this.experiencia += 2;
        double qtdVidaAPerder = this.vida * 0.05;
        this.vida -= qtdVidaAPerder;
        this.status = (int)this.vida == 0 ? Status.MORTO : this.status;
   }
}
