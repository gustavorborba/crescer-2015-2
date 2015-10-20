

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class IrishDwarfTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class IrishDwarfTest
{
    @Test
    public void irishDwarfTemMuitaSorte(){
        IrishDwarf sortao=new IrishDwarf("Pesleves",new DataTerceiraEra(1,1,2016));
        sortao.atacado();
        sortao.atacado();
        sortao.atacado();
        sortao.adicionarItem(new Item("Machado",3));
        sortao.tentarSorte();
        assertEquals(6003,sortao.getQuantidadeEspecifica(0));
    }
    @Test
    public void irishDwarfTemMuitaSorte2(){
        IrishDwarf sortao=new IrishDwarf("Pesleves",new DataTerceiraEra(1,1,2016));
        sortao.atacado();
        sortao.atacado();
        sortao.atacado();
        sortao.adicionarItem(new Item("Machado",1));
        sortao.adicionarItem(new Item("Martelo",2));
        sortao.tentarSorte();
        assertEquals(1001,sortao.getQuantidadeEspecifica(0));
        assertEquals(3002,sortao.getQuantidadeEspecifica(1));
    }
}
