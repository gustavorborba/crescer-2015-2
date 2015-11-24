package br.com.cwi.crescer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ClienteDao;

@Service
public class ClienteService {
	private ClienteDao clienteDAO;
	
	@Autowired
	public ClienteService(ClienteDao dao){
		this.clienteDAO = dao;
	}
	
	public List<ClienteDTO> listarClientesAtivos(){
		
	}
}
