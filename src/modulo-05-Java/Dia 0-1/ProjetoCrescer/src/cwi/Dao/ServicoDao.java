package cwi.Dao;

import java.sql.Connection;

import cwi.jdbc.ConnectionFactory;
import cwi.model.Servico;

public class ServicoDao {
	public void insert(Servico servico){
		try(Connection conexao = new ConnectionFactory().getConnection()) {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
