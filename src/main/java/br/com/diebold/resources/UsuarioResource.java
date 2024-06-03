package br.com.diebold.resources;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.diebold.domain.EventoParts;
import br.com.diebold.domain.Usuario;
import br.com.diebold.dto.UsuarioDTO;
import br.com.diebold.response.Response;
import br.com.diebold.security.JWTAuthorizationFilter;
import br.com.diebold.service.EventoPartsService;
import br.com.diebold.service.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "/usuarios")
@SecurityRequirement(name = "bearer-key") //Swagger
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	@Autowired
	private EventoPartsService eps;

	@GetMapping("/buscar/{id}")
//	@RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Usuario obj = new Usuario();
		try {
			obj = service.find(id);
			return ResponseEntity.ok().body(obj);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "usuarios/buscar/{id}", JWTAuthorizationFilter.getUsername(), "find()",
					null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping("/todos")
//	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		Response<UsuarioDTO> response = new Response<UsuarioDTO>();
		try {
		List<UsuarioDTO> userDto = service.findAll();
		response.setUsuarioDTO(userDto);
		return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "usuarios/todos", JWTAuthorizationFilter.getUsername(), "findAll()",
					null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(response);
	}

	@PostMapping("/login/{usuario},{senha}")
//	@RequestMapping(value = "/login/{usuario},{senha}", method = RequestMethod.POST)
	public ResponseEntity<UsuarioDTO> login(@PathVariable String usuario, @PathVariable String senha) {
		Usuario user = new Usuario();
		UsuarioDTO userDTO = new UsuarioDTO();
		try {
		 user = service.login(usuario, senha);
		 userDTO = new UsuarioDTO(user);
		return ResponseEntity.ok().body(userDTO);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "usuarios/login/{usuario},{senha}", JWTAuthorizationFilter.getUsername(), "login()",
					null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(userDTO);
	}

	@PostMapping("/usuario")
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	public ResponseEntity<?> usuario(@Valid @RequestBody String usuario) {
		UsuarioDTO userDto = new UsuarioDTO();
		Response<UsuarioDTO> response = new Response<UsuarioDTO>();
		try {
		userDto = service.findByUsuario(usuario);
		response.setUsuario(userDto);
		return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "usuarios/usuario", JWTAuthorizationFilter.getUsername(), "usuario()",
					null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(response);		
	}

// NEW ENDPOINT

	@PostMapping("/mobile/ObterUsuario")
//	@RequestMapping(value = "/mobile/ObterUsuario", method = RequestMethod.POST)
	public ResponseEntity<?> ObterUsuario(@Valid @RequestBody ObjectNode objectNode) {
		UsuarioDTO userDto = new UsuarioDTO();
		try {
		String usuario = objectNode.get("usuario").asText();
		// Response<UsuarioDTO> response = new Response<UsuarioDTO>();
		 userDto = service.findByUsuario(usuario);
		// response.setUsuario(userDto);
		return ResponseEntity.ok().body(userDto);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "usuarios/mobile/ObterUsuario", JWTAuthorizationFilter.getUsername(), "ObterUsuario()",
					null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(userDto);
	}

	@PostMapping("/insert")
//	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioDTO obj) {
		Usuario user = new Usuario();
		URI uri = null;
		try {
		user = service.fromInsertDTO(obj);
		uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	} catch (Exception e) {
		StringWriter errors = new StringWriter();
		e.printStackTrace(new PrintWriter(errors));
		Date dt = new Date();
		EventoParts ep = new EventoParts(dt, "usuarios/insert", JWTAuthorizationFilter.getUsername(), "insert()",
				null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
		eps.save(ep);
		e.printStackTrace();
	}
		return ResponseEntity.created(uri).build();
	}

	@PostMapping("/update")
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Void> update(@Valid @RequestBody UsuarioDTO obj) {
		Usuario user = new Usuario();
		URI uri = null;
		try {
		user = service.fromDTO(obj);
		uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "usuarios/update", JWTAuthorizationFilter.getUsername(), "update()",
					null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.created(uri).build();
	}

	@PostMapping("/resetarSenha")
//	@RequestMapping(value = "/resetarSenha", method = RequestMethod.POST)
	public ResponseEntity<Void> resetarSenha(@Valid @RequestBody String usuario) {
		Usuario user = new Usuario();
		URI uri = null;
		try {
		service.resetarSenha(usuario);
		uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "usuarios/resetarSenha", JWTAuthorizationFilter.getUsername(), "resetarSenha()",
					null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping("/alterarSenha")
//	@RequestMapping(value="/alterarSenha", method=RequestMethod.POST)
	public ResponseEntity<Void> alterarSenha(@Valid @RequestBody ObjectNode objectNode) {
		String usuario = objectNode.get("usuario").asText();
		String senha = objectNode.get("senha").asText();
		Usuario user = new Usuario();	
		service.alterarSenha(usuario,senha);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();	
	}
}