package cwi.Dao;

import java.sql.SQLException;
import java.util.List;

import cwi.model.Servico;

public interface IServicoDao {
	public void insert(Servico servico) throws SQLException;
	public List<Servico> listAll() throws SQLException;
}
