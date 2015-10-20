

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SnagaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SnagaTest
{
   @Test
   public void nasceComArcoEFlexa(){
       Snaga ur=new Snaga();
       assertEquals("Arco",ur.getInventario().getItemEspecifico(0).getDescricao());
       assertEquals("Flecha",ur.getInventario().getItemEspecifico(1).getDescricao());
    }
    @Test
    public void snagaAtacaGeralEPerdeFlecha(){
        Snaga snag=new Snaga();
        Dwarf anao=new Dwarf("Gloin");
        assertEquals(110,anao.getVida(),0.00001);
        snag.orcAtacar(anao);
        assertEquals(102,anao.getVida(),0.00001);
        assertEquals(4,snag.getItem("Flecha").getQuantidade());
    }
   @Test 
   public void snagaAtacaIrishDwarf(){
        Snaga snag=new Snaga();
        IrishDwarf anao=new IrishDwarf("Gloin");
        snag.orcAtacar(anao);
        assertEquals(102,anao.getVida(),0.00001);
    }
   @Test
   public void sanagaAtacadoPorElfo(){
       Snaga snag=new Snaga();
       Elfo elfo=new Elfo("Elf");
       elfo.atacarOrc(snag);
       assertEquals(60,snag.getVida(),0.00001);
    }
}
