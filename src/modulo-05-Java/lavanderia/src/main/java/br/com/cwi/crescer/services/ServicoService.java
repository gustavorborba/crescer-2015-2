package br.com.cwi.crescer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ServicoDao;
import br.com.cwi.crescer.domain.Servico;

@Service
public class ServicoService{
	ServicoDao servicoDAO;
	
	@Autowired
	public ServicoService(ServicoDao servico){
		this.servicoDAO = servico;
	}
	public List<Servico> listarTodosServicos(){
		return servicoDAO.listarTodosServicos();
	}
}
