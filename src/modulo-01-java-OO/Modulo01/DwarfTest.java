

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
    public void dwarfPerdeVidasSempreQueAtacado(){
        Elfo elrond=new Elfo("Elrond");
        Dwarf gloin=new Dwarf("Gloin");
        elrond.atacDwarf(gloin);
        assertEquals(100,gloin.getVida());
        assertNotSame(95,gloin.getVida());
        elrond.atacDwarf(gloin);
        elrond.atacDwarf(gloin);
        assertEquals(80,gloin.getVida());
        
    }
    @Test
    public void dwarfMorreEm0DeVidaENaoTemVidaNegativa(){
        Elfo elf=new Elfo("Odin");
        Dwarf anao=new Dwarf("Gloin");
        for(int i=0;i<11;i++){
            elf.atacDwarf(anao);
        }
        assertEquals(Status.MORTO,anao.getStatus());
        elf.atacDwarf(anao);
        elf.atacDwarf(anao);
        assertEquals(0,anao.getVida());
    }
    @Test
    public void DwarfNasceComNome(){
        Dwarf bifur=new Dwarf("Bifur");
        assertEquals("Bifur",bifur.getNome());
        assertNotSame("Odin",bifur.getNome());
        assertEquals(1,bifur.dataNascimento.getAno());
    }
    
}
