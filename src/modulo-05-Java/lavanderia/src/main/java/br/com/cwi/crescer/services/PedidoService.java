package br.com.cwi.crescer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.PedidoDao;

@Service
public class PedidoService {
	PedidoDao pedidoDAO = new PedidoDao();
	
	@Autowired
	public PedidoService(PedidoDao pedidoDAO){
		this.pedidoDAO = pedidoDAO;
	}
}
