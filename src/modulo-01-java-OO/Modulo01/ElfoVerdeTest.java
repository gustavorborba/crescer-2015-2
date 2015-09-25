

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoVerdeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoVerdeTest
{
  @Test
  public void ElfoVerdePodeApenas2Item(){
      ElfoVerde elfo=new ElfoVerde("Odin");
      Item item1=new Item("Espada de aço valiriano",1);
      Item item2=new Item("Escudo",1);
      Item item3=new Item("Espada orc",1);
      Item item4=new Item("Arco e Flecha de Vidro",1);
      
      Inventario esperado=new Inventario();
      
      esperado.adicionarItem(item1);
      esperado.adicionarItem(item4);
      
      elfo.adicionarItem(item1);
      elfo.adicionarItem(item2);
      elfo.adicionarItem(item3);
      elfo.adicionarItem(item4);
      
      assertEquals(true,elfo.getInventario().equals(esperado));
    }
}
