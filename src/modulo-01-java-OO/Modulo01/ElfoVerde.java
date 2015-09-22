
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
   public void adicionarItem(){
       Item item1=new Item("Espada de aço valiriano",1);
       Item item2=new Item("Arco e Flecha de Vidro",1);
       inventario.adicionarItem(item1);
       inventario.adicionarItem(item2);
    }
    public void atirarFlexa(){
        this.experiencia+=2;
        this.flechas--;
    }
}
