
/**
 * Write a description of class Personagem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Personagem
{
   protected String nome;
   protected int vida,experiencia;
   protected Inventario inventario=new Inventario();
   protected Status status;
   public Inventario getInventario(){
       return this.inventario;
    }
    public void adicionarItem(Item item){
        this.inventario.adicionarItem(item);
    }
    public void perderItem(Item item){
        this.inventario.perderItem(item);
    }
   public String getNome(){
       return this.nome;
    }
    public int getVida(){
        return this.vida;
    }
    public int getExperiencia(){
        return this.experiencia;
    }
    public Status getStatus(){
        return status;
    }
    public void atacadoPorOrc(int n){
        if(this.vida !=0){
            this.vida-=n;
        }
        if(this.vida==0 && this.status==Status.VIVO){
            this.status=Status.MORTO;
        }
    }
}
