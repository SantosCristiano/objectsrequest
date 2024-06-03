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

import br.com.diebold.domain.EventoParts;
import br.com.diebold.dto.BomDTO;
import br.com.diebold.dto.EquipamentoDTO;
import br.com.diebold.response.Response;
import br.com.diebold.security.JWTAuthorizationFilter;
import br.com.diebold.service.BomService;
import br.com.diebold.service.EventoPartsService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "/bom")
@SecurityRequirement(name = "bearer-key") //Swagger
public class BomResource {

	@Autowired
	private BomService service;
	
	@Autowired
	private EventoPartsService eps;

	@PostMapping("/pesquisaEquipamento")
//	@RequestMapping(value = "/pesquisaEquipamento", method = RequestMethod.POST)
	public ResponseEntity<Response<BomDTO>> find(@Valid @RequestBody EquipamentoDTO obj) {
		Response<BomDTO> response = new Response<BomDTO>();
		try {
			System.out.println(" ***************  ENTROU NO EquipamentoDTO" + obj.getEquipamento());
			obj.getEquipamento();
			List<BomDTO> bdtoList = new ArrayList<BomDTO>();
			bdtoList = service.findAll(obj);
			response.setbDto(bdtoList);

			return ResponseEntity.ok().body(response);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "bom/pesquisaEquipamento", JWTAuthorizationFilter.getUsername(),
					"find()", null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(response);

	}

	@PostMapping("/mobile/ObterEquipamentosBom")
//	@RequestMapping(value = "/mobile/ObterEquipamentosBom", method = RequestMethod.POST)
	public ResponseEntity<?> ObterEquipamentosBom(@Valid @RequestBody EquipamentoDTO obj) {
		System.out.println(" ***************  ENTROU NO EquipamentoDTO " + obj.getEquipamento());
		obj.getEquipamento();
		List<BomDTO> bdtoList = new ArrayList<BomDTO>();
		try {
			bdtoList = service.findAll(obj);
			return ResponseEntity.ok().body(bdtoList);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "bom/mobile/ObterEquipamentosBom", JWTAuthorizationFilter.getUsername(),
					"ObterEquipamentosBom()", null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(bdtoList);
	}

	@PostMapping("/mobile/ObterEquipamentos")
//	@RequestMapping(value = "/mobile/ObterEquipamentos", method = RequestMethod.POST)
	public ResponseEntity<?> ObterEquipamentos() {
		System.out.println(" ***************  ENTROU NO EquipamentoDTO ");
		List<EquipamentoDTO> bdtoList = new ArrayList<EquipamentoDTO>();
		try {
			bdtoList = service.find();
			return ResponseEntity.ok().body(bdtoList);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "bom/mobile/ObterEquipamentos", JWTAuthorizationFilter.getUsername(),
					"ObterEquipamentos()", null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(bdtoList);
	}

}
