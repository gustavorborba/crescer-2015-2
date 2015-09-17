/**
 * Representa objetos do tipo Elfo.
 */
public class Elfo {
    private String nome;
    private int flechas, experiencia;
    private Status status;
    /* Type initializer
     * Executa antes de cada construtor
    {
        flechas = 42;
    }
    */
    public Elfo(String nome, int flechas) {
        this.nome = nome;
        this.flechas = flechas;
        this.status=Status.VIVO;
    }
    
    public Elfo(String nome) {
        this(nome, 42);
    }

    /* PascalCase (C#, VB.NET)
     *      public void AtirarFlechaDeFogo
     * camelCase (Java, JavaScript)
     *      public void atirarFlechaDeFogo
    */
   
    public void atirarFlecha() {
        flechas--;
        experiencia++;
        //experiencia += 1;
        //experiencia = experiencia + 1;
    }
    
    /*
     * 
     * public atirarFlechaRefactory(this.flechas, this.experiencia){
     *     if(boolean acertar == true){
     *         flechas--;
     *         experiencia++;
     *      }else{
     *          flechas--;
     *      }
     *  }
     */
    public String getNome(){
        return nome;
    }
    
    public int getFlecha(){
        return flechas;
    }
    
    public void setFlecha(int novaFlecha){
        if(novaFlecha>this.flechas){
            this.flechas=novaFlecha;
        }
    }
    public int getExp(){
        return experiencia;
    }
    public void atacDwarf(Dwarf anao){
        atirarFlecha();
        anao.atacado();
    }
    public String toString(){
        boolean singular = Math.abs(this.flechas)==1;
        String flech=singular ? "flecha" : "flechas";
        boolean nivelSingular = Math.abs(this.experiencia)==1;
        String nivel;
        nivel = nivelSingular ? "nivel" : "niveis";
        String format=String.format("%s possui %d %s e %d %s de experiencia",this.nome,this.flechas,flech,this.experiencia,nivel);
        return format;
    }
    public Status getStatus(){
        return this.status;
    }
}
