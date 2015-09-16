//exercicio1
public class Elfo {
    private String nome;
    private int flechas;
    private int level;
	private float exp;
    public Elfo(String N) {
		nome=N;
		flechas=42;
		level=0;
		exp=0;
    }
	void exper(){
		exp++;
		if(exp>=100){
			level++;
			exp=0;
		}
	public int  sflechas(){
		flechas=flechas-1;
		return flechas;
	}
	}