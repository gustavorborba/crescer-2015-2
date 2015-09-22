

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class Uruk_HaiTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Uruk_HaiTest
{
   @Test
   public void nasceComEscudoEEspada(){
       Uruk_Hai ur=new Uruk_Hai("");
       assertEquals("Escudo Uruk-Hai",ur.getInventario().getItemEspecifico(0).getDescricao());
       assertEquals("Espada",ur.getInventario().getItemEspecifico(1).getDescricao());
    }
    @Test
    public void urukAtacaGeral(){
        Uruk_Hai ur=new Uruk_Hai("");
        Elfo elf=new Elfo("EE");
        ur.atacarElfo(elf);
        assertEquals(68,elf.getVida());
        Dwarf anao=new Dwarf("A");
        ur.atacarDwarf(anao);
        assertEquals(98,anao.getVida());
    }

}
