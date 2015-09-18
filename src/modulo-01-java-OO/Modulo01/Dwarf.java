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
        this.dataNascimento=new DataTerceiraEra(1,1,1);
    }
    public Dwarf(String novoNome,DataTerceiraEra data){
        this(novoNome);
        this.dataNascimento=data;
        
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
    public DataTerceiraEra getNascimento(){
        return dataNascimento;
    }
    public double getNumeroSorte(){
        double sorte=101.0;
        if(this.dataNascimento.ehBissexto()==true && (this.getVida()>=80 && this.getVida()<=90)){
            sorte=sorte * -33;
        }
        if(this.dataNascimento.ehBissexto()==false && (this.getNome()=="Seixas" || this.getNome()=="Meireles")){
            sorte=(sorte * 33) %100;
        }
        return sorte;
    }
}