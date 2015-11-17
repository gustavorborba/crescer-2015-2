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
			PreparedStatement statement = conexao.prepareStatement("insert into cliente(idCliente,nmCliente,nrCpf) values(?,?,?)");
			statement.setLong(1, cliente.getIDCliente());
			statement.setString(2, cliente.getNmNome());
			statement.setString(3, cliente.nrCpf());
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
}
