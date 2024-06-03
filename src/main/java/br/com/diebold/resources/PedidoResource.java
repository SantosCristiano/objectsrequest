package br.com.diebold.resources;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.diebold.domain.EventoParts;
import br.com.diebold.domain.Pedido;
import br.com.diebold.dto.FiltrosDTO;
import br.com.diebold.dto.PedidoDTO;
import br.com.diebold.response.Response;
import br.com.diebold.security.JWTAuthorizationFilter;
import br.com.diebold.service.EventoPartsService;
import br.com.diebold.service.PedidoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping(value = "/pedidos")
@SecurityRequirement(name = "bearer-key") //Swagger
@Import(FeignClientsConfiguration.class)
public class PedidoResource {

	@Autowired
	private PedidoService service;
	@Autowired
	private EventoPartsService eps;

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Pedido obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}
	
	@PostMapping("/todos")
//	@Transactional
	public ResponseEntity<Response<PedidoDTO>> find(@Valid @RequestBody FiltrosDTO obj) {
		Response<PedidoDTO> response = new Response<PedidoDTO>();
		try {
			List<Pedido> pList = new ArrayList<Pedido>();
			List<PedidoDTO> pdtoList = new ArrayList<PedidoDTO>();
			pList = service.findAll(obj);
			pdtoList = service.toDTO(pList);
			response.setpDto(pdtoList);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "pedidos/todos", JWTAuthorizationFilter.getUsername(), "find()", null,
					e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(response);
	}

	@PostMapping("/mobile/ObterPedidoPorTecnico")
	public ResponseEntity<List<PedidoDTO>> findObterPedidoPorTecnico(@RequestBody ObjectNode objectNode) {
		List<PedidoDTO> responsePedidos = new ArrayList<PedidoDTO>();
		try {

			String tecnico = objectNode.get("tecnico").asText();
			
			boolean todos = true;
			if(objectNode.get("todos") != null) {
				todos = objectNode.get("todos").asBoolean();
			}
			List<Pedido> pList = new ArrayList<Pedido>();
			List<PedidoDTO> pdtoList = new ArrayList<PedidoDTO>();
			Integer tec = Integer.parseInt(tecnico);
			pList = service.findObterPedidoPorTecnico(tec, todos);
			pdtoList = service.toDTO(pList);
			if (pdtoList != null)
				for (PedidoDTO pedidoDTO : pdtoList) {
					responsePedidos.add(pedidoDTO);
				}
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "pedidos/mobile/ObterPedidoPorTecnico", JWTAuthorizationFilter.getUsername(), "findObterPedidoPorTecnico()", null,
					e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(responsePedidos);
	}
	
	@PostMapping("/mobile/confirmarPedidosRecebidos")
	public void confirmacaoPedidosRecebidos(@RequestBody ObjectNode objectNode) {
		String tecnico = objectNode.get("tecnico").asText();
		Integer tec = Integer.parseInt(tecnico);
		try {
			service.confirmacaoPedidosRecebidos(tec);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "pedidos/mobile/confirmarPedidosRecebidos", JWTAuthorizationFilter.getUsername(), "confirmarPedidosRecebidos()", null,
					e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
	}

	@PostMapping("/mobile/ObterPedidoPorStatus")
	public ResponseEntity<List<PedidoDTO>> findObterPedidoPorStatus(@RequestBody ObjectNode objectNode) {
		List<PedidoDTO> responsePedidos = new ArrayList<PedidoDTO>();
		try {

			String status = objectNode.get("status").asText();
			String tecnico = objectNode.get("tecnico").asText();
			List<Pedido> pList = new ArrayList<Pedido>();
			List<PedidoDTO> pdtoList = new ArrayList<PedidoDTO>();
			Integer tec = Integer.parseInt(tecnico);
			pList = service.findObterPedidoPorStatus(status, tec);
			pdtoList = service.toDTO(pList);

			if (pdtoList != null)
				for (PedidoDTO pedidoDTO : pdtoList) {
					responsePedidos.add(pedidoDTO);
				}
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "pedidos/mobile/ObterPedidoPorStatus", JWTAuthorizationFilter.getUsername(), "findObterPedidoPorStatus()", null,
					e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(responsePedidos);
	}

	@PostMapping("/mobile/ObterPedidoPorTipo")
	public ResponseEntity<List<PedidoDTO>> findObterPedidoPorTipo(@RequestBody ObjectNode objectNode) {
		List<PedidoDTO> responsePedidos = new ArrayList<PedidoDTO>();
		try {
		String tipo = objectNode.get("tipo").asText();
		String tecnico = objectNode.get("tecnico").asText();
		List<Pedido> pList = new ArrayList<Pedido>();
		List<PedidoDTO> pdtoList = new ArrayList<PedidoDTO>();
		Integer tec = Integer.parseInt(tecnico);
		pList = service.findObterPedidoPorTipo(tipo, tec);
		pdtoList = service.toDTO(pList);
		if (pdtoList != null)
			for (PedidoDTO pedidoDTO : pdtoList) {
				responsePedidos.add(pedidoDTO);
			}
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "pedidos/mobile/ObterPedidoPorTipo", JWTAuthorizationFilter.getUsername(), "findObterPedidoPorTipo()", null,
					e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(responsePedidos);
	}

	@PostMapping("/mobile/ObterPedidoPorCodigo")
	public ResponseEntity<List<PedidoDTO>> findObterPedidoPorCodigo(@Valid @RequestBody ObjectNode objectNode) {
		List<PedidoDTO> responsePedidos = new ArrayList<PedidoDTO>();
		try {
		String codigo = objectNode.get("codigo").asText();
		List<Pedido> pList = new ArrayList<Pedido>();
		Pedido p = new Pedido();
		List<PedidoDTO> pdtoList = new ArrayList<PedidoDTO>();
		p = service.find(Integer.parseInt(codigo));
		pList.add(p);
		pdtoList = service.toDTO(pList);
		if (pdtoList != null)
			for (PedidoDTO pedidoDTO : pdtoList) {
				responsePedidos.add(pedidoDTO);
			}
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "pedidos/mobile/ObterPedidoPorCodigo", JWTAuthorizationFilter.getUsername(), "findObterPedidoPorCodigo()", null,
					e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(responsePedidos);
	}

	@SuppressWarnings("static-access")
	@PostMapping("/mobile/IncluirPedido")
	public ResponseEntity<PedidoDTO> IncluirPedido(@Valid @RequestBody PedidoDTO obj) {
		PedidoDTO pDTO = new PedidoDTO();
		//URI uri = null;
		try {
			pDTO = service.fromDTO(obj, false, true);
			return new ResponseEntity<PedidoDTO>(pDTO, HttpStatus.OK);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "pedidos/mobile/IncluirPedido", JWTAuthorizationFilter.getUsername(), "IncluirPedido()", null,
					e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
			return new ResponseEntity<PedidoDTO>(pDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@SuppressWarnings("static-access")
	@PostMapping("/mobile/AlterarPedido")
	public ResponseEntity<PedidoDTO> AlterarPedido(@Valid @RequestBody PedidoDTO obj) {
		PedidoDTO pDTO = new PedidoDTO();
		try {
			pDTO = service.alteraStatus(obj, false);
			return new ResponseEntity<PedidoDTO>(pDTO, HttpStatus.OK);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "pedidos/mobile/AlterarPedido", JWTAuthorizationFilter.getUsername(),
					"find()", null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());

			eps.save(ep);
			e.printStackTrace();
			return new ResponseEntity<PedidoDTO>(pDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@SuppressWarnings("static-access")
	@PostMapping("/mobile/AlterarPedidoStatus")
	public ResponseEntity<PedidoDTO> AlterarPedidoStatus(@Valid @RequestBody PedidoDTO obj) {
		PedidoDTO pDTO = new PedidoDTO();
		try {
			pDTO = service.alteraStatus(obj, false);
			return new ResponseEntity<PedidoDTO>(pDTO, HttpStatus.OK);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "pedidos/mobile/AlterarPedidoStatus", JWTAuthorizationFilter.getUsername(),
					"AlterarPedidoStatus()", null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());

			eps.save(ep);
			e.printStackTrace();
			return new ResponseEntity<PedidoDTO>(pDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/porCodigo")
	public ResponseEntity<Response<Pedido>> porCodigo(@Valid @RequestBody String obj) {
		Response<Pedido> response = new Response<Pedido>();
		try {
			List<Pedido> pList = new ArrayList<Pedido>();
			Pedido p = new Pedido();
			List<PedidoDTO> pdtoList = new ArrayList<PedidoDTO>();
			p = service.find(Integer.parseInt(obj));
			pList.add(p);
			pdtoList = service.toDTO(pList);
			response.setpDto(pdtoList);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "pedidos/porCodigo", JWTAuthorizationFilter.getUsername(),
					"porCodigo()", null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
		}
		return ResponseEntity.ok().body(response);
	}

	@PostMapping("/insert")
	public ResponseEntity<PedidoDTO> insert(@Valid @RequestBody PedidoDTO obj) {
		PedidoDTO pDTO = new PedidoDTO();
		try {
			pDTO = service.fromDTO(obj, true, false);
			return new ResponseEntity<PedidoDTO>(pDTO, HttpStatus.OK);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "pedidos//insert", JWTAuthorizationFilter.getUsername(),
					"porCodigo()", null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
			return new ResponseEntity<PedidoDTO>(pDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/update")
	public ResponseEntity<PedidoDTO> update(@Valid @RequestBody PedidoDTO obj) {
		PedidoDTO pDTO = new PedidoDTO();
		try {
			pDTO = service.alterarDTO(obj, true);
			return new ResponseEntity<PedidoDTO>(pDTO, HttpStatus.OK);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "pedidos/update", JWTAuthorizationFilter.getUsername(),
					"porCodigo()", null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
			return new ResponseEntity<PedidoDTO>(pDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/alteraStatus")
	public ResponseEntity<PedidoDTO> alteraStatus(@Valid @RequestBody PedidoDTO obj) {
		PedidoDTO pDTO = new PedidoDTO();
		try {
			pDTO = service.alteraStatus(obj, true);
			return new ResponseEntity<PedidoDTO>(pDTO, HttpStatus.OK);
		} catch (Exception e) {
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			Date dt = new Date();
			System.out.println("USUARIO É: " + JWTAuthorizationFilter.getUsername());
			EventoParts ep = new EventoParts(dt, "pedidos/alteraStatus", JWTAuthorizationFilter.getUsername(),
					"alteraStatus()", null, e.getMessage() + "   " + e.toString() + "   " + errors.toString());
			eps.save(ep);
			e.printStackTrace();
			return new ResponseEntity<PedidoDTO>(pDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
