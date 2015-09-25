

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ElfoNoturnoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfoNoturnoTest
{
    @Test
    public void elfoNoturnoPerde5DeVida(){
        ElfoNoturno elfo=new ElfoNoturno("Malfurion");
        Dwarf anao=new Dwarf("Gloin");
        elfo.atirarFlecha(anao);
        assertEquals(95,elfo.getVida(),0.00001);
        assertEquals(3,elfo.getExperiencia());
    }
    @Test
    public void elfoAtacaMuitoEMorre(){
        ElfoNoturno elfo=new ElfoNoturno("Malfurion");
        for(int i=0;i<90;i++){
            elfo.atirarFlecha(new Dwarf("ae"));
        }
        assertEquals(Status.MORTO,elfo.getStatus());
    }
}
