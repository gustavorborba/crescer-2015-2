

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class InventarioTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class InventarioTest
{
    @Test
    public void AdicionaItemArrayInventario(){
        Inventario inventario=new Inventario();
        inventario.adicionarItem(new Item("Machado",1));
        Item itemComparacao=new Item("Machado",1); //Achei melhor criar um novo para deixar explicito que é outro objeto
        assertEquals(true,inventario.getItemEspecifico(0).equals(itemComparacao));
        assertEquals(1,inventario.getTamanhoArray());
    }
    @Test
    public void AdicionaVariosItemInventario(){
        Inventario inventario=new Inventario();
        inventario.adicionarItem(new Item("Machado",1));
        inventario.adicionarItem(new Item("Magia",2));
        inventario.adicionarItem(new Item("Arco",5));
        inventario.adicionarItem(new Item("Flecha",4));
        inventario.adicionarItem(new Item("Espada",2));
        assertEquals(5,inventario.getTamanhoArray());
        assertEquals(true,inventario.getItemEspecifico(2).equals(new Item("Arco",5)));
    }
   @Test 
   public void RemoveItemArrayInventario(){
        Inventario inventario=new Inventario();
        inventario.adicionarItem(new Item("Machado",1));
        assertEquals(1,inventario.getTamanhoArray());
        inventario.perderItem(inventario.getItemEspecifico(0));
        assertEquals(0,inventario.getTamanhoArray());
    }
    @Test
     public void RemoveVariosItemArrayInventario(){
        Inventario inventario=new Inventario();
        inventario.adicionarItem(new Item("Machado",1));
        inventario.adicionarItem(new Item("Magia",2));
        inventario.adicionarItem(new Item("Arco",5));
        inventario.adicionarItem(new Item("Flecha",4));
        inventario.adicionarItem(new Item("Espada",2));
        assertEquals(5,inventario.getTamanhoArray());
        inventario.perderItem(inventario.getItemEspecifico(2));
        Item itemComparacao=new Item("Flecha",4);
        assertEquals(true,inventario.getItemEspecifico(2).equals(itemComparacao)); //o local dois deve ser o objeto 3 antes de realizar a perda;
        assertEquals(4,inventario.getTamanhoArray());
    }
   @Test
   public void RetornaDescricaoSeparadosVirgula(){
       String desc="";
       Item item1=new Item("Machado",1);
       Item item2=new Item("Magia",2);
       Item item3=new Item("Arco",5);
       desc+=item1.getDescricao();
       desc+=",";
       desc+=item2.getDescricao();
       desc+=",";
       desc+=item3.getDescricao();
       Inventario inventario=new Inventario();
       inventario.adicionarItem(new Item("Machado",1));
       inventario.adicionarItem(new Item("Magia",2));
       inventario.adicionarItem(new Item("Arco",5));
       assertEquals(true,inventario.getDescricoesItens().equals(desc));
    }
   @Test
    public void RetornaDescricaoSemVirgula(){
       String desc="";
       Item item1=new Item("Machado",1);
       desc+=item1.getDescricao();
       Inventario inventario=new Inventario();
       inventario.adicionarItem(new Item("Machado",1));
       assertEquals(true,inventario.getDescricoesItens().equals(desc));
    }
}
