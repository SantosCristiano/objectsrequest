package br.com.diebold.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diebold.domain.Funcionalidade;
import br.com.diebold.dto.FuncionalidadeDTO;
import br.com.diebold.repositories.FuncionalidadeRepository;

@Service
public class FuncionalidadeService {

	@Autowired
	private FuncionalidadeRepository repo;

	public Funcionalidade save(FuncionalidadeDTO obj) {
		Funcionalidade f = new Funcionalidade(obj.getId(), obj.getFuncionalidade(),
				obj.getNmFuncionalidade(), obj.getPagina());
	f = repo.save(f);		
		return f ;
	}
	

	public List<Funcionalidade> BuscarTodos() {
		List<Funcionalidade> fList = new ArrayList<Funcionalidade>();
		fList = repo.findAll();	
		return fList ;
	}
	
	public List<FuncionalidadeDTO> toDTO(List<Funcionalidade> funcionalidade ) {
		List<FuncionalidadeDTO> pdtoList = new ArrayList<FuncionalidadeDTO>();
		for (int i = 0; i < funcionalidade.size(); i++) {
			FuncionalidadeDTO sdto = new FuncionalidadeDTO(funcionalidade.get(i));			
			pdtoList.add(sdto);
		}
		return pdtoList;
	}
	
	
	
}
