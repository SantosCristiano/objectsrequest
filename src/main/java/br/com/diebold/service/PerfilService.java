package br.com.diebold.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diebold.domain.Filial;
import br.com.diebold.domain.Funcionalidade;
import br.com.diebold.domain.Perfil;
import br.com.diebold.dto.FilialDTO;
import br.com.diebold.dto.PerfilDTO;
import br.com.diebold.repositories.FilialRepository;
import br.com.diebold.repositories.FuncionalidadeRepository;
import br.com.diebold.repositories.PerfilRepository;
import br.com.diebold.utils.ObjectMapperUtils;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository repo;
	
	@Autowired
	private FilialRepository filialRepository;
	
	@Autowired
	private FuncionalidadeRepository func;

	public List<Perfil> BuscarTodos() {
		List<Perfil> fList = new ArrayList<Perfil>();
		fList = repo.findAll();	
		return fList ;
	}
		
	public List<FilialDTO> BuscarTodosFiliais() {
		List<Filial> fList = new ArrayList<Filial>();
		fList = filialRepository.findAll();	
		List<FilialDTO>  FilialDTO = new ArrayList<FilialDTO>((ObjectMapperUtils.mapAll(fList, FilialDTO.class))) ;	

		return FilialDTO ;
	}
	
	public Perfil perfilFuncionalidadefromDTO(PerfilDTO objDto) {
		Perfil p = new Perfil();
		p.setNome(objDto.getNome());
		repo.save(p);
		List<Funcionalidade> flist = new ArrayList<Funcionalidade>();
		List<Integer> idFunc = new ArrayList<Integer>();
		for (int i = 0; i <  objDto.getFuncionalidades().size(); i++) {
			idFunc.add(objDto.getFuncionalidades().get(i).getId());			
		}		
		flist = func.findAllById(idFunc);		
		p.setFuncionalidades(flist);
		repo.save(p);
		for(int i= 0; i < flist.size(); i++ ) {
			flist.get(i).getPerfis().add(p);			
		}
		func.saveAll(flist);		
		return p ;
	}
	
	public Perfil perfilFuncionalidadefromDTOUpdate(PerfilDTO objDto) {
		Perfil p = new Perfil();
		Optional<Perfil> op;
		op = repo.findById(objDto.getId());	
		p = op.get();
		p.setNome(objDto.getNome());
		p.setId(objDto.getId());	
		repo.deleteRelacionamento(p.getId());

		List<Funcionalidade> flist = new ArrayList<Funcionalidade>();
		List<Integer> idFunc = new ArrayList<Integer>();
		for (int i = 0; i <  objDto.getFuncionalidades().size(); i++) {
			idFunc.add(objDto.getFuncionalidades().get(i).getId());			
		}		
		flist = func.findAllById(idFunc);		
		p.setFuncionalidades(flist);
		repo.save(p);
		for(int i= 0; i < flist.size(); i++ ) {
			flist.get(i).getPerfis().add(p);			
		}
		func.saveAll(flist);		
		return p ;
	}
	
	public Perfil fromDTO(PerfilDTO objDto) {
		Perfil p = new Perfil();
		p.setNome(objDto.getNome());
		repo.save(p);
		
		return p ;
	}

	public List<PerfilDTO> toDTO(List<Perfil> perfil ) {
		List<PerfilDTO> pdtoList = new ArrayList<PerfilDTO>();
		for (int i = 0; i < perfil.size(); i++) {
			PerfilDTO sdto = new PerfilDTO(perfil.get(i));			
			pdtoList.add(sdto);
		}
		return pdtoList;
	}
	
}
