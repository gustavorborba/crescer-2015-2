import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
/**
 * Escreva a descrição da classe orc aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */
public class Orc extends Personagem
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    public Orc()
    {
        status=Status.VIVO;
    }
    public void perderVida(){
        if(this.vida>0 && this.getItem("Escudo Uruk-Hai")==null){
            this.vida-=10;
        } 
        if(this.vida>0 && this.getItem("Escudo Uruk-Hai") !=null ){
            this.vida-=6;
        }
        if(this.vida==0 && this.status==Status.VIVO){
        this.status=Status.MORTO;
    }   
    }
    public void orcAtacar(Personagem person){
        Item esp=new Item("Espada",1);
        Item arc=new Item("Arco",1);
        Item flec=new Item("Flecha",1);
        if(getItem("Espada")!=null){
            person.atacadoPorOrc(12);
        }
        else if(getItem("Arco")!= null){
            if(getItem("Flecha").getQuantidade()>0){
                person.atacadoPorOrc(8);
                this.debitarFlecha();
            }
        }else{
            status=Status.FUGINDO;
        }
    }
    public Item getItem(String descricao){
        return this.inventario.getItemPorDescricao(descricao);
    }
    public void debitarFlecha(){
        Item item=getItem("Flecha");
        if(item.getQuantidade()>0){
            item.perdeUmItem();
        }
    }
}