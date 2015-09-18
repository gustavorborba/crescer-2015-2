

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DataTerceiraEraTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DataTerceiraEraTest
{
 
   @Test
   public void AnoEhBissexto(){
       DataTerceiraEra bi=new DataTerceiraEra(1,1,2016);
       assertEquals(true,bi.ehBissexto());
    }
   @Test
   public void AnoNaoEhBissexto(){
       DataTerceiraEra bi=new DataTerceiraEra(1,1,2015);
       assertEquals(false,bi.ehBissexto());
    }
   @Test
   public void Ano1804EhBissexto(){
       DataTerceiraEra bi=new DataTerceiraEra(1,1,1804);
       assertEquals(true,bi.ehBissexto());
    }
}
