package br.com.cwi.crescer.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.dto.PedidoClienteDTO;
import br.com.cwi.crescer.dto.PedidoDTO;

public class PedidoMapper {

	public static PedidoDTO pedidoToDTO(Pedido pedido){
		PedidoDTO pedidoDTO = new PedidoDTO();
		pedidoDTO.setIdPedido(pedido.getIdPedido());
		pedidoDTO.setValor(pedido.getValor());
		pedidoDTO.setSituacao(pedido.getSituacao());
		pedidoDTO.setDataEntrega(pedido.getDataEntrega());
		pedidoDTO.setDataInclusao(pedido.getDataInclusao());
		return pedidoDTO;
	}
	
	public static List<PedidoDTO> AllPedidosToDTO(List<Pedido> pedidos){
		List<PedidoDTO> pedidosDTO= new ArrayList<PedidoDTO>(); 
		for(Pedido pedido : pedidos){
			pedidosDTO.add(PedidoMapper.pedidoToDTO(pedido));
		}
		return pedidosDTO;
	}
	
	public static PedidoClienteDTO clienteEmPedidoCLienteDTO(Cliente cliente){
		PedidoClienteDTO pedido = new PedidoClienteDTO();
		pedido.setIdCliente(cliente.getIdCliente());
		pedido.setNomeCliente(cliente.getNome());
		pedido.setCpf(cliente.getCpf());
		pedido.setPedidosVInculados(PedidoMapper.AllPedidosToDTO(cliente.getPedidos()));
		return pedido;
	}
}
