import java.util.ArrayList;
import java.util.Arrays;
/**
 * Write a description of class Inventario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Inventario
{
    private ArrayList<Item> inventario=new ArrayList<Item>();
    
    public void adicionarItem(Item itemAdicionado){
        this.inventario.add(itemAdicionado);
    }
    public void perderItem(Item itemPerdido){
        this.inventario.remove(itemPerdido);
    }
    public Item getItemEspecifico(int i){
        return this.inventario.get(i);
    }
    public int getTamanhoArray(){
        return this.inventario.size();
    }
    public ArrayList<Item> getItens() {
        return this.inventario;
    }
    public String getDescricoesItens(){
        String descricoes="";
        //for iteretor java for(Item item : this.inventarios){descricoes+=item.getDescricao()+","}
        for(int i=0;i<inventario.size();i++){
            descricoes+=this.inventario.get(i).getDescricao();
            if(i+1 != inventario.size()){
                descricoes+=",";
            }
        }
        //return descricoes.substring(0,descricoes.lenght()-1);
        return descricoes;
    }
    public Item getItemComMaiorQuantidade(){
    Item maior=inventario.get(0);
        for(int i=0;i<inventario.size();i++){
            if(this.inventario.get(i).getQuantidade()>maior.getQuantidade()){
                maior=this.inventario.get(i);
            }
        }
        return maior;
    }
    public void ordenaItens(){
        int menor;
        Item swap;
        for(int i=0;i<this.inventario.size()-1;i++){
            menor=i;
            for(int j=i+1;j<inventario.size();j++){
                if(this.inventario.get(j).getQuantidade()<this.inventario.get(menor).getQuantidade()){
                    menor=j;
                }
            }
            swap=this.inventario.get(i);
            this.inventario.set(i,inventario.get(menor));
            this.inventario.set(menor,swap);
        }
    }
    public boolean encontraEspecifico(Item item){
        for(Item it : inventario){
            if(it.equals(item)){
                return true;
            }
        }
        return false;
    }
   
}
