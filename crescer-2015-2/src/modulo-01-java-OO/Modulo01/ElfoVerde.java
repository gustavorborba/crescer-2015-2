
/**
 * Write a description of class Elfo_Verde here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoVerde extends Elfo
{
   
   public ElfoVerde(String novoNome){
       super(novoNome);
    }
   public void adicionarItem(Item item){
       boolean podeAdicionar=item.getDescricao().equals("Espada de aço valiriano") || item.getDescricao().equals("Arco e Flecha de Vidro");
       if(podeAdicionar){
           super.adicionarItem(item);
        }
    }
    public void atirarFlecha(Dwarf anao){
        this.experiencia+=2;
        this.flechas--;
        anao.atacado();
    }
}
