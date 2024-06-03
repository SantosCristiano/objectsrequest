package br.com.diebold.resources;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.diebold.domain.EventoParts;
import br.com.diebold.dto.FiltrosDTO;
import br.com.diebold.response.Response;
import br.com.diebold.security.JWTAuthorizationFilter;
import br.com.diebold.service.EventoPartsService;
import br.com.diebold.service.FiltrosService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "/filtros")
@SecurityRequirement(name = "bearer-key") //Swagger
public class FiltrosResource {

	@Autowired
	private FiltrosService service;

	@Autowired
	private EventoPartsService eps;

//@RequestMapping(value="/{id}", method=RequestMethod.GET)
//public ResponseEntity<?>  find(@PathVariable Integer id) {
//	Pedido obj = service.find(id);
//	return ResponseEntity.ok().body(obj);
//	
//}

	@GetMapping("/criacaoPedidos")
	@RequestMapping(value = "/criacaoPedidos", method = RequestMethod.GET)
	public ResponseEntity<Response<FiltrosDTO>> findCP() {
		Response<FiltrosDTO> response = new Response<FiltrosDTO>();
		try {
			FiltrosDTO filtroCP = new FiltrosDTO();
			filtroCP = service.findAllCP();
			response.setFiltroCP(filtroCP);
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "filtros/criacaoPedidos", JWTAuthorizationFilter.getUsername(),
					"findCP()", null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(response);
	}

}
