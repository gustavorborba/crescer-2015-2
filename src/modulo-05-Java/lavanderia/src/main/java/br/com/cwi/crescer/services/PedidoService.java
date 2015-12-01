package br.com.cwi.crescer.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cwi.crescer.dao.PedidoDao;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.dto.ItemDTO;
import br.com.cwi.crescer.dto.PedidoClienteDTO;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.mapper.ItemMapper;
import br.com.cwi.crescer.mapper.PedidoMapper;
import br.com.cwi.crescer.services.utils.PrecoService;

@Service
public class PedidoService {
	private PedidoDao pedidoDAO = new PedidoDao();
	@Autowired
	public PedidoService(PedidoDao pedidoDAO){
		this.pedidoDAO = pedidoDAO;

	}
	
	public Pedido procurarPorId(Long id){
		return pedidoDAO.findById(id);
	}
	public Long cadastrarPedido(Long idCliente){
		Pedido pedido = new Pedido();
		Cliente cliente = new Cliente();
		cliente.setIdCliente((long)idCliente);
		pedido.setCliente(cliente);
		pedido.setDataInclusao(new Date());
		pedido.setValor(new BigDecimal(0));
		pedido.setSituacao(SituacaoPedido.PENDENTE);
		return pedidoDAO.salvarAlteracoes(pedido).getIdPedido();
	}
	
	public Pedido atualizarPrecoPedido(Pedido pedido,Item item){
		pedido = pedidoDAO.findById(pedido.getIdPedido());
		Pedido pedidoFinal = PrecoService.calcularNovoPrecoBruto(pedido, item);
		pedidoDAO.salvarAlteracoes(pedidoFinal);
		return pedidoFinal;
	}
	
	public List<PedidoDTO> listarPedidosPorCliente(Long idCliente){
		Cliente cliente = new Cliente();
		cliente.setIdCliente(idCliente);
		return PedidoMapper.AllPedidosToDTO(pedidoDAO.listarPedidosPorCliente(cliente));
	}

	public PedidoClienteDTO criarDTOQueContemListaDePedidos(Cliente cliente){
		boolean clienteNaoEncontrado = cliente == null;
		if(clienteNaoEncontrado){
			return new PedidoClienteDTO();
		}
		PedidoClienteDTO pedidoDTO = PedidoMapper.clienteEmPedidoCLienteDTO(cliente);
		return pedidoDTO;
	}
	
	
	public List<ItemDTO> listarItensVinculadosAPedido(Long id){
		Pedido pedido = pedidoDAO.findById(id);
		return ItemMapper.allItemTOItemDTO(pedido.getItens());
	}
	
	public Pedido alterarSituacaoPedido(Long idPedido,SituacaoPedido situacao){
		Pedido pedido = new Pedido();
		pedido = this.procurarPorId(idPedido);
		pedido.setSituacao(situacao);
		return pedidoDAO.salvarAlteracoes(pedido);
	}
}
