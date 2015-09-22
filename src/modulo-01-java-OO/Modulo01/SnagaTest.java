

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
   
}
