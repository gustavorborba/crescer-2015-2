
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
   private String descricao;
   private int quantidade;
   
   public Item(String novaDesc,int novaQuant){
       this.descricao=novaDesc;
       this.quantidade=novaQuant;
   }
   public String getDesc(){
       return descricao;
    }
   public int getQuant(){
       return quantidade;
    }
}
