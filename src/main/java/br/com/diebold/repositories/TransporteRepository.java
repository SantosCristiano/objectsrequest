package br.com.diebold.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diebold.domain.Transporte;

@Repository
public interface TransporteRepository extends JpaRepository<Transporte, Integer> {

	Transporte findFirstByIdOrderByIdDesc(Integer id);
	
	Transporte findFirstByNomeOrderByIdDesc(String nome);
	
}
