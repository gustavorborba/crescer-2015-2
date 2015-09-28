

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
public class EstretegiaFrimenteCalculadoTest
{
   @Test
   public void noturnoAtacaAte70deVida(){
       ExercitoElfico exer=new ExercitoElfico();
       Elfo elf1=new ElfoNoturno("N1");
       Elfo elf2=new ElfoNoturno("N2");
       Elfo elf3=new ElfoNoturno("N3");
       exer.alistarElfo(elf1);
       exer.alistarElfo(elf2);
       exer.alistarElfo(elf3);
       
       ArrayList<Dwarf> anao=new ArrayList<>();
       
       for(int i=0;i<100;i++){
           anao.add(new Dwarf("A"+i));
        }
       
       ArrayList<Elfo> esperado=new ArrayList<>();
       esperado.add(elf1);
       esperado.add(elf2);
       esperado.add(elf3);
        
       exer.atacarFriamente(anao);
       
       assertEquals(69,(int)elf1.getVida());
       assertEquals(esperado,exer.getUltimoAtaque());
       assertEquals(80,anao.get(0).getVida(),0.00001);
    }
   @Test
   public void noturnosParamDeAtacarAoPerder30PorcentoDeVida(){
       ExercitoElfico exer=new ExercitoElfico();
       Elfo elf1=new ElfoNoturno("N1");
       Elfo elf2=new ElfoNoturno("N2");
       Elfo elf3=new ElfoNoturno("N3");
       exer.alistarElfo(elf1);
       exer.alistarElfo(elf2);
       exer.alistarElfo(elf3);
       
       ArrayList<Dwarf> anao=new ArrayList<>();
       
       for(int i=0;i<100;i++){
           anao.add(new Dwarf("A"+i));
        }
       
       ArrayList<Elfo> esperado=new ArrayList<>();
       esperado.add(elf1);
       esperado.add(elf2);
       esperado.add(elf3);
        
       exer.atacarFriamente(anao);
       
       assertEquals(110,(int)anao.get(99).getVida());
    }
}
