package cwi.model;

public class Cliente {
	private long idCliente;
	private String nmNome;
	private String nrCpf;
	
	public long getIDCliente(){
		return this.idCliente;
	}
	public String getNmNome(){
		return this.nmNome;
	}
	public String getNrCpf(){
		return this.nrCpf;
	}
	public Cliente(long id,String nome,String cpf){
		this.idCliente = id;
		this.nmNome = nome;
		this.nrCpf = cpf;
	}
	public Cliente(String nome,String cpf){
		this.nmNome = nome;
		this.nrCpf = cpf;
	}
	public Cliente(){}
}
