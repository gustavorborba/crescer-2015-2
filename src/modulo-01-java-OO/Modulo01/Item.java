
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
   public String getDescricao(){
       return this.descricao;
    }
   public int getQuantidade(){
       return this.quantidade;
    }
   public boolean equals(Object obj){
       Item item=(Item)obj;
       return this.descricao == item.getDescricao() && this.quantidade==item.getQuantidade();
    }
}
