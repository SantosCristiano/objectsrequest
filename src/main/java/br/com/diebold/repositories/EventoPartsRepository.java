package br.com.diebold.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diebold.domain.EventoParts;

@Repository
public interface EventoPartsRepository extends JpaRepository<EventoParts, Integer> {


	
	
}
