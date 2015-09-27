

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
    }
}
