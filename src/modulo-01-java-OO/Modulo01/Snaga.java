
/**
 * Write a description of class Sanaga here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snaga extends Orc
{
    public Snaga(String n){
        super();
        this.inventario.adicionarItem(new Item("Arco",1));
        this.inventario.adicionarItem(new Item("Flecha",5));
        this.vida=70;
    }
}
