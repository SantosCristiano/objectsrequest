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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.diebold.domain.EventoParts;
import br.com.diebold.domain.Funcionalidade;
import br.com.diebold.dto.FuncionalidadeDTO;
import br.com.diebold.security.JWTAuthorizationFilter;
import br.com.diebold.service.EventoPartsService;
import br.com.diebold.service.FuncionalidadeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "/funcionalidade")
@SecurityRequirement(name = "bearer-key") //Swagger
public class FuncionalidadeResource {

	@Autowired
	private FuncionalidadeService service;
	
	@Autowired
	private EventoPartsService eps;
	
	@GetMapping("/todos")
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ResponseEntity<?> find() {
		List<Funcionalidade> fList = new ArrayList<Funcionalidade>();
		try {
			fList = service.BuscarTodos();
			return ResponseEntity.ok().body(fList);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "funcionalidade/todos", JWTAuthorizationFilter.getUsername(),
					"find()", null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(fList);
	}

	@PostMapping("/insert")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody FuncionalidadeDTO obj) {
		Funcionalidade f = new Funcionalidade();
		URI uri = null;
		try {
		f = service.save(obj);
		 uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(f.getId()).toUri();
		return ResponseEntity.created(uri).build();
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "funcionalidade/insert", JWTAuthorizationFilter.getUsername(),
					"insert()", null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
	return ResponseEntity.created(uri).build();
	}

}