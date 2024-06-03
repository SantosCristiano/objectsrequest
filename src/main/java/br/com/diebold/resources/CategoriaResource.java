package br.com.diebold.resources;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.diebold.domain.Categoria;
import br.com.diebold.domain.EventoParts;
import br.com.diebold.security.JWTAuthorizationFilter;
import br.com.diebold.service.CategoriaService;
import br.com.diebold.service.EventoPartsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "/categorias")
@SecurityRequirement(name = "bearer-key") //Swagger
public class CategoriaResource {

	@Autowired
	private CategoriaService service;
	@Autowired
	private EventoPartsService eps;

	@GetMapping("/{id}")
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = null;
		try {
			service.find(id);
			return ResponseEntity.ok().body(obj);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "categorias/id", JWTAuthorizationFilter.getUsername(),
					"find()", null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(obj);

	}

}
