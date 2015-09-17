/**
 * Representa objetos do tipo Elfo.
 */
public class Elfo {
    private String nome;
    private int flechas, experiencia;
    
    /* Type initializer
     * Executa antes de cada construtor
    {
        flechas = 42;
    }
    */
    public Elfo(String nome, int flechas) {
        this.nome = nome;
        this.flechas = flechas;
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
        String frase;
        frase = this.getNome();
        frase += " possui ";
        frase += this.getFlecha();
        frase += " flechas e ";
        frase += this.getExp();
        frase += " niveis de experiencia";
        return frase;
    }
}
