

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
/**
 * The test class EstrategiaNormalTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EstrategiaNormalTest
{
  @Test
  public void exercitoAtacaHordaEDwarvesPerdemVida(){
        ExercitoElfico exer=new ExercitoElfico();
        exer.alistarElfo(new ElfoNoturno("A1"));
        exer.alistarElfo(new ElfoNoturno("A2"));
        exer.alistarElfo(new ElfoNoturno("A3"));
        exer.alistarElfo(new ElfoVerde("A4"));
        ArrayList<Dwarf> anao=new ArrayList<>();
        anao.add(new Dwarf("O"));
        anao.add(new Dwarf("a"));
        exer.atacarAnoes(anao);
        assertEquals(80,anao.get(0).getVida(),0.00001);
    }
    @Test
    public void apenas30PorcentodeElfosNoturnosAtacam(){
        ExercitoElfico exer=new ExercitoElfico();
        exer.alistarElfo(new ElfoNoturno("A1"));
        exer.alistarElfo(new ElfoNoturno("A2"));
        exer.alistarElfo(new ElfoVerde("A6"));
        ArrayList<Dwarf> anao=new ArrayList<>();
        anao.add(new Dwarf("O"));
        anao.add(new Dwarf("a"));
        exer.atacarAnoes(anao);
        assertEquals(90,anao.get(0).getVida(),0.00001);
    }
   

}
