
/**
 * Write a description of class Uruk_Hai here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Uruk_Hai extends Orc
{
    
    public Uruk_Hai(){
        super();
        super.adicionarItem(new Item("Escudo Uruk-Hai",1));
        super.adicionarItem(new Item("Espada",1));
        this.vida=150;
    }
}
