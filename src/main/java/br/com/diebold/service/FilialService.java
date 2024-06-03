package br.com.diebold.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diebold.domain.Filial;
import br.com.diebold.dto.FilialDTO;
import br.com.diebold.repositories.FilialRepository;
import br.com.diebold.service.exceptions.ObjectNotFoundException;
import br.com.diebold.utils.ObjectMapperUtils;

@Service
public class FilialService {
	
	@Autowired
	private FilialRepository repo;
	
	public Filial findById(Integer id) {
		Optional<Filial> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id));
	}
	
	public FilialDTO findByName(String nome) {
		Optional<Filial> optFilial;
		Filial filial = new Filial();
		try {
			optFilial = repo.findByNome(nome);
			filial = optFilial.get();
			FilialDTO  filialDto = new FilialDTO(filial) ;		
			return filialDto;
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return null;
	}
	
	
	
	public Filial fromDTO(FilialDTO objDto) {
		Filial filial = new Filial(objDto);
		repo.deleteRelacionamento(objDto.getId());
		repo.save(filial);
		return filial;
	}

	
	public Filial fromInsertDTO(FilialDTO objDto) {
		Filial filial = new Filial(objDto);
		repo.save(filial);
		return filial ;
	}
	
	public List<FilialDTO> findAll() {
		List<Filial> filial = new ArrayList<Filial>();
		try {
			filial = repo.findAll();
			List<FilialDTO>  filialDto = new ArrayList<FilialDTO>((ObjectMapperUtils.mapAll(filial, FilialDTO.class))) ;		
			return filialDto;	
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return null;
	}	
}
