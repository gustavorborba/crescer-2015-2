package cwi.model;

public class Pedido {
	private long idPedido;
	private Cliente cliente;
	private String descricao;
	
	public Pedido(Cliente cliente, String descricao){
		this.cliente = cliente;
		this.descricao = descricao;
	}
	public Pedido(long id,Cliente cliente,String descricao){
		this.idPedido = id;
		this.cliente = cliente;
		this.descricao = descricao;
	}
	public Cliente getCliente(){
		return this.cliente;
	}
	public long getIdPedido(){
		return this.idPedido;
	}
	public String getDescricao(){
		return this.descricao;
	}
}
