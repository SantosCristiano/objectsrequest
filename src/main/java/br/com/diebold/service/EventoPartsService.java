package br.com.diebold.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diebold.domain.EventoParts;
import br.com.diebold.repositories.EventoPartsRepository;

@Service
public class EventoPartsService {

	@Autowired
	private EventoPartsRepository repo;

	public void save(EventoParts ev) {
		try {
			repo.save(ev);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
