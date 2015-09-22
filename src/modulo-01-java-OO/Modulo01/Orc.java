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
    protected Status status;
    protected Inventario inventario=new Inventario();
    public Orc()
    {
        status=Status.VIVO;
    }
    public Orc(String n){
    }
    public int getVida(){
        return vida;
    }
    public Inventario getInventario(){
        return inventario;
    }
    public void atacadoPorDwarf(){
            if(this.vida>0){
            vida-=10;
        }
         if(this.vida==0 && this.status==Status.VIVO){
             this.status=Status.MORTO;
    }
    }
    public Status getStatus(){
        return status;
    }
    public void perderVida(int quantida){
        if(this.vida>0){
            this.vida-=quantida;
        } if(this.vida==0 && this.status==Status.VIVO){
        this.status=Status.MORTO;
    }
        
    }
    public void atacadoPorElfo(){
        this.perderVida(8);
    }
    public void atacarDwarf(Dwarf anao) {
       if(getItem("Arco")!=null){
           if(getItem("Flexa")==null && getItem("Flexa").getQuantidade()>0){
               anao.atacadoPorOrc(8);
               this.debitarFlexa();
            }
        }
    }  
    
    public void atacarElfo(Elfo elf) {
       if(getItem("Arco")!=null){
           if(getItem("Flexa")!=null && getItem("Flexa").getQuantidade()>0){
               elf.atacadoPorOrc(8);
            }
        }
    }  
    public Item getItem(String descricao){
        return this.inventario.getItemPorDescricao(descricao);
    }
    public void debitarFlexa(){
        Item item=getItem("Flecha");
        if(item.getQuantidade()>0){
            item.perdeUmItem();
        }
        if(item.getQuantidade()==0){
            status=Status.FUGINDO;
        }
    }
}