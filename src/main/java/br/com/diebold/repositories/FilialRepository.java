package br.com.diebold.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.diebold.domain.Filial;

@Repository
public interface FilialRepository extends JpaRepository<Filial, Integer> {

	Optional<Filial> findById(Integer id);
	Optional<Filial> findByNome(String nome);
	
	@Modifying
	@Transactional
	@Query(value = "delete FROM geoloc.pr_filial_usuario where usuario_id = ?1", nativeQuery = true)
	void deleteRelacionamento(int idUsuario);
	
}
