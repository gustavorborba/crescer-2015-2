public class Dwarf{
    private String nome;
    private int vida,experiencia;
    private Status status;
    private DataTerceiraEra dataNascimento;
    public Dwarf(String novoNome){
        this.nome=novoNome;
        this.vida=110;
        this.experiencia=0;
        this.status=Status.VIVO;
    }
    public Dwarf(String novoNome,DataTerceiraEra data){
        this(novoNome);
        this.dataNascimento=new DataTerceiraEra(1,1,1);
        
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