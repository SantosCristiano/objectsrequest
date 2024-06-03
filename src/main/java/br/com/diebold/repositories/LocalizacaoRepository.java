package br.com.diebold.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diebold.domain.Localizacao;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer> {

	Localizacao findFirstByNomeLocalizacaoOrderByIdAsc(String nomeLocalizacao);

	
}
