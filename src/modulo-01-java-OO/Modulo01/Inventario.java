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
        inventario.add(itemAdicionado);
    }
    public void perderItem(Item itemPerdido){
        inventario.remove(itemPerdido);
    }
    public Item getItemEspecifico(int i){
        return inventario.get(i);
    }
    public int getTamanhoArray(){
        return inventario.size();
    }
    public String getDescricoesItens(){
        String descricoes="";
        for(int i=0;i<inventario.size();i++){
            descricoes+=inventario.get(i).getDescricao();
            if(i+1 != inventario.size()){
                descricoes+=",";
            }
        }
        return descricoes;
    }
    public Item getItemComMaiorQuantidade(){
    Item maior=inventario.get(0);
        for(int i=0;i<inventario.size();i++){
            if(inventario.get(i).getQuantidade()>maior.getQuantidade()){
                maior=inventario.get(i);
            }
        }
        return maior;
    }
}
