package br.com.diebold.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.diebold.domain.Tecnico;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

	
	Tecnico findByIdTecnico(Integer idTecnico);
	
	Tecnico	findByErp(Integer erp);
 
	
}
