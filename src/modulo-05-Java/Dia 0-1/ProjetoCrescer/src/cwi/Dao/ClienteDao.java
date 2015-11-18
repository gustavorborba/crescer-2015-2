package cwi.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cwi.jdbc.ConnectionFactory;
import cwi.model.Cliente;

public class ClienteDao {
	public void insert(Cliente cliente) throws SQLException{
		try{
			Connection conexao = new ConnectionFactory().getConnection();
			PreparedStatement statement = conexao.prepareStatement("insert into cliente(idCliente,nmCliente,nrCpf) values(cliente_seq.nextval,?,?)");
			statement.setString(1, cliente.getNmNome());
			statement.setString(2, cliente.getNrCpf());
			statement.execute();
		} catch(SQLException e){
			throw e;
		}
	}
	public List<Cliente> listAll() throws SQLException{
		List<Cliente> lista = new ArrayList<Cliente>();
		try(Connection conexao = new ConnectionFactory().getConnection()){
			StringBuilder query = new StringBuilder();
			query.append("select idCliente,nmCliente,nrCpf from cliente");
			PreparedStatement statement = conexao.prepareStatement(query.toString());
			ResultSet result = statement.executeQuery();
			
			while(result.next()){
				lista.add(new Cliente(result.getLong(1),result.getString(2),result.getString(3)));
			}
			
		} catch (SQLException e) {
			throw e;
		}
		return lista;
	}
	public void delete(long id) throws SQLException{
		try(Connection conexao = new ConnectionFactory().getConnection()) {
			StringBuilder query = new StringBuilder();
			query.append("delete from cliente where idCliente = ?");
			PreparedStatement statement = conexao.prepareStatement(query.toString());
			statement.setLong(1, id);
			statement.execute();
			
		} catch (SQLException e) {
			throw e;
		}
	}
	public Cliente load(long id) throws SQLException{
		try(Connection conexao = new ConnectionFactory().getConnection()){
			StringBuilder query = new StringBuilder();
			query.append("select idCliente,nmCliente,nrCpf from cliente where idCliente = ?");
			PreparedStatement statement = conexao.prepareStatement(query.toString());
			statement.setLong(1, id);
			ResultSet result = statement.executeQuery();
			if(result.next()){
				Cliente cliente = new Cliente(result.getLong(1),result.getString(2),result.getString(3));
				return cliente;
			}else{
				throw new RuntimeException("Registo nao encontrado");
			}
		} catch (SQLException e) {
			throw e;
		}
	}
	public void update(Cliente cliente) throws SQLException{
		try(Connection conexao = new ConnectionFactory().getConnection()) {
			StringBuilder query = new StringBuilder();
			query.append("update cliente set nmCliente = ?, nrCpf = ? where idCliente = ?");
			PreparedStatement statement = conexao.prepareStatement(query.toString());
			statement.setString(1, cliente.getNmNome());
			statement.setString(2, cliente.getNrCpf());
			statement.setLong(3, cliente.getIDCliente());
			statement.execute();
		} catch (SQLException e) {
			throw e;
		}
	}
	public List<Cliente> find(Cliente cliente) throws SQLException{
		try(Connection conexao = new ConnectionFactory().getConnection()){
			StringBuilder query = new StringBuilder();
			query.append("select idCliente,nmCliente,nrCpf from cliente where ");
			if(cliente.getNmNome() != null){
				query.append(" nmCliente = ? ");
			}
			if(cliente.getNmNome() != null && cliente.getNrCpf() != null){
				query.append("and");
			}
			if(cliente.getNrCpf() != null){
				query.append(" nrCpf = ?");
			}
			PreparedStatement statement = conexao.prepareStatement(query.toString());
			if(cliente.getNmNome() != null && cliente.getNrCpf() != null){
				statement.setString(1, cliente.getNmNome());
				statement.setString(2, cliente.getNrCpf());
			} else if(cliente.getNmNome() != null){
				statement.setString(1, cliente.getNmNome());
			}else{
				statement.setString(1, cliente.getNrCpf());
			}
			ResultSet result = statement.executeQuery();
			List<Cliente> lista= new ArrayList<Cliente>();
			while(result.next()){
				lista.add(new Cliente(result.getLong(1),result.getString(2),result.getString(3)));
			}
			return lista;
		} catch (SQLException e) {
			throw e;
		}
	}
}