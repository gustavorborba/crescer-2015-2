

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Elfo_VerdeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Elfo_VerdeTest
{
    @Test
    public void ganha2Experiencia(){
        ElfoVerde elfo=new ElfoVerde("Legu");
        elfo.atirarFlexa();
        assertEquals(2,elfo.getExperiencia());
    }
}
