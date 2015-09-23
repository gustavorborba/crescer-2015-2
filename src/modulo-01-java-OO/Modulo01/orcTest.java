

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
    public void orcSemItemFoge(){
        Orc orc=new Orc();
        Dwarf anao=new Dwarf("Dunga");
        orc.orcAtacar(anao);
        assertEquals(110,anao.getVida(),0.00001);
        assertEquals(Status.FUGINDO,orc.getStatus());
    }
}

