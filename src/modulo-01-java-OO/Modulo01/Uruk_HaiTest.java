

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
       Uruk_Hai ur=new Uruk_Hai();
       assertEquals("Escudo Uruk-Hai",ur.getInventario().getItemEspecifico(0).getDescricao());
       assertEquals("Espada",ur.getInventario().getItemEspecifico(1).getDescricao());
    }
   @Test
   public void urukAtacaGeral(){
        Uruk_Hai uruk=new Uruk_Hai();
        Dwarf anao=new Dwarf("Gloin");
        assertEquals(110,anao.getVida());
        uruk.orcAtacar(anao);
        assertEquals(98,anao.getVida());
    }
   @Test 
   public void urukaAtacaElfoVerde(){
        Uruk_Hai uruk=new Uruk_Hai();
        ElfoVerde elfo=new ElfoVerde("Greengolas");
        uruk.orcAtacar(elfo);
        assertEquals(68,elfo.getVida());
    }
}
