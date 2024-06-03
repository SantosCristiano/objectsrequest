package br.com.diebold.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diebold.domain.ModalidadeEntrega;

@Repository
public interface ModalidadeRepository extends JpaRepository<ModalidadeEntrega, Integer> {

	
	
}
