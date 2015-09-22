

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
       Snaga ur=new Snaga("");
       assertEquals("Arco",ur.getInventario().getItemEspecifico(0).getDescricao());
       assertEquals("Flecha",ur.getInventario().getItemEspecifico(1).getDescricao());
    }
   @Test
    public void snagakAtacaGeral(){
        Snaga ur=new Snaga("");
        Elfo elf=new Elfo("EE");
        ur.atacarElfo(elf);
        assertEquals(72,elf.getVida());
        Dwarf anao=new Dwarf("A");
        ur.atacarDwarf(anao);
        assertEquals(102,anao.getVida());
        ur.atacarDwarf(anao);
        ur.atacarDwarf(anao);
        ur.atacarDwarf(anao);
        assertEquals(0,ur.getInventario().getItemEspecifico(1).getQuantidade()); //acabou flexas
    }

}
