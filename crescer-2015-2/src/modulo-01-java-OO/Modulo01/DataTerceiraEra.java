
/**
 * Datas
 */
public class DataTerceiraEra
{
   private int dia,mes,ano;
   public DataTerceiraEra(int d, int m,int a){
       dia=d;
       mes=m;
       ano=a;
    }
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
        //return this.ano %400 == 0 || (this.ano %4==0 && this.ano % 100 !=0);
        if(ano % 4 == 0 && (ano % 100 != 0) || (ano % 400 == 0)){
            return true;
        }else{
            return false;
        }
    }
   
}
