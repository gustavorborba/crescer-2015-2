

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste ElfoTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class ElfoTest
{
   @Test
    public void elfoTem42Flechas(){
		Elfo elrond=new Elfo("Elrond");
		assertEquals(42,elrond.getFlecha());
	}
	@Test
	public void elfoAtiraFlechaGanhaExperie(){
		Elfo elrond=new Elfo("Elrond");
		elrond.atirarFlecha();
		assertEquals(1,elrond.getExp());
	}
	@Test
	public void elfoPerdeFlechaAoAtirar(){
		Elfo elrond=new Elfo("Elrond");
		elrond.atirarFlecha();
		assertEquals(41,elrond.getFlecha());
	}
	@Test
	public void elfoIniciaComFlecha(){
	    Elfo elrond=new Elfo("Elrond",84);
	    assertEquals(84,elrond.getFlecha());
	}
	@Test 
	public void elfoNotDefault(){
	   Elfo elrond=new Elfo("Elrond");
	   assertNotSame(50,elrond.getFlecha());
	}
	@Test
	public void elfoNomeValidoAposCriacao(){
	    Elfo elrond=new Elfo("Elrond");
	    assertEquals("Elrond",elrond.getNome());
	    assertNotSame("Planeta",elrond.getNome());
	}
	@Test
	public void ElfoTemToStringCorreto(){
	    Elfo galadriel=new Elfo("Galadriel");
	    String fraseTeste;
	    fraseTeste = galadriel.getNome();
        fraseTeste += " possui ";
        fraseTeste += galadriel.getFlecha();
        fraseTeste += " flechas e ";
        fraseTeste += galadriel.getExp();
        fraseTeste += " niveis de experiencia";
        assertEquals(fraseTeste,galadriel.toString());
	}
	@Test
	public void ElfoTemToStringExtenso(){
	   Elfo galadriel=new Elfo("Galadriel");
	   assertEquals("Galadriel possui 42 flechas e 0 niveis de experiencia",galadriel.toString());
	   galadriel.atirarFlecha();
	   assertEquals("Galadriel possui 41 flechas e 1 niveis de experiencia",galadriel.toString());
	   assertNotSame("Galadriel possui 40 flechas e 1 niveis de experiencia",galadriel.toString());
	}
}
