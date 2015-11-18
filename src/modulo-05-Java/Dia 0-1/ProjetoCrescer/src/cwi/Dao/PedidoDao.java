package cwi.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cwi.jdbc.ConnectionFactory;
import cwi.model.Cliente;
import cwi.model.Pedido;

public class PedidoDao {
	private String queryMaster = "select pedido.idpedido,pedido.dsPedido,cliente.idCliente,cliente.nmCliente,cliente.nrCpf from pedido inner join cliente on pedido.idcliente = cliente.idcliente ";
	public void  insert(Pedido pedido) throws SQLException{
		try(Connection conexao = new ConnectionFactory().getConnection()) {
			StringBuilder query = new StringBuilder();
			query.append("insert into pedido (idpedido,idcliente,dsPedido) values (pedido_seq.nextval,?,?)");
			PreparedStatement statement = conexao.prepareStatement(query.toString());
			statement.setLong(1, pedido.getCliente().getIDCliente());
			statement.setString(2, pedido.getDescricao());
			statement.execute();
		} catch (SQLException e) {
			throw e;
		}
	}
	public List<Pedido> listAll() throws SQLException{
		try(Connection conexao = new ConnectionFactory().getConnection()){
			StringBuilder query = new StringBuilder();
			query.append("select pedido.idpedido,pedido.dsPedido,cliente.idCliente,cliente.nmCliente,cliente.nrCpf from pedido ");
			query.append(" inner join cliente on pedido.idcliente = cliente.idcliente");
			PreparedStatement statement = conexao.prepareStatement(query.toString());
			ResultSet result = statement.executeQuery();
			
			List<Pedido> lista = new ArrayList<Pedido>();
			while(result.next()){
				Cliente cliente= new Cliente(result.getLong(3),result.getString(4),result.getString(5));
				Pedido pedido = new Pedido(result.getLong(1),cliente,result.getString(2));
				lista.add(pedido);
			}
			return lista;
			
		} catch (SQLException e) {
			throw e;
		}
	}
	public Pedido load(long id) throws SQLException{
		try(Connection conexao = new ConnectionFactory().getConnection()){
			StringBuilder query = new StringBuilder();
			query.append("select pedido.idpedido,pedido.dsPedido,cliente.idCliente,cliente.nmCliente,cliente.nrCpf from pedido ");
			query.append(" inner join cliente on pedido.idcliente = cliente.idcliente where idpedido = ?");
			PreparedStatement statement = conexao.prepareStatement(query.toString());
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if(result.next()){
				Cliente cliente= new Cliente(result.getLong(3),result.getString(4),result.getString(5));
				Pedido pedido = new Pedido(result.getLong(1),cliente,result.getString(2));
				return pedido;
			}else{
				throw new RuntimeException("Nenhum pedido encontrado");
			}

			
		} catch (SQLException e) {
			throw e;
		}
	}
	public List<Pedido> findPedidos(Cliente cliente) throws SQLException{
		List<Pedido> lista = new ArrayList<Pedido>();
		
		try(Connection conexao = new ConnectionFactory().getConnection()){
			StringBuilder query = new StringBuilder();
			query.append(" select idpedido,dsPedido from pedido where idcliente = ?");
			PreparedStatement statement = conexao.prepareStatement(query.toString());
			statement.setLong(1, cliente.getIDCliente());
			ResultSet result = statement.executeQuery();
			
			while(result.next()){
				Pedido pedido = new Pedido(result.getLong(1),cliente,result.getString(2));
				lista.add(pedido);
			}
			
		} catch (SQLException e) {
			throw e;
		}
		
		return lista;
	}
}
