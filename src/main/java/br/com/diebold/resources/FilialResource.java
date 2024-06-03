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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.diebold.domain.EventoParts;
import br.com.diebold.domain.Filial;
import br.com.diebold.dto.FilialDTO;
import br.com.diebold.response.Response;
import br.com.diebold.security.JWTAuthorizationFilter;
import br.com.diebold.service.EventoPartsService;
import br.com.diebold.service.FilialService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "/filiais")
@SecurityRequirement(name = "bearer-key") //Swagger
public class FilialResource {

	@Autowired
	private FilialService service;

	@Autowired
	private EventoPartsService eps;
	
	@GetMapping("/buscar/{id}")
//	@RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Filial obj = new Filial();
		try {

			obj = service.findById(id);
			return ResponseEntity.ok().body(obj);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "filiais/buscar/{id}", JWTAuthorizationFilter.getUsername(),
					"findById()", null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(obj);

	}

	@GetMapping("/todos")
//	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {

		Response<FilialDTO> response = new Response<FilialDTO>();
		try {

			List<FilialDTO> filialDto = service.findAll();
			response.setFilialDTO(filialDto);
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "filiais/todos", JWTAuthorizationFilter.getUsername(), "findAll()",
					null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(response);

	}

	@PostMapping("/nome")
//	@RequestMapping(value = "/nome", method = RequestMethod.POST)
	public ResponseEntity<?> usuario(@Valid @RequestBody String nome) {
		Response<FilialDTO> response = new Response<FilialDTO>();
		try {
			FilialDTO filialDto = service.findByName(nome);
			response.setFilial(filialDto);
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "filiais/nome", JWTAuthorizationFilter.getUsername(), "usuario()",
					null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(response);

	}

	@PostMapping("/insert")
//	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody FilialDTO obj) {
		URI uri = null;
		try {
			Filial filial = new Filial();
			filial = service.fromInsertDTO(obj);
			uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(filial.getId())
					.toUri();
			return ResponseEntity.created(uri).build();

		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "filiais/insert", JWTAuthorizationFilter.getUsername(), "insert()",
					null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.created(uri).build();

	}
	
	@PostMapping("/update")
//	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity<Void> update(@Valid @RequestBody FilialDTO obj) {
		URI uri = null;
		try {
		Filial filial = new Filial();
		filial = service.fromDTO(obj);
		 uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(filial.getId()).toUri();
		return ResponseEntity.created(uri).build();
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "filiais/update", JWTAuthorizationFilter.getUsername(), "update()",
					null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.created(uri).build();
	}

}