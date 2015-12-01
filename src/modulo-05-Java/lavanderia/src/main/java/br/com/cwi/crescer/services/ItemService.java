package br.com.cwi.crescer.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ItemDao;
import br.com.cwi.crescer.dao.ProdutoDao;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Item.SituacaoItem;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.domain.Produto;

@Service
public class ItemService{
	private ItemDao itemDAO = new ItemDao();
	private ProdutoDao produtoDao = new ProdutoDao();
	private PedidoService pedidoService;
	
	@Autowired
	public ItemService(ItemDao item,ProdutoDao produto,PedidoService pedido){
		this.itemDAO = item;
		this.produtoDao = produto;
		this.pedidoService = pedido;
	}
	
	private BigDecimal valorTotal(BigDecimal valor, BigDecimal peso){
		BigDecimal resultado =  valor.multiply(peso);
		return resultado;
	}
	
	public Item cadastrarItem(Long idProduto,Long idPedido,BigDecimal peso){
		Item item = new Item();
		Pedido pedido = new Pedido();
		pedido.setIdPedido(idPedido);
		Produto produto = produtoDao.findById(idProduto);
		item.setSituacao(SituacaoItem.PENDENTE);
		item.setPeso(peso);
		item.setProduto(produto);
		item.setValorUnitario(produto.getValor());
		item.setIdPedido(pedido);
		item.setValorTotal(valorTotal(item.getValorUnitario(),peso));
		
		itemDAO.salvarAlteracoes(item);
		pedidoService.atualizarPrecoPedido(pedido, item);
		return item;
	}
	public Item processarItem(Long idItem){
		Item item = itemDAO.findById(idItem);
		item.processarItem();
		itemDAO.salvarAlteracoes(item);
		boolean todosItensProcessados = todosItensForamProcessados(item.getPedido().getIdPedido());
		
		if(todosItensProcessados){
			pedidoService.alterarSituacaoPedido(item.getPedido().getIdPedido(), SituacaoPedido.PROCESSADO);
		}
		return item;
	}
	
	public boolean todosItensForamProcessados(Long idPedido){
		Pedido pedido = new Pedido();
		pedido.setIdPedido(idPedido);
		List<Item> pedidos = itemDAO.verificarItemASerProcessado(pedido);
		boolean aSerPeocessado = pedidos.isEmpty();
		return aSerPeocessado;
	}
}
