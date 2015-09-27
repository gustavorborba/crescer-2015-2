

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
public class NoturnoEmUltimoTest
{
    @Test
    public void elfoNoturnoPorUltimo(){
        ExercitoElfico exer=new ExercitoElfico();
        ElfoVerde elfoV1=new ElfoVerde("V1");
        ElfoVerde elfoV2=new ElfoVerde("V2");
        ElfoNoturno elfoN1=new ElfoNoturno("N1");
        
        exer.alistarElfo(elfoN1);
        exer.alistarElfo(elfoV1);
        exer.alistarElfo(elfoV2);
        
        ArrayList<Elfo> esperado=new ArrayList<>();
        
        esperado.add(elfoV1);
        esperado.add(elfoV2);
        esperado.add(elfoN1);
        
        ArrayList<Dwarf> anoes=new ArrayList<>();
        anoes.add(new Dwarf("AS"));
        anoes.add(new Dwarf("At"));
        anoes.add(new Dwarf("Ats"));
        
        exer.atacarNoturnoUltimo(anoes);
        
        assertEquals(esperado,exer.getUltimoAtaque());
        assertEquals(80,anoes.get(0).getVida(),0.00001);
        
    }
    @Test
    public void elfoNoturnoPorUltimoHardcore(){
        ExercitoElfico exer=new ExercitoElfico();
        ElfoVerde elfoV1=new ElfoVerde("V1");
        ElfoVerde elfoV2=new ElfoVerde("V2");
        ElfoVerde elfoV3=new ElfoVerde("V3");
        ElfoVerde elfoV4=new ElfoVerde("V4");
        ElfoVerde elfoV5=new ElfoVerde("V5");
        
        ElfoNoturno elfoN1=new ElfoNoturno("N1");
        ElfoNoturno elfoN2=new ElfoNoturno("N2");
        ElfoNoturno elfoN3=new ElfoNoturno("N3");
        
        exer.alistarElfo(elfoN1);
        exer.alistarElfo(elfoV1);
        exer.alistarElfo(elfoV2);
        exer.alistarElfo(elfoN2);
        exer.alistarElfo(elfoV3);
        exer.alistarElfo(elfoN3);
        exer.alistarElfo(elfoV4);
        exer.alistarElfo(elfoV5);
        
        ArrayList<Elfo> esperado=new ArrayList<>();
        esperado.add(elfoV1);
        esperado.add(elfoV2);
        esperado.add(elfoV3);
        esperado.add(elfoV4);
        esperado.add(elfoV5);
        esperado.add(elfoN1);
        esperado.add(elfoN2);
        esperado.add(elfoN3);
        
        ArrayList<Dwarf> anoes=new ArrayList<>();
        anoes.add(new Dwarf("AS"));
        anoes.add(new Dwarf("At"));
        anoes.add(new Dwarf("Ats"));
        
        exer.atacarNoturnoUltimo(anoes);
        assertEquals(esperado,exer.getUltimoAtaque());
        
    }
    
}
