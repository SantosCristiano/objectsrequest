package br.com.diebold.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diebold.domain.Status;
import br.com.diebold.dto.StatusDTO;
import br.com.diebold.repositories.StatusRepository;

@Service
public class StatusService {

	@Autowired
	private StatusRepository repo;
	
	
	public List<Status>  findAll() {
		List<Status> status = repo.findAll() ;
		return  status;
	}
	

	public Status fromDTO(StatusDTO objDto) {
		Status st = new Status(objDto);
		repo.saveAll(Arrays.asList(st));		
		return st ;
	}
	
	public List<StatusDTO> toDTO(List<Status> status ) {
		List<StatusDTO> sdtoList = new ArrayList<StatusDTO>();
		for (int i = 0; i < status.size(); i++) {
			StatusDTO sdto = new StatusDTO(status.get(i));			
			sdtoList.add(sdto);
		}
		return sdtoList;
	}
	
//	public Pedido insert(Pedido obj) {		
//		repo.saveAll(Arrays.asList(obj));
//		
////		obj.setId(null);
////		obj.setInstante(new Date());
////		obj.setCliente(clienteService.find(obj.getCliente().getId()));
////		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
////		obj.getPagamento().setPedido(obj);
//////		if (obj.getPagamento() instanceof PagamentoComBoleto) {
//////			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
//////			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
//////		}
////		obj = repo.save(obj);
////		pagamentoRepository.save(obj.getPagamento());
//////		for (ItemPedido ip : obj.getItens()) {
//////			ip.setDesconto(0.0);
//////			ip.setProduto(produtoService.find(ip.getProduto().getId()));
//////			ip.setPreco(ip.getProduto().getPreco());
//////			ip.setPedido(obj);
//////		}
////		itemPedidoRepository.saveAll(obj.getItens());
////		emailService.sendOrderConfirmationEmail(obj);
//		return obj;
//	}
	
}
