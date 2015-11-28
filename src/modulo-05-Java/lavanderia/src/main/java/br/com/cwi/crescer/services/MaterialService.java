package br.com.cwi.crescer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.MaterialDao;
import br.com.cwi.crescer.domain.Material;

@Service
public class MaterialService {
	private MaterialDao materialDAO;
	
	@Autowired
	public MaterialService(MaterialDao material){
		this.materialDAO = material;
	}
	
	public List<Material> listarTodosMateriais(){
		return materialDAO.listarTodosMateriais();
	}
}
