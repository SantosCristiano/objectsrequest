package br.com.diebold.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diebold.domain.Filial;
import br.com.diebold.domain.Localizacao;
import br.com.diebold.domain.Status;
import br.com.diebold.domain.TipoPedido;
import br.com.diebold.domain.Transporte;
import br.com.diebold.dto.EquipamentoDTO;
import br.com.diebold.dto.FilialDTO;
import br.com.diebold.dto.FiltrosDTO;
import br.com.diebold.dto.LocalizacaoDTO;
import br.com.diebold.dto.StatusDTO;
import br.com.diebold.dto.TipoPedidoDTO;
import br.com.diebold.dto.TransporteDTO;
import br.com.diebold.repositories.BomRepository;
import br.com.diebold.repositories.FilialRepository;
import br.com.diebold.repositories.LocalizacaoRepository;
import br.com.diebold.repositories.StatusRepository;
import br.com.diebold.repositories.TipoPedidoRepository;
import br.com.diebold.repositories.TransporteRepository;
import br.com.diebold.utils.ObjectMapperUtils;

@Service
public class FiltrosService {

	@Autowired
	private FilialRepository filialRepository;
	@Autowired
	private LocalizacaoRepository localizacaoRepository;
	@Autowired
	private StatusRepository statusRepository;
	@Autowired
	private TipoPedidoRepository tipoPedidoRepository;
	@Autowired
	private BomRepository bomRepository;
	@Autowired
	private TransporteRepository transporteRepository;

	public FiltrosDTO findAllCP() {
		List<Localizacao> local = localizacaoRepository.findAll();
		List<Status> status = statusRepository.findAll();
		List<TipoPedido> tipo = tipoPedidoRepository.findAll();
		List<Filial> filial = filialRepository.findAll();
		List<Transporte> transporte = transporteRepository.findAll();
		Integer idPedido = null;
		Integer idTecnico= null;
		List<String> boms = new ArrayList<String>();
		boms =  bomRepository.findDistinctProductNameNative();
		List<EquipamentoDTO> equipDto = new ArrayList<EquipamentoDTO>();
		for (int i = 0; i < boms.size(); i++) {
			EquipamentoDTO b = new EquipamentoDTO();
			b.setEquipamento(boms.get(i));
			equipDto.add(b);			
		}
		
		FiltrosDTO filtros = new FiltrosDTO(
				ObjectMapperUtils.mapAll(status, StatusDTO.class),
				ObjectMapperUtils.mapAll(local, LocalizacaoDTO.class), 
				ObjectMapperUtils.mapAll(tipo,  TipoPedidoDTO.class),
				ObjectMapperUtils.mapAll(filial,  FilialDTO.class), equipDto, 
				ObjectMapperUtils.mapAll(transporte,  TransporteDTO.class), idPedido, idTecnico);
		
		return filtros;
	}

	
}
