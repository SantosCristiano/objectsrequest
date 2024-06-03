package br.com.diebold.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diebold.domain.Atendimento;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer> {

	Atendimento findById(String idTecnico);
	
	List<Atendimento> findByIdTecnicoAndStAtendimento(Integer idTecnico, char st_atendimento);

	
}
