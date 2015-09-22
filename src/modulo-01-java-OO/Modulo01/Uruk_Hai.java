
/**
 * Write a description of class Uruk_Hai here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Uruk_Hai extends Orc
{
    
    public Uruk_Hai(String n){
        super();
        inventario.adicionarItem(new Item("Escudo Uruk-Hai",1));
        inventario.adicionarItem(new Item("Espada",1));
        this.vida=150;
    }
     public void atacarDwarf(Dwarf anao) {
        anao.atacadoPorOrc(12);
    }  
    public void atacarElfo(Elfo elf) {
        elf.atacadoPorOrc(12);  
}
    public void atacadoPorDwarf(){
        this.vida-=5;
    }
}
