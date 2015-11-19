package cwi.Dao;

import java.sql.SQLException;
import java.util.List;

import cwi.model.Cliente;

public interface IClienteDao {
	public void insert(Cliente cliente) throws SQLException;
	public List<Cliente> listAll() throws SQLException;
	public void delete(long id) throws SQLException;
	public Cliente load(long id) throws SQLException;
	public void update(Cliente cliente) throws SQLException;
	public List<Cliente> find(Cliente cliente) throws SQLException;
}
