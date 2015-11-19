package cwi.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cwi.jdbc.ConnectionFactory;
import cwi.model.Servico;

public class ServicoDao implements IServicoDao {
	public void insert(Servico servico) throws SQLException{
		try(Connection conexao = new ConnectionFactory().getConnection()) {
			PreparedStatement statement = conexao.prepareStatement("insert into Servico (idServico,dsServico) values (?,?)");
			statement.setLong(1, servico.getIDServico());
			statement.setString(2, servico.getDSServico());
			statement.execute();
		} catch (SQLException e) {
			throw e;
		}
	}
	public List<Servico> listAll() throws SQLException{
		List<Servico> lista = new ArrayList<Servico>();
		try(Connection conexao = new ConnectionFactory().getConnection()){
			PreparedStatement statement = conexao.prepareStatement("select idServico, dsServico from Servico");
			ResultSet result = statement.executeQuery();
			while(result.next()){
				lista.add(new Servico(result.getLong(1),result.getString(2)));
			}
		} catch (SQLException e){
			throw e;
		}
		return lista;
	}
}
