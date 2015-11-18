package cwi.model;

public class Servico {
	private long idServico;
	private String dsServico;
	
	public Servico(long id, String descricao){
		this.idServico = id;
		this.dsServico = descricao;
	}
	
	public long getIDServico(){
		return this.idServico;
	}
	public String getDSServico(){
		return this.dsServico;
	}
}
