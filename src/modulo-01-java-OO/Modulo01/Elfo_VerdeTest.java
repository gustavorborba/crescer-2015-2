

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
        elfo.atirarFlecha(new Dwarf(""));
        assertEquals(2,elfo.getExperiencia());
    }
    @Test
    public void GanhaApenasDoisItens(){
        ElfoVerde sortudo = new ElfoVerde("Sortudo");
        sortudo.adicionarItem(new Item("Espada de aço valiriano",1));
        Inventario esperado = new Inventario();
        esperado.adicionarItem(new Item("Espada de aço valiriano",1));
        assertEquals(esperado, sortudo.getInventario());
    }
}
