package br.com.cwi.crescer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.CidadeDao;
import br.com.cwi.crescer.domain.Cidade;

@Service
public class CidadeService {
    private CidadeDao cidadeDAO;

    @Autowired
    public CidadeService(CidadeDao cidadeDAO) {
        this.cidadeDAO = cidadeDAO;
    }

    public List<Cidade> listar() {
        return cidadeDAO.listAll();
    }

}
