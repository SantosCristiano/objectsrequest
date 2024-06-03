package br.com.diebold.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.diebold.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByUsuarioAndSenha(String usuario, String senha);
	Optional<Usuario> findByUsuario(String usuario);
	Usuario findFirstByUsuario(String usuario);
	
	@Modifying
	@Transactional
	@Query(value = "delete FROM geoloc.pr_perfil_usuario where usuario_id = ?1", nativeQuery = true)
	void deleteRelacionamento(int idUsuario);
	
}
