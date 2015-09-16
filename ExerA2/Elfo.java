//exercicio1
public class Elfo {
    private String nome;
    private int flechas;
    private int level;
	private float exp;
	Acao ac=new Acao();
    public Elfo(String N) {
		nome=N;
		flechas=42;
		level=0;
		exp=0;
    }
	public void exper(){
		exp++;
		if(exp>=100){
			level++;
			exp=0;
		}
	}
	public int getflec(){
		return flechas;
	}
	
	public int  sflechas(){
		flechas=flechas-1;
		return flechas;
	}
	
	
//exercicio4
	public boolean acertar(){
		Random random = new Random();
		return random.nextBoolean();
	}

	public void atirarFlechaRefactory(){
    if(acertar() == true){
		sflechas();
        exper();
    }
}
	}
	
	