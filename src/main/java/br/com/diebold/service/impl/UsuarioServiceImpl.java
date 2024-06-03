package br.com.diebold.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.diebold.domain.Usuario;
import br.com.diebold.repositories.UsuarioRepository;
import br.com.diebold.security.UserSS;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> user = repo.findByUsuario(username);		
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}		
		return new UserSS(user.get().getId()  , user.get().getUsuario(), user.get().getSenha(),user.get().getPerfilSistema());
	}

}
