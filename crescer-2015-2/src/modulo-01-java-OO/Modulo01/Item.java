
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
    @Override
    public boolean equals(Object obj) {
        Item outro = (Item)obj;
        return this.descricao.equals(outro.getDescricao());
    }
    public void sortudo(){
        this.quantidade+=1000;
    }
    public void lepreSortudo(){
        int sorte=0;
        sorte=(this.quantidade * (this.quantidade+1))/2;
        this.quantidade=(sorte*1000)+quantidade;
    }
    public void perdeUmItem(){
        this.quantidade=quantidade-1;
    }

}
