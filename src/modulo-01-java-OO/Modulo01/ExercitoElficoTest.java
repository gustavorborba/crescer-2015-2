

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
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
    @Test
    public void agrupado(){
        ExercitoElfico exer=new ExercitoElfico();
        ElfoNoturno elf=new ElfoNoturno("Malfurion");
        ElfoVerde elfoV=new ElfoVerde("Tempesfuria");
        exer.alistarElfo(elf);
        exer.alistarElfo(elfoV);
        exer.agruparPorStatus();
        ExercitoElfico esperado=new ExercitoElfico();
        esperado.alistarElfo(elf);
        esperado.alistarElfo(elfoV);
        esperado.agruparPorStatus();
        assertEquals(true,exer.equals(esperado));
    }
    @Test
    public void agrupadoTemElfoCorreto(){
        ExercitoElfico exer=new ExercitoElfico();
        ElfoNoturno elf=new ElfoNoturno("Malfurion");
        ElfoVerde elfoV=new ElfoVerde("Tempesfuria");
        exer.alistarElfo(elf);
        exer.alistarElfo(elfoV);
        exer.agruparPorStatus();
        ArrayList<Elfo> elfos=new ArrayList<Elfo>();
        elfos=exer.getAgrupado().get(Status.VIVO);
        assertEquals(elf,elfos.get(0));
    }
}
