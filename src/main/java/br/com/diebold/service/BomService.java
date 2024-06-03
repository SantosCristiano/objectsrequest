package br.com.diebold.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diebold.domain.Bom;
import br.com.diebold.dto.BomDTO;
import br.com.diebold.dto.EquipamentoDTO;
import br.com.diebold.repositories.BomRepository;
import br.com.diebold.utils.ObjectMapperUtils;

@Service
public class BomService {

	@Autowired
	private BomRepository repo;
	
	public List<EquipamentoDTO> find() {
		
		List<String> boms = new ArrayList<String>();
		boms =  repo.findDistinctProductNameNative();
		List<EquipamentoDTO> equipDto = new ArrayList<EquipamentoDTO>();
		for (int i = 0; i < boms.size(); i++) {
			EquipamentoDTO b = new EquipamentoDTO();
			b.setEquipamento(boms.get(i));
			equipDto.add(b);
		}
		return equipDto;
	}

	public List<BomDTO> findAll(EquipamentoDTO obj) {
		List<Bom> bom = new ArrayList<Bom>();
		bom = repo.findAllByProductNameOrderByItemFamilyAsc(obj.getEquipamento());
		List<BomDTO>  bomDto = new ArrayList<BomDTO>((ObjectMapperUtils.mapAll(bom, BomDTO.class))) ;	
		return bomDto;
	}
	

}
