public class Dwarf{
    private String nome;
    private int vida,experiencia;
    private Status status;
    
    public Dwarf(String novoNome){
        nome=novoNome;
        vida=110;
    }
    public int getVida(){
        return vida;
    }
    public void atacado(){
        this.vida-=10;
        if(this.vida==0){
            this.status=Status.MORTO;
        }
    }
    public String getNome(){
        return this.nome;
    }
    public Status getStatus(){
        return this.status;
    }
}