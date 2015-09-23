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
        super();
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
        if(getItem("Espada")!=null){
            person.atacadoPorOrc(this);
        }
        else if(getItem("Arco")!= null){
            if(getItem("Flecha").getQuantidade()>0){
                person.atacadoPorOrc(this);
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
    public void atacadoPorOrc(Orc orc){
       orc.perderVida();
    }
        private boolean podeAtacarComEspada() {
        return getItem("Espada") != null;
    }
    
    private boolean podeAtacarComArco(){
        boolean temArco = getItem("Arco") != null;
        Item flecha = getItem("Flecha");
        boolean temFlechaProArco = flecha != null && flecha.getQuantidade() > 0;
        
        return temArco && temFlechaProArco;
    }
        public int getDanoDeAtaque(){
        if(podeAtacarComEspada()){
            return 12;
        }
        
        if(podeAtacarComArco()){
            return 8;
        }
        
        return 0;
    }
}