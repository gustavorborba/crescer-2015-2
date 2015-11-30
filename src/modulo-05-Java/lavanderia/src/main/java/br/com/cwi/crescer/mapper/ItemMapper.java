package br.com.cwi.crescer.mapper;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.dto.ItemDTO;

public class ItemMapper {
	public static ItemDTO ItemToDTO(Item item){
		ItemDTO itemDTO = new ItemDTO();
		itemDTO.setIdItem(item.getIdItem());
		itemDTO.setIdPedido(item.getPedido().getIdPedido());
		itemDTO.setMaterial(item.getProduto().getMaterial().getDescricao());
		itemDTO.setServico(item.getProduto().getServico().getDescricao());
		itemDTO.setPeso(item.getPeso());
		itemDTO.setSituacao(item.getSituacao());
		itemDTO.setValorUnitario(item.getValorUnitario());
		itemDTO.setValorTotal(item.getValorTotal());
		return itemDTO;
	}
	public static List<ItemDTO> allItemTOItemDTO(List<Item> item){
		List<ItemDTO> itens= new ArrayList<ItemDTO>();
		for(Item iten : item){
			itens.add(ItemMapper.ItemToDTO(iten));
		}
		return itens;
	}
}
