

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * A classe de teste DwarfTest.
 *
 * @author  (seu nome)
 * @version (um número de versão ou data)
 */
public class DwarfTest
{
   @Test
   public void DwarfNasceCom110DeVida(){
       Dwarf gimli=new Dwarf("O");
       assertEquals(110,gimli.getVida());
    }
   @Test
    public void dwarfPerdeVidaSerFlechado(){
        Elfo elrond=new Elfo("Elrond");
        Dwarf gloin=new Dwarf("Gloin");
        elrond.atacDwarf(gloin);
        assertEquals(100,gloin.getVida());
    }
    @Test
    public void dwarfNaoPerdeVidaSerFlechado(){
        Elfo elrond=new Elfo("Elrond");
        Dwarf gloin=new Dwarf("Gloin");
        elrond.atacDwarf(gloin);
        assertNotSame(110,gloin.getVida());
    }
    @Test
    public void DwarfNasceComNome(){
        Dwarf bifur=new Dwarf("Bifur");
        assertEquals("Bifur",bifur.getNome());
    }
}
