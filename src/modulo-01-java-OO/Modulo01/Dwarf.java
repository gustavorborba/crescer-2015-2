public class Dwarf{
    private String nome;
    private int vida,experiencia;
    private Status status;
    private DataTerceiraEra dataNascimento;
    private Inventario inventario=new Inventario();
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
        double numSorte=this.getNumeroSorte();
        if(numSorte<0 && this.vida!=0){
            this.experiencia+=2;
        }
        if(numSorte>100 && this.vida !=0){
            this.vida-=10;
        }
        if(this.vida==0 && this.status==Status.VIVO){
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
        return this.dataNascimento;
    }
    public int getExperiencia(){
        return this.experiencia;
    }
    public double getNumeroSorte(){
        double sorte=101.0;
        if(this.dataNascimento.ehBissexto() && (this.getVida()>=80 && this.getVida()<=90)){
            sorte=sorte * -33;
        }
        if(!this.dataNascimento.ehBissexto() && (this.nome.equals("Seixas") || this.nome.equals("Meireles"))){
            sorte=(sorte * 33) %100;
        }
        return sorte;
    }
    public Inventario getInventario(){
        return inventario;
    }
    public void tentarSorte(){
        if(getNumeroSorte()==-3333.0){
            for(int i=0;i<inventario.getTamanhoArray();i++){
                inventario.getItemEspecifico(i).sortudo();
            }
        }
    }
}