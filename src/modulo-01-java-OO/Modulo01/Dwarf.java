public class Dwarf{
    private String nome;
    private int vida;
    
    public Dwarf(String novoNome){
        nome=novoNome;
        vida=110;
    }
    public int getVida(){
        return vida;
    }
    public void atacado(){
        this.vida-=10;
    }
}