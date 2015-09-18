
/**
 * Datas
 */
public class DataTerceiraEra
{
   private int dia=1,mes=1,ano=1;
    public int getDia(){
       return dia;
    }
    public int getMes(){
       return mes;
    }
    public int getAno(){
       return ano;
    }
    
    public boolean ehBissexto(){
        if(ano % 4 == 0 && (ano % 100 != 0) || (ano % 400 == 0)){
            return true;
        }else{
            return false;
        }
    }
    //set para testar ehBissexto
    public void setAno(int bi){
        ano=bi;
    }
}
