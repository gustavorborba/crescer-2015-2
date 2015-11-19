package Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import cwi.Dao.PedidoDao;
import cwi.model.Pedido;

public class PedidoDaoTest {
	@Test
	public void pedidoLoadTest() throws SQLException{
		PedidoDao repo = new PedidoDao();
		Pedido pedido = repo.load(1);
		assertEquals(pedido.getDescricao(),"Desc");
	}
}
