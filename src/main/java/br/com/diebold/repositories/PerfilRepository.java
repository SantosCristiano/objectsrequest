package br.com.diebold.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.diebold.domain.Perfil;


@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

	@Modifying
	@Transactional
	@Query(value = "delete FROM geoloc.pr_perfil_funcionalidade where perfil_id = ?1", nativeQuery = true)
	void deleteRelacionamento(int idPerfil);
}
