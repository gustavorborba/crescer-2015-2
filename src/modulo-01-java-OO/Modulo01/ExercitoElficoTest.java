

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
        ArrayList<Elfo> esperado=new ArrayList<Elfo>();
        esperado.add(elf);
        esperado.add(elfoV);
        assertEquals(esperado,exer.buscar(Status.VIVO));
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
    @Test
    public void buscarPorStatus(){
        ExercitoElfico exer=new ExercitoElfico();
        ElfoNoturno elf=new ElfoNoturno("Malfurion");
        ElfoVerde elfoV=new ElfoVerde("Tempesfuria");
        exer.alistarElfo(elf);
        exer.alistarElfo(elfoV);
        exer.agruparPorStatus();
        ArrayList<Elfo> elfos=new ArrayList<Elfo>();
        elfos.add(elf);
        elfos.add(elfoV);
        assertEquals(elfos,exer.buscar(Status.VIVO));
    }
    @Test
    public void agrupadosVivoEMorto(){
        ExercitoElfico exer=new ExercitoElfico();
        ElfoNoturno elfo=new ElfoNoturno("Greengolas");
        ElfoVerde elfo1=new ElfoVerde("Bluegolas");
        ElfoVerde elfo2=new ElfoVerde("Daregolas");
        ElfoVerde elfo3=new ElfoVerde("Pinlegolas");
        ElfoVerde elfo4=new ElfoVerde("yelleolas");
        
        Uruk_Hai uruk=new Uruk_Hai();
        for(int i=0;i<11;i++){
            uruk.orcAtacar(elfo);
            uruk.orcAtacar(elfo1);
            uruk.orcAtacar(elfo2);
        }
        
        ArrayList<Elfo> mortos=new ArrayList<Elfo>();
        mortos.add(elfo2);
        mortos.add(elfo1);
        mortos.add(elfo);
        
        ArrayList<Elfo> vivos=new ArrayList<Elfo>();
        vivos.add(elfo4);
        vivos.add(elfo3);
        
        exer.alistarElfo(elfo);
        exer.alistarElfo(elfo1);
        exer.alistarElfo(elfo2);
        exer.alistarElfo(elfo3);
        exer.alistarElfo(elfo4);
        exer.agruparPorStatus();
        
        ArrayList<Elfo> corretos=new ArrayList<Elfo>();
        corretos=exer.getAgrupado().get(Status.VIVO);
        assertEquals(vivos,corretos);
        assertEquals(mortos,exer.buscar(Status.MORTO));
        assertEquals(vivos,exer.buscar(Status.VIVO));
    }
   @Test
   public void exercitoNaoTemElfoComum(){
       Elfo intrometido=new Elfo("Intrometus");
       ExercitoElfico exer=new ExercitoElfico();
       exer.alistarElfo(intrometido);
       assertEquals(null,exer.getElfoPorNome(intrometido.getNome()));
    }
}
