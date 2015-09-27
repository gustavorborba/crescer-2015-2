

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
/**
 * The test class EstratMetadeDeCadaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class EstrategiaIntercaladaTest
{
    @Test
    public void elfoAtaqueIntercalado(){
        ExercitoElfico exer=new ExercitoElfico();
        ElfoVerde elfoV1=new ElfoVerde("V1");
        ElfoVerde elfoV2=new ElfoVerde("V2");
        ElfoVerde elfoV3=new ElfoVerde("V3");
        ElfoNoturno elfoN1=new ElfoNoturno("N1");
        ElfoNoturno elfoN2=new ElfoNoturno("N2");
        
        exer.alistarElfo(elfoN1);
        exer.alistarElfo(elfoV1);
        exer.alistarElfo(elfoV2);
        exer.alistarElfo(elfoN2);
        exer.alistarElfo(elfoV3);
        
        ArrayList<Elfo> esperado=new ArrayList<>();
        esperado.add(elfoV1);
        esperado.add(elfoN1);
        esperado.add(elfoV2);
        esperado.add(elfoN2);
        
        ArrayList<Dwarf> anoes=new ArrayList<>();
        anoes.add(new Dwarf("AS"));
        anoes.add(new Dwarf("At"));
        
        exer.atacarIntercalado(anoes);
        assertEquals(esperado,exer.getUltimoAtaque());
        assertEquals(70,anoes.get(0).getVida(),0.00001);
    }
    @Test
    public void elfoMuitoAtaqueIntercalado(){
    ExercitoElfico exer=new ExercitoElfico();
    int quantNoturno=115;
    int quantVerde=147;
    
    for(int i=0;i<quantNoturno;i++){
        exer.alistarElfo(new ElfoNoturno("N"+i));
    }
    for(int i=0;i<quantVerde;i++){
        exer.alistarElfo(new ElfoVerde("V"+i));
    }
    
    ArrayList<Dwarf> anoes=new ArrayList<>();
    anoes.add(new Dwarf("AS"));
    anoes.add(new Dwarf("At"));
    anoes.add(new Dwarf("AE"));
    
    exer.atacarIntercalado(anoes);
    
    int esperado=2*quantNoturno;
    assertEquals(esperado,exer.getUltimoAtaque().size());
    }
}
