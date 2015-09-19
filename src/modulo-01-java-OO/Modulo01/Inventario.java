import java.util.ArrayList;
import java.util.Arrays;
/**
 * Write a description of class Inventario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventario
{
    private ArrayList<Item> inventario=new ArrayList<Item>();
    
    public void adicionarItem(Item itemAdicionado){
        inventario.add(itemAdicionado);
    }
    public void perderItem(Item itemPerdido){
        inventario.remove(itemPerdido);
    }
    public Item getItemEspecifico(int i){
        return inventario.get(i);
    }
    public int getTamanhoArray(){
        return inventario.size();
    }
}
