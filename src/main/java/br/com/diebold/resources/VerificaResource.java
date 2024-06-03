package br.com.diebold.resources;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.diebold.domain.EventoParts;
import br.com.diebold.dto.SiteDTO;
import br.com.diebold.dto.TarefaDTO;
import br.com.diebold.dto.TecnicoDTO;
import br.com.diebold.dto.VerificaDTO;
import br.com.diebold.response.Response;
import br.com.diebold.security.JWTAuthorizationFilter;
import br.com.diebold.service.EventoPartsService;
import br.com.diebold.service.VerificaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "/verificacao")
@SecurityRequirement(name = "bearer-key") //Swagger
public class VerificaResource {

	@Autowired
	private VerificaService service;
	@Autowired
	private EventoPartsService eps;

	@PostMapping("/mobile/ObterTarefasPeloTecnico")
//	@RequestMapping(value = "/mobile/ObterTarefasPeloTecnico", method = RequestMethod.POST)
	public ResponseEntity<List<TarefaDTO>> ObterTarefasPeloTecnico(@Valid @RequestBody VerificaDTO obj) {
		List<TarefaDTO> tarefa = new ArrayList<>();
		try {
			tarefa = service.verificaTarefasPeloTecnico(obj.getIdTecnico());
			return ResponseEntity.ok().body(tarefa);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "verificacao/mobile/ObterTarefasPeloTecnico",
					JWTAuthorizationFilter.getUsername(), "ObterTarefasPeloTecnico()", null,
					e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(tarefa);
	}

	@PostMapping("/mobile/ObterDadosPedidoPelaTask")
//	@RequestMapping(value = "/mobile/ObterDadosPedidoPelaTask", method = RequestMethod.POST)
	public ResponseEntity<VerificaDTO> ObterDadosPedidoPelaTask(@Valid @RequestBody VerificaDTO obj) {
		VerificaDTO verificaDTO = new VerificaDTO();
		try {
			verificaDTO = service.verificaTarefa(obj.getIdTarefa());
			return ResponseEntity.ok().body(verificaDTO);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "verificacao/mobile/ObterDadosPedidoPelaTask",
					JWTAuthorizationFilter.getUsername(), "ObterDadosPedidoPelaTask()", null,
					e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(verificaDTO);
	}

	@PostMapping("/mobile/ObterDadosPedidoPeloSite")
//	@RequestMapping(value = "/mobile/ObterDadosPedidoPeloSite", method = RequestMethod.POST)
	public ResponseEntity<SiteDTO> ObterDadosPedidoPeloSite(@RequestBody ObjectNode objectNode) {
		SiteDTO siteDTO = new SiteDTO();
		try {
			String site = objectNode.get("idSite").asText();
			siteDTO = service.verificaSite(site);
			return ResponseEntity.ok().body(siteDTO);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "verificacao/mobile/ObterDadosPedidoPeloSite",
					JWTAuthorizationFilter.getUsername(), "ObterDadosPedidoPeloSite()", null,
					e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(siteDTO);
	}

	@PostMapping("/mobile/ObterDadosPedidoPeloTecnico")
//	@RequestMapping(value = "/mobile/ObterDadosPedidoPeloTecnico", method = RequestMethod.POST)
	public ResponseEntity<TecnicoDTO> ObterDadosPedidoPeloTecnico(@Valid @RequestBody VerificaDTO obj) {
		// Integer idTecnico = Integer.parseInt(obj.getIdTecnico());
		TecnicoDTO tecnicoDTO = new TecnicoDTO();
		try {
			tecnicoDTO = service.verificaTecnico(obj.getIdTecnico());
			return ResponseEntity.ok().body(tecnicoDTO);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "verificacao/mobile/ObterDadosPedidoPeloTecnico",
					JWTAuthorizationFilter.getUsername(), "ObterDadosPedidoPeloTecnico()", null,
					e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(tecnicoDTO);

	}

	@PostMapping("/verificaTarefa")
//	@RequestMapping(value = "/verificaTarefa", method = RequestMethod.POST)
	public ResponseEntity<Response<VerificaDTO>> verificaTarefa(@Valid @RequestBody VerificaDTO obj) {
		Response<VerificaDTO> response = new Response<VerificaDTO>();
		VerificaDTO verificaDTO = new VerificaDTO();
		try {
			verificaDTO = service.verificaTarefa(obj.getIdTarefa());
			response.setVerificaDTO(verificaDTO);
			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "verificacao/verificaTarefa",
					JWTAuthorizationFilter.getUsername(), "verificaTarefa()", null,
					e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(response);
	}

	@PostMapping("/verificaSite")
//	@RequestMapping(value = "/verificaSite", method = RequestMethod.POST)
	public ResponseEntity<SiteDTO> verificaSite(@Valid @RequestBody VerificaDTO obj) {
		SiteDTO siteDTO = new SiteDTO();
		try {
		siteDTO = service.verificaSite(obj.getIdSite());
		return ResponseEntity.ok().body(siteDTO);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "verificacao/verificaTarefa",
					JWTAuthorizationFilter.getUsername(), "verificaTarefa()", null,
					e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(siteDTO);
	}

	@PostMapping("/verificaTecnico")
//	@RequestMapping(value = "/verificaTecnico", method = RequestMethod.POST)
	public ResponseEntity<TecnicoDTO> verificaTecnico(@Valid @RequestBody VerificaDTO obj) {
		TecnicoDTO tecnicoDTO = new TecnicoDTO();
		try {
			
		tecnicoDTO = service.verificaTecnico(obj.getIdTecnico());
		
		return ResponseEntity.ok().body(tecnicoDTO);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			EventoParts ep = new EventoParts(dt, "verificacao/verificaTarefa",
					JWTAuthorizationFilter.getUsername(), "verificaTarefa()", null,
					e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(tecnicoDTO);
	}

}
