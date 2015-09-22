

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
    public void elfoTem42FlechasPorDefault(){
        Elfo elrond=new Elfo("Elrond");
        assertEquals(42,elrond.getFlecha());
    }
    
    @Test
    public void elfoAtiraFlechaGanhaExperie(){
        Elfo elrond=new Elfo("Elrond");
        elrond.atirarFlecha(new Dwarf(""));
        assertEquals(1,elrond.getExperiencia());
    }
    
    @Test
    public void elfoPerdeFlechaAoAtirar(){
        Elfo elrond=new Elfo("Elrond");
        elrond.atirarFlecha(new Dwarf(""));
        assertEquals(41,elrond.getFlecha());
        //perde apenas 1
        assertNotSame(40,elrond.getFlecha());
    }
    
    @Test
    public void elfoIniciaComFlecha(){
        Elfo elrond=new Elfo("Elrond",84);
        assertEquals(84,elrond.getFlecha());
    }
    
    @Test 
    public void elfoDefaulte42(){
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
    public void ElfoAtacaVariosDwarf(){
        Elfo malfurion=new Elfo("Malfurion");
        Dwarf grande=new Dwarf("Grande");
        Dwarf machado=new Dwarf("Machado");
        Dwarf assis=new Dwarf("Assis");
        malfurion.atirarFlecha(grande);
        malfurion.atirarFlecha(machado);
        malfurion.atirarFlecha(assis);
        assertEquals(100,grande.getVida());
        assertEquals(100,machado.getVida());
        assertEquals(100,assis.getVida());
        assertEquals(39,malfurion.getFlecha());
        
    }
    
    @Test
    public void ElfoTemToStringCorreto(){
        Elfo galadriel=new Elfo("Galadriel");
        String fraseTeste;
        fraseTeste = galadriel.getNome();
        fraseTeste += " possui ";
        fraseTeste += galadriel.getFlecha();
        fraseTeste += " flechas e ";
        fraseTeste += galadriel.getExperiencia();
        fraseTeste += " niveis de experiencia";
        assertEquals(fraseTeste,galadriel.toString());
    }
    
    @Test
    public void ElfoTemToStringExtenso(){
       Elfo galadriel=new Elfo("Galadriel");
       assertEquals("Galadriel possui 42 flechas e 0 niveis de experiencia",galadriel.toString());
       galadriel.atirarFlecha(new Dwarf(""));
       assertEquals("Galadriel possui 41 flechas e 1 nivel de experiencia",galadriel.toString());
       assertNotSame("Galadriel possui 40 flechas e 1 nivel de experiencia",galadriel.toString());
    }
    @Test
    public void elfoNasceVivo(){
        Elfo legolas=new Elfo("Legolas");
        assertEquals(Status.VIVO,legolas.getStatus());
    }
}
