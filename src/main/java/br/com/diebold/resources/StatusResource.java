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
import br.com.diebold.domain.Status;
import br.com.diebold.dto.StatusDTO;
import br.com.diebold.response.Response;
import br.com.diebold.security.JWTAuthorizationFilter;
import br.com.diebold.service.EventoPartsService;
import br.com.diebold.service.StatusService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "/status")
@SecurityRequirement(name = "bearer-key") //Swagger
public class StatusResource {

	@Autowired
	private StatusService service;
	@Autowired
	private EventoPartsService eps;

	@GetMapping("/todos")
//	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ResponseEntity<Response<Status>> find() {
		Response<Status> response = new Response<Status>();
		try {
			List<Status> pList = new ArrayList<Status>();
			List<StatusDTO> pdtoList = new ArrayList<StatusDTO>();
			pList = service.findAll();
			pdtoList = service.toDTO(pList);
			response.setsDto(pdtoList);
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "status/todos", JWTAuthorizationFilter.getUsername(), "find()", null,
					e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(response);

	}

	@PostMapping("/insert")
//	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody StatusDTO obj) {
		Status pd = new Status();
		URI uri= null;
		try {
		pd = service.fromDTO(obj);
		 uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pd.getId()).toUri();
		return ResponseEntity.created(uri).build();
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "status/insert", JWTAuthorizationFilter.getUsername(), "insert()", null,
					e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.created(uri).build();
	}

//@RequestMapping(value="/update", method=RequestMethod.POST)
//public ResponseEntity<Void> update(@Valid @RequestBody PedidoDTO obj) {
//	Pedido pd = new Pedido();	
//	pd = service.fromDTO(obj);
//	URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
//			.path("/{id}").buildAndExpand(pd.getId()).toUri();
//	return ResponseEntity.created(uri).build();
//}

//@RequestMapping(value="/{id}", method=RequestMethod.GET)
//public ResponseEntity<?>  find(@PathVariable Integer id) {
//	Pedido obj = service.find(id);
//	return ResponseEntity.ok().body(obj);
//	
//}

}
