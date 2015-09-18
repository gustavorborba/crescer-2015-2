

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ItemTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ItemTest
{
    @Test
    public void construtorItem(){
        Item item=new Item("Machado",2);
        assertEquals("Machado",item.getDesc());
        assertEquals(2,item.getQuant());
    }
}
