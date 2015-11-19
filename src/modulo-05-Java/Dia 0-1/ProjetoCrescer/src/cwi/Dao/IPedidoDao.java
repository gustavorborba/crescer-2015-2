package cwi.Dao;

import java.sql.SQLException;
import java.util.List;

import cwi.model.Cliente;
import cwi.model.Pedido;

public interface IPedidoDao {
	public void  insert(Pedido pedido) throws SQLException;
	public List<Pedido> listAll() throws SQLException;
	public Pedido load(long id) throws SQLException;
	public List<Pedido> findPedidos(Cliente cliente) throws SQLException;
}
