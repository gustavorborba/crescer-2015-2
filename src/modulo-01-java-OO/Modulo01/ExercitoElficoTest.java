

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ExercitoElficoTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ExercitoElficoTest
{
    @Test
    public void elfoEAlistado(){
        ExercitoElfico exer=new ExercitoElfico();
        ElfoNoturno elf=new ElfoNoturno("Malfurion");
        ElfoVerde elfoV=new ElfoVerde("Tempesfuria");
        exer.alistarElfo(elf);
        exer.alistarElfo(elfoV);
        Elfo esperado1=exer.getElfoPorNome("Malfurion");
        Elfo esperado2=exer.getElfoPorNome("Tempesfuria");
        assertEquals(esperado1,elf);
        assertEquals(esperado2,elfoV);
    }
}
