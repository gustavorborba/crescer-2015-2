package Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import cwi.Dao.ClienteDao;
import cwi.model.Cliente;

public class ClienteDaoTest {
	@Test
	public void clienteLoadTest() throws SQLException{
		ClienteDao repo = new ClienteDao();
		Cliente cliente = repo.load(2);
		assertEquals(cliente.getNmNome(),"Chuck Berry");
	}
}
