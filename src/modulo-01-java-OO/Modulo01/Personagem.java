
/**
 * Write a description of class Personagem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Personagem
{
   protected String nome;
   protected int experiencia;
   protected double vida;
   protected Inventario inventario=new Inventario();
   protected Status status;
   public Personagem(){
       this.status=Status.VIVO;
    }
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
   public double getVida(){
       return this.vida;
    }
   public int getExperiencia(){
       return this.experiencia;
    }
   public Status getStatus(){
       return status;
    }
   public void atacadoPorOrc(Orc orc){
       int n=orc.getDanoDeAtaque();
       if(this.vida >1){
           this.vida-=n;
        }
       if(this.vida<0 && this.status==Status.VIVO){
           this.status=Status.MORTO;
       }
    }
}
