import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
/**
 * Escreva a descrição da classe orc aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Orc
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    protected int vida;
    protected Inventario inventario=new Inventario();
    /**
     * COnstrutor para objetos da classe orc
     */
    public Orc()
    {
        randomVidaEEscudo();
    }
    public void randomVidaEEscudo(){
      
        int i=randInt();
        this.vida=i;
        if(i<=100){
            this.inventario.adicionarItem(new Item("Escudo Uruk Hai",1));
        }else{
            this.inventario.adicionarItem(new Item("Arco",1));
            this.inventario.adicionarItem(new Item("Flecha",10));
        }
    }
    public int getVida(){
        return vida;
    }
    public Inventario getInventario(){
        return inventario;
    }
    public void atacadoPorDwarf(){
        if(inventario.encontraEspecifico(new Item("Escudo Uruk Hai",1))){
            vida-=5;
        }else{
            vida-=10;
        }
    }
    public void atacadoPorElfo(){
        this.vida-=10;
    }
    public void atacarAnao(Dwarf anao) {
       if(inventario.encontraEspecifico(new Item("Arco",1))){
           if(this.orcTemflexa()){
               anao.atacado();
            }
        }
    }  
    public static int randInt() {

    // Usually this can be a field rather than a method variable
    Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((200 - 1) + 1) + 1;

    return randomNum;
}
    public boolean orcTemflexa(){
        for(Item it : inventario.getItens()){
            if(it.equals2(new Item("Flecha",0))){
                if(it.getQuantidade()>=1){
                    it.perdeUmItem();
                    return true;
                }
            }
        }
        return false;
    }
}