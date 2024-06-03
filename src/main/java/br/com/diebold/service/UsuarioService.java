package br.com.diebold.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.diebold.domain.Filial;
import br.com.diebold.domain.Perfil;
import br.com.diebold.domain.Tecnico;
import br.com.diebold.domain.Usuario;
import br.com.diebold.dto.UsuarioDTO;
import br.com.diebold.repositories.FilialRepository;
import br.com.diebold.repositories.PerfilRepository;
import br.com.diebold.repositories.TecnicoRepository;
import br.com.diebold.repositories.UsuarioRepository;
import br.com.diebold.service.exceptions.ObjectNotFoundException;
import br.com.diebold.utils.ObjectMapperUtils;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	@Autowired
	private PerfilRepository perfilRepo;
	@Autowired
	private FilialRepository filialRepository;
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
		}
	
	public Usuario login(String usuario, String senha) {

		Optional<Usuario> obj = repo.findByUsuario(usuario);
		if(pe.matches(senha, obj.get().getSenha())) {
			System.out.println("SENHAS IGUAIS : "+senha + " Banco: "+ obj.get().getSenha());
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Usuario: " + usuario + ", Tipo: " + Usuario.class.getName()));
		}else {
			System.out.println("SENHAS DIFERENTES : "+senha + " Banco: "+ obj.get().getSenha());
			obj = null;
			
		}
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Usuario: " + usuario + ", Tipo: " + Usuario.class.getName()));
		}
	
	
	
	public Usuario fromDTO(UsuarioDTO objDto) {
		Usuario user = new Usuario(objDto);		
		List<Perfil> p = new ArrayList<Perfil>();
		List<Filial> f = new ArrayList<Filial>();
		repo.deleteRelacionamento(user.getId());
		filialRepository.deleteRelacionamento(user.getId());
		
		for(int i=0; i < user.getPerfis().size(); i++) {
			Optional<Perfil> op = perfilRepo.findById(user.getPerfis().get(i).getId()); 
			op.get().getUsuarios().add(user);
			p.add(op.get());			
		}
		for(int i=0; i < user.getFiliais().size(); i++) {
			Optional<Filial> op = filialRepository.findById(user.getFiliais().get(i).getId()); 
			op.get().getUsuarios().add(user);
			f.add(op.get());			
		}
		Tecnico tec = new Tecnico();
		tec = tecnicoRepository.findByIdTecnico(objDto.getTecnico().getIdTecnico());
		user.setSenha(objDto.getSenha());
		user.setAlteraSenha(objDto.isAlteraSenha());
		if(tec != null) {
			user.setTecnico(tec);
		}
		perfilRepo.saveAll(p);
		repo.save(user);
		return user ;
	}

	
	public Usuario fromInsertDTO(UsuarioDTO objDto) {
		Usuario user = new Usuario(objDto);
		Tecnico tec = new Tecnico();

		try {
			tec = tecnicoRepository.findByIdTecnico(objDto.getTecnico().getIdTecnico());
		} catch (Exception e) {
			System.out.println("**********************************************************");
			e.printStackTrace();
		}

		user.setSenha(pe.encode("DN@54321"));
		user.setAlteraSenha(true);
		if(tec != null) {
			user.setTecnico(tec);
		}
		repo.save(user);
		return user ;
	}
	
	
	
	public List<UsuarioDTO> findAll() {
		List<Usuario> user = new ArrayList<Usuario>();
		try {
			user = repo.findAll();
			List<UsuarioDTO>  userDto = new ArrayList<UsuarioDTO>((ObjectMapperUtils.mapAll(user, UsuarioDTO.class))) ;		
			return userDto;	
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return null;
	}
	
	public UsuarioDTO findByUsuario(String usuario) {
		Optional<Usuario> optuser;
		Usuario user = new Usuario();
		try {
			optuser = repo.findByUsuario(usuario);
			user = optuser.get();
			UsuarioDTO  userDto = new UsuarioDTO(user) ;		
			return userDto;
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return null;
	}
	
	public UsuarioDTO resetarSenha(String usuario) {
		Optional<Usuario> optuser;
		Usuario user = new Usuario();
		try {
			optuser = repo.findByUsuario(usuario);
			user = optuser.get();
			user.setSenha(pe.encode("DN@54321"));
			user.setAlteraSenha(true);
			repo.save(user);
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return null;
	}
	
	public UsuarioDTO alterarSenha(String usuario, String senha) {
		Optional<Usuario> optuser;
		Usuario user = new Usuario();
		try {
			optuser = repo.findByUsuario(usuario);
			user = optuser.get();
			user.setSenha(pe.encode(senha));
			user.setAlteraSenha(false);
			repo.save(user);
		} catch (Exception e) {
			e.printStackTrace();		
		}
		return null;
	}
	
	
}
