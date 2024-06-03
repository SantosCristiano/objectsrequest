package br.com.diebold.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diebold.domain.EnderecoAlternativo;

@Repository
public interface EnderecoAlternativoRepository extends JpaRepository<EnderecoAlternativo, Integer> {

	
	
}
