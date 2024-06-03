package br.com.diebold.resources;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.diebold.domain.EventoParts;
import br.com.diebold.domain.Funcionalidade;
import br.com.diebold.domain.Perfil;
import br.com.diebold.dto.FuncionalidadeDTO;
import br.com.diebold.dto.PerfilDTO;
import br.com.diebold.response.Response;
import br.com.diebold.security.JWTAuthorizationFilter;
import br.com.diebold.service.EventoPartsService;
import br.com.diebold.service.FuncionalidadeService;
import br.com.diebold.service.PerfilService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "/perfil")
@SecurityRequirement(name = "bearer-key") //Swagger
public class PerfilResource {

	@Autowired
	private PerfilService service;

	@Autowired
	private FuncionalidadeService funcionalidadeService;

	@Autowired
	private EventoPartsService eps;

	@GetMapping("/usuario")
//	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	public ResponseEntity<Response<Perfil>> find() {
		Response<Perfil> response = new Response<Perfil>();
		try {
			List<Perfil> pList = new ArrayList<Perfil>();
			pList = service.BuscarTodos();
			response.setListData(pList);
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "perfil/usuario", JWTAuthorizationFilter.getUsername(), "find()", null,
					e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/filtro")
//	@RequestMapping(value = "/filtro", method = RequestMethod.GET)
	public ResponseEntity<Response<PerfilDTO>> findFiltro() {
		Response<PerfilDTO> response = new Response<PerfilDTO>();
		try {
			List<Perfil> pList = new ArrayList<Perfil>();
			pList = service.BuscarTodos();
			response.setPerfilDto(service.toDTO(pList));
			response.setFilialDTO(service.BuscarTodosFiliais());
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "perfil/filtro", JWTAuthorizationFilter.getUsername(), "findFiltro()",
					null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(response);
	}

	@GetMapping("/funcionalidade")
//	@RequestMapping(value = "/funcionalidade", method = RequestMethod.GET)
	public ResponseEntity<Response<FuncionalidadeDTO>> findFuncionalidadeDTO() {
		Response<FuncionalidadeDTO> response = new Response<FuncionalidadeDTO>();
		try {
		List<Funcionalidade> fList = new ArrayList<Funcionalidade>();
		fList = funcionalidadeService.BuscarTodos();
		response.setFuncionalidadeDto(funcionalidadeService.toDTO(fList));
		return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "perfil/funcionalidade", JWTAuthorizationFilter.getUsername(), "findFuncionalidadeDTO()",
					null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(response);
	}

	@PostMapping("/insert")
//	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PerfilDTO obj) {
		Perfil pd = new Perfil();
		URI uri = null;
		try {
		pd = service.fromDTO(obj);
		uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pd.getId()).toUri();
		return ResponseEntity.created(uri).build();
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "perfil/insert", JWTAuthorizationFilter.getUsername(), "insert()",
					null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.created(uri).build();

	}

	@PostMapping("/insertFuncionalidade")
//	@RequestMapping(value = "/insertFuncionalidade", method = RequestMethod.POST)
	public ResponseEntity<Void> insertFuncionalidade(@Valid @RequestBody PerfilDTO obj) {
		Perfil pd = new Perfil();
		URI uri = null;
		try {
		pd = service.perfilFuncionalidadefromDTO(obj);
		uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pd.getId()).toUri();
		return ResponseEntity.created(uri).build();
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "perfil/insertFuncionalidade", JWTAuthorizationFilter.getUsername(), "insertFuncionalidade()",
					null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.created(uri).build();
	}

	@PostMapping("/alterarPerfilFuncionalidade")
//	@RequestMapping(value = "/alterarPerfilFuncionalidade", method = RequestMethod.POST)
	public ResponseEntity<Void> alterarPerfilFuncionalidade(@Valid @RequestBody PerfilDTO obj) {
		Perfil pd = new Perfil();
		URI uri = null;
		try {
		pd = service.perfilFuncionalidadefromDTOUpdate(obj);
		 uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pd.getId()).toUri();
		return ResponseEntity.created(uri).build();
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "perfil/insertFuncionalidade", JWTAuthorizationFilter.getUsername(), "insertFuncionalidade()",
					null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.created(uri).build();
	}

//@RequestMapping(value="/{id}", method=RequestMethod.GET)
//public ResponseEntity<?>  find(@PathVariable Integer id) {
//	Pedido obj = service.find(id);
//	return ResponseEntity.ok().body(obj);
//	
//}

}
