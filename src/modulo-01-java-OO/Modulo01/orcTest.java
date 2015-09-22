

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class orcTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class orcTest
{
   @Test
   public void orcTemEscudoOuArco(){
       Orc orc=new Orc("");
       if(orc.getVida()<=100){
           assertEquals(true,orc.getInventario().getItemEspecifico(0).equals(new Item("Escudo Uruk Hai",1)));
        }else{
            assertEquals(true,orc.getInventario().getItemEspecifico(0).equals(new Item("Arco",1)));
        }
    }
   @Test
   public void atacadoPorDwarfPerde10Ou5(){
       Orc orc=new Orc("");
       int esperado=orc.getVida();
       if(orc.getVida()<=100){
           orc.atacadoPorDwarf();
           assertEquals(esperado-5,orc.getVida());
        }else{
            orc.atacadoPorDwarf();
            assertEquals(esperado-10,orc.getVida());
        }
    }
   @Test
   public void orcAtacaAnaoEPerdeFlexa(){
       Orc orc=new Orc("");
       Dwarf anao=new Dwarf("Soneca");
       if(orc.getVida()>=100){
           orc.atacarDwarf(anao);
           assertEquals(102,anao.getVida());
           assertEquals(9,orc.getInventario().getItemEspecifico(1).getQuantidade());
        }
    }
}
