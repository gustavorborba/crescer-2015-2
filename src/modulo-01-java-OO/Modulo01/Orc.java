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
    protected Status status;
    /**
     * COnstrutor para objetos da classe orc
     */
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
    public void atacadoPorElfo(){
    if(this.vida>0){
        this.vida-=8;
    }
    if(this.vida==0 && this.status==Status.VIVO){
        this.status=Status.MORTO;
    }
    }
    public void atacarDwarf(Dwarf anao) {
       if(inventario.encontraEspecifico(new Item("Arco",1))){
           if(this.orcTemflexa()){
               anao.atacadoPorOrc(8);
            }else{
                status=Status.FUGINDO;
            }
        }
    }  
    public void atacarElfo(Elfo elf) {
       if(inventario.encontraEspecifico(new Item("Arco",1))){
           if(this.orcTemflexa()){
               elf.atacadoPorOrc(8);
            }else{
                status=Status.FUGINDO;
            }
        }
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