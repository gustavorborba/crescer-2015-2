public class Dwarf{
    private String nome;
    private int vida,experiencia;
    private Status status;
    private DataTerceiraEra dataNascimento;
    public Dwarf(String novoNome){
        nome=novoNome;
        vida=110;
        experiencia=0;
    }
    public Dwarf(String novoNome,DataTerceiraEra data){
        nome=novoNome;
        dataNascimento=data;
    }
    public int getVida(){
        return vida;
    }
    public void atacado(){
        if(this.status!=Status.MORTO){
              this.vida-=10;
        }
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