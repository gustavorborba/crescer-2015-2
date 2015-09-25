

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
        exer.alistarElfo(new ElfoVerde("A1"));
        exer.alistarElfo(new ElfoVerde("A2"));
        exer.alistarElfo(new ElfoVerde("A3"));
        exer.alistarElfo(new ElfoNoturno("A4"));
        exer.alistarElfo(new ElfoNoturno("A5"));
        exer.alistarElfo(new ElfoNoturno("A6"));
        exer.alistarElfo(new ElfoNoturno("N1"));
        exer.alistarElfo(new ElfoNoturno("N2"));
        exer.alistarElfo(new ElfoNoturno("N3"));
        EstrategiaDeAtaque ataque=exer.iniciarAtaque();
        ArrayList<Dwarf> anao=new ArrayList<>();
        anao.add(new Dwarf("O"));
        anao.add(new Dwarf("a"));
        ataque.atacar(anao);
        assertEquals(20,anao.get(0).getVida(),0.00001);
    }
    @Test
    public void apenas30PorcentodeElfosNoturnosAtacam(){
        ExercitoElfico exer=new ExercitoElfico();
        exer.alistarElfo(new ElfoNoturno("A1"));
        exer.alistarElfo(new ElfoNoturno("A2"));
        exer.alistarElfo(new ElfoNoturno("A3"));
        exer.alistarElfo(new ElfoVerde("A6"));
        EstrategiaDeAtaque ataque=exer.iniciarAtaque();
        ArrayList<Dwarf> anao=new ArrayList<>();
        anao.add(new Dwarf("O"));
        ataque.atacar(anao);

    }
   

}
