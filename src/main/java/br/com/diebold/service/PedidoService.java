package br.com.diebold.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diebold.domain.Bom;
import br.com.diebold.domain.EnderecoAlternativo;
import br.com.diebold.domain.Filial;
import br.com.diebold.domain.Localizacao;
import br.com.diebold.domain.Pedido;
import br.com.diebold.domain.PedidoProdutos;
import br.com.diebold.domain.Produto;
import br.com.diebold.domain.Status;
import br.com.diebold.domain.StatusPedido;
import br.com.diebold.domain.Tarefa;
import br.com.diebold.domain.Tecnico;
import br.com.diebold.domain.TipoPedido;
import br.com.diebold.domain.Transporte;
import br.com.diebold.domain.Usuario;
import br.com.diebold.dto.FiltrosDTO;
import br.com.diebold.dto.PedidoDTO;
import br.com.diebold.dto.PedidoProdutosDTO;
import br.com.diebold.dto.TransporteDTO;
import br.com.diebold.repositories.BomRepository;
import br.com.diebold.repositories.EnderecoAlternativoRepository;
import br.com.diebold.repositories.FilialRepository;
import br.com.diebold.repositories.LocalizacaoRepository;
import br.com.diebold.repositories.PedidoProdutosRepository;
import br.com.diebold.repositories.PedidoRepository;
import br.com.diebold.repositories.ProdutoRepository;
import br.com.diebold.repositories.StatusPedidoRepository;
import br.com.diebold.repositories.StatusRepository;
import br.com.diebold.repositories.TarefaRepository;
import br.com.diebold.repositories.TecnicoRepository;
import br.com.diebold.repositories.TipoPedidoRepository;
import br.com.diebold.repositories.TransporteRepository;
import br.com.diebold.repositories.UsuarioRepository;
import br.com.diebold.service.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	@Autowired
	private EnderecoAlternativoRepository enderecoAlternativoRepository;
	@Autowired
	private FilialRepository filialRepository;
	@Autowired
	private LocalizacaoRepository localizacaoRepository;
	@Autowired
	private PedidoProdutosRepository pedidoProdutosRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private StatusPedidoRepository statusPedidoRepository;
	@Autowired
	private StatusRepository statusRepository;
	@Autowired
	private TarefaRepository tarefaRepository;
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private TipoPedidoRepository tipoPedidoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private BomRepository bomRepository;

	@Autowired
	private TransporteRepository transporteRepository;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

	public List<Pedido> findPorTecnico(Integer idTecnico) {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		try {
			pedidos = repo.findByTecnicoIdTecnicoOrderByIdDesc(idTecnico);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pedidos;
	}

	public List<Pedido> findAll(FiltrosDTO obj) {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		List<Filial> filiais = new ArrayList<Filial>();
		List<Filial> filiaisS = new ArrayList<Filial>();
		List<Localizacao> locais = new ArrayList<Localizacao>();
		List<Localizacao> locaisS = new ArrayList<Localizacao>();
		List<Transporte> transportes = new ArrayList<Transporte>();
		List<Transporte> transportesS = new ArrayList<Transporte>();
		List<Status> status = new ArrayList<Status>();
		List<String> statusS = new ArrayList<String>();
		List<TipoPedido> tipoPedidos = new ArrayList<TipoPedido>();
		List<TipoPedido> tipoPedidosS = new ArrayList<TipoPedido>();

		transportes = transporteRepository.findAll();
		if (!obj.getTransporteDTO().isEmpty()) {
			for (int i = 0; i < obj.getTransporteDTO().size(); i++) {
				for (int j = 0; j < transportes.size(); j++) {
					if (obj.getTransporteDTO().get(i).getNome().equals(transportes.get(j).getNome())) {
						transportesS.add(transportes.get(j));
					}
				}
			}
		} else {
			transportesS = transportes;
		}

		filiais = filialRepository.findAll();
		if (!obj.getFilialDTO().isEmpty()) {
			for (int i = 0; i < obj.getFilialDTO().size(); i++) {
				for (int j = 0; j < filiais.size(); j++) {
					if (obj.getFilialDTO().get(i).getNome().equals(filiais.get(j).getNome())) {
						filiaisS.add(filiais.get(j));
					}
				}
			}
		} else {
			filiaisS = filiais;
		}

		locais = localizacaoRepository.findAll();
		if (!obj.getLocalizacaoDTO().isEmpty()) {
			for (int i = 0; i < obj.getLocalizacaoDTO().size(); i++) {
				for (int j = 0; j < locais.size(); j++) {
					if (obj.getLocalizacaoDTO().get(i).getNomeLocalizacao()
							.equals(locais.get(j).getNomeLocalizacao())) {
						locaisS.add(locais.get(j));
					}
				}
			}
		} else {
			locaisS = locais;
		}

		status = statusRepository.findAll();
		if (!obj.getStatusDTO().isEmpty()) {
			for (int i = 0; i < obj.getStatusDTO().size(); i++) {
				for (int j = 0; j < status.size(); j++) {
					if (obj.getStatusDTO().get(i).getStatus().equals(status.get(j).getStatus())) {
						if(status.get(j).getStatus() != "Cancelado" && status.get(j).getStatus() != "Finalizado") {
							statusS.add(status.get(j).getStatus());
						}
					}
				}
			}
		} else {
			for (int j = 0; j < status.size(); j++) {
				if(status.get(j).getStatus() != "Cancelado" && status.get(j).getStatus() != "Finalizado") {
					statusS.add(status.get(j).getStatus());
				}
			}
		}

		tipoPedidos = tipoPedidoRepository.findAll();
		if (!obj.getTipoPedidoDTO().isEmpty()) {
			for (int i = 0; i < obj.getTipoPedidoDTO().size(); i++) {
				for (int j = 0; j < tipoPedidos.size(); j++) {
					if (obj.getTipoPedidoDTO().get(i).getTipoPedido().equals(tipoPedidos.get(j).getTipoPedido())) {
						tipoPedidosS.add(tipoPedidos.get(j));
					}
				}
			}
		} else {
			tipoPedidosS = tipoPedidos;
		}

		if (obj.getIdPedido() != null) {
			try {
				pedidos = repo
						.findDistinctIdByIdAndFilialInAndStatusInAndLocalizacaoInAndTipoPedidoInAndTransporteInOrderByIdDesc(
								obj.getIdPedido(), filiaisS, statusS, locaisS, tipoPedidosS, transportesS);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return pedidos;
		}

		if (obj.getIdTecnico() != null) {
			Tecnico tecnico = new Tecnico();
			tecnico = tecnicoRepository.findByIdTecnico(obj.getIdTecnico());
			try {
				pedidos = repo
						.findDistinctIdByTecnicoAndFilialInAndStatusInAndLocalizacaoInAndTipoPedidoInAndTransporteInOrderByIdDesc(
								tecnico, filiaisS, statusS, locaisS, tipoPedidosS, transportesS);
			} catch (Exception e) {
				e.printStackTrace();
			}

			return pedidos;
		}

		try {
//			pedidos = repo
//					.findDistinctIdByFilialInAndStatusInAndLocalizacaoInAndTipoPedidoInAndTransporteInOrderByIdDesc(
//							filiaisS, statusS, locaisS, tipoPedidosS, transportesS);
			
			pedidos = repo
					.findDistinctIdByFilialInAndStatusInAndLocalizacaoInAndTipoPedidoInAndTransporteInOrderByIdDesc(
							filiaisS, statusS, locaisS, tipoPedidosS, transportesS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pedidos;
	}

	public List<Pedido> findObterPedidoPorTecnico(Integer tecnico, boolean todos) {
		List<Pedido> pedidos;
		final List<Pedido> pedidosFiltrados = new ArrayList<Pedido>();

		try {
			pedidos = repo.findByTecnicoIdTecnicoOrderByIdDesc(tecnico);

			if (pedidos != null && !todos) {

				for (int i = 0; i < pedidos.size(); i++) {
					if (pedidos.get(i).isSyncMobile()) {
						pedidosFiltrados.add(pedidos.get(i));
					}
				}
			} else {
				pedidosFiltrados.addAll(pedidos);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return pedidosFiltrados;
	}

	public void confirmacaoPedidosRecebidos(Integer tecnico) {
		List<Pedido> pedidos;
		pedidos = repo.findByTecnicoIdTecnicoOrderByIdDesc(tecnico);

		pedidos.forEach(p -> p.setSyncMobile(false));
		repo.saveAll(pedidos);
	}

	public List<Pedido> findObterPedidoPorStatus(String statu, Integer tecnico) {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		List<Status> status = new ArrayList<Status>();
		List<String> statusS = new ArrayList<String>();

		status = statusRepository.findAll();
		if (!statu.isEmpty()) {
			for (int i = 0; i < statu.length(); i++) {
				for (int j = 0; j < status.size(); j++) {
					if (statu.equals(status.get(j).getStatus())) {
						statusS.add(status.get(j).getStatus());
					}
				}
			}
		} else {
			for (int j = 0; j < status.size(); j++) {
				statusS.add(status.get(j).getStatus());
			}
		}

		try {
			pedidos = repo.findByTecnicoIdTecnicoAndStatusOrderByIdDesc(tecnico, statu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pedidos;
	}

	public List<Pedido> findObterPedidoPorTipo(String tipo, Integer tecnico) {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		List<TipoPedido> tipoPedidos = new ArrayList<TipoPedido>();
		List<TipoPedido> tipoPedidosS = new ArrayList<TipoPedido>();

		tipoPedidos = tipoPedidoRepository.findAll();
		if (!tipo.isEmpty()) {
			for (int i = 0; i < tipo.length(); i++) {
				for (int j = 0; j < tipoPedidos.size(); j++) {
					if (tipo.equals(tipoPedidos.get(j).getTipoPedido())) {
						tipoPedidosS.add(tipoPedidos.get(j));
					}
				}
			}
		} else {
			tipoPedidosS = tipoPedidos;
		}

		try {
			pedidos = repo.findByTecnicoIdTecnicoAndTipoPedidoTipoPedidoOrderByIdDesc(tecnico, tipo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pedidos;
	}

	public List<Pedido> findByTecnico(Integer id) {
		List<Pedido> pedidos = repo.findByTecnico(id);
		return pedidos;
	}

	@SuppressWarnings("deprecation")
	public PedidoDTO fromDTO(PedidoDTO objDto, boolean syncMobile, boolean viaMobile) {
		Pedido p = new Pedido();
		Date data = new Date();

		Usuario user = usuarioRepository.findFirstByUsuario(objDto.getStPstatusUsuario());
		StatusPedido sp = new StatusPedido(null, data, user.getNome());

		Status st = new Status();
		st = this.statusRepository.findFirstByStatusOrderByIdAsc(objDto.getStPstatusStatus());

		Transporte transporte = new Transporte(objDto.getTransporte());
		p.setTransporte(transporte);

		p.setStatus(objDto.getStPstatusStatus());
		p.setDtEntrega(objDto.getDtEntrega());
		p.setNomeEntregador(objDto.getNomeEntregador());
		p.setTelefoneEntregador(objDto.getTelefoneEntregador());
		p.setObservacao(objDto.getObservacao());
		p.setBuscaPedido(objDto.isBuscaPedido());
		p.setDataUltimaAlteracao(data);
		p.setDataCriacao(data);
		p.setSyncMobile(syncMobile);
		p.setViaMobile(viaMobile);
		Localizacao l = new Localizacao();
		l = this.localizacaoRepository.findFirstByNomeLocalizacaoOrderByIdAsc(objDto.getNomeLocalizacao());
		TipoPedido tp = new TipoPedido();
		tp = tipoPedidoRepository.findFirstByTipoPedidoOrderByIdAsc(objDto.getTipoPedido());
		Optional<Tarefa> t = null;

		if (objDto.getIdTarefa() != null) {
			t = this.tarefaRepository.findById(objDto.getIdTarefa());
		}

		Tecnico tec = new Tecnico();
		tec = tecnicoRepository.findByIdTecnico(objDto.getIdTecnico());

		List<PedidoProdutos> ppList = new ArrayList<PedidoProdutos>();
		Filial filial = new Filial();
		filial = filialRepository.getOne(tec.getUser().getFiliais().get(0).getId());

		for (int i = 0; i < objDto.getProduto().size(); i++) {
			PedidoProdutos pp = new PedidoProdutos(null, objDto.getProduto().get(i).getProdQtd(), data, false, false,
					false, null, null);
			Bom bom = new Bom();
			if (objDto.getProduto().get(i).isItemBom()) {
				bom = this.bomRepository.findFirstByItemCodeOrderByIdDesc(objDto.getProduto().get(i).getItemCodigo());
			} else {
				bom.setItemCode(objDto.getProduto().get(i).getItemCodigo());
				bom.setItemDescription(objDto.getProduto().get(i).getItemDescription());
			}
			Produto pro = new Produto(bom);
			pro.setItemBom(objDto.getProduto().get(i).isItemBom());
			pro.setDataUltimaAlteracao(data);
			pro = this.produtoRepository.save(pro);
			pp.setProduto(pro);
			pp.setDataUltimaAlteracao(data);
			this.pedidoProdutosRepository.save(pp);
			ppList.add(pp);
		}

		EnderecoAlternativo ea = null;
		if (objDto.getEaLogradouro() != null) {
			ea = new EnderecoAlternativo(null, objDto.getEaLogradouro(), objDto.getEaCep(), objDto.getEaBairro(),
					objDto.getEaCidade(), objDto.getEaNum());
			enderecoAlternativoRepository.saveAll(Arrays.asList(ea));
			p.setEnderecoAlternativo(ea);
		}

		p.setFilial(filial);
		p.setLocalizacao(l);
		if (objDto.getIdTarefa() != null) {
			p.setTarefa(t.get());
		}

		p.setTecnico(tec);
		p.setTipoPedido(tp);
		p.setPedidoProdutos(ppList);
		repo.saveAll(Arrays.asList(p));
		for (int i = 0; i < ppList.size(); i++) {
			ppList.get(i).getPedidos().addAll(Arrays.asList(p));
		}
		l.getPedidos().addAll(Arrays.asList(p));
		st.getStatusPedidos().addAll(Arrays.asList(sp));
		statusRepository.saveAll(Arrays.asList(st));
		sp.setPedidos(p);
		sp.setStatus(st);
		if (objDto.getIdTarefa() != null) {
			t.get().getPedidos().addAll(Arrays.asList(p));
		}

		tp.getPedidos().addAll(Arrays.asList(p));
		tec.getPedidos().addAll(Arrays.asList(p));
		if (ea != null) {
			ea.getPedidos().addAll(Arrays.asList(p));
			enderecoAlternativoRepository.saveAll(Arrays.asList(ea));
		}
		localizacaoRepository.saveAll(Arrays.asList(l));
		statusRepository.saveAll(Arrays.asList(st));
		statusPedidoRepository.saveAll(Arrays.asList(sp));
		pedidoProdutosRepository.saveAll(ppList);
		tipoPedidoRepository.saveAll(Arrays.asList(tp));
		repo.saveAll(Arrays.asList(p));

		objDto.setIdPedido(p.getId());

		return objDto;
	}

	@SuppressWarnings("deprecation")
	public PedidoDTO alterarDTO(PedidoDTO objDto, boolean syncMobile) {

		Pedido p = new Pedido();
		Date data = new Date();

		Usuario user = usuarioRepository.findFirstByUsuario(objDto.getStPstatusUsuario());
		StatusPedido sp = new StatusPedido(null, data, user.getNome());

		Status st = new Status();
		st = this.statusRepository.findFirstByStatusOrderByIdAsc(objDto.getStPstatusStatus());
		p.setStatus(objDto.getStPstatusStatus());
		p.setDtEntrega(objDto.getDtEntrega());
		p.setNomeEntregador(objDto.getNomeEntregador());
		p.setTelefoneEntregador(objDto.getTelefoneEntregador());
		p.setObservacao(objDto.getObservacao());
		p.setBuscaPedido(objDto.isBuscaPedido());
		p.setDataUltimaAlteracao(data);
		p.setSyncMobile(syncMobile);
		Localizacao l = new Localizacao();
		l = this.localizacaoRepository.findFirstByNomeLocalizacaoOrderByIdAsc(objDto.getNomeLocalizacao());
		TipoPedido tp = new TipoPedido();
		tp = tipoPedidoRepository.findFirstByTipoPedidoOrderByIdAsc(objDto.getTipoPedido());
		Optional<Tarefa> t = null;

		if (objDto.getIdTarefa() != null) {
			t = this.tarefaRepository.findById(objDto.getIdTarefa());
		}

		Tecnico tec = new Tecnico();
		tec = tecnicoRepository.findByIdTecnico(objDto.getIdTecnico());

		List<PedidoProdutos> ppList = new ArrayList<PedidoProdutos>();
		Filial filial = new Filial();
		filial = filialRepository.getOne(tec.getUser().getFiliais().get(0).getId());

		for (int i = 0; i < objDto.getProduto().size(); i++) {
			PedidoProdutos pp = new PedidoProdutos(null, objDto.getProduto().get(i).getProdQtd(), data,
					objDto.getProduto().get(i).isVerificadoTotvs(), objDto.getProduto().get(i).isTemSaldoTotvs(),
					objDto.getProduto().get(i).isRequisitadoTotvs(), objDto.getProduto().get(i).getMensagemTotvs(),
					objDto.getProduto().get(i).getQuantidadeTotvs());
			Bom bom = new Bom();
			if (objDto.getProduto().get(i).isItemBom()) {
				bom = this.bomRepository.findFirstByItemCodeOrderByIdDesc(objDto.getProduto().get(i).getItemCodigo());
			} else {
				bom.setItemCode(objDto.getProduto().get(i).getItemCodigo());
				bom.setItemDescription(objDto.getProduto().get(i).getItemDescription());
			}
			Produto pro = new Produto(bom);
			pro.setItemBom(objDto.getProduto().get(i).isItemBom());
			pro.setDataUltimaAlteracao(data);
			pro = this.produtoRepository.save(pro);
			pp.setProduto(pro);
			pp.setDataUltimaAlteracao(data);
			this.pedidoProdutosRepository.save(pp);
			ppList.add(pp);
		}

		EnderecoAlternativo ea = null;
		if (objDto.getEaLogradouro() != null) {
			ea = new EnderecoAlternativo(null, objDto.getEaLogradouro(), objDto.getEaCep(), objDto.getEaBairro(),
					objDto.getEaCidade(), objDto.getEaNum());
			enderecoAlternativoRepository.saveAll(Arrays.asList(ea));
			p.setEnderecoAlternativo(ea);
		}

		p.setFilial(filial);
		p.setLocalizacao(l);
		if (objDto.getIdTarefa() != null) {
			p.setTarefa(t.get());
		}

		p.setTecnico(tec);
		p.setTipoPedido(tp);
		p.setPedidoProdutos(ppList);
		repo.saveAll(Arrays.asList(p));
		for (int i = 0; i < ppList.size(); i++) {
			ppList.get(i).getPedidos().addAll(Arrays.asList(p));
		}
		l.getPedidos().addAll(Arrays.asList(p));
		st.getStatusPedidos().addAll(Arrays.asList(sp));
		statusRepository.saveAll(Arrays.asList(st));
		sp.setPedidos(p);
		sp.setStatus(st);
		if (objDto.getIdTarefa() != null) {
			t.get().getPedidos().addAll(Arrays.asList(p));
		}

		tp.getPedidos().addAll(Arrays.asList(p));
		tec.getPedidos().addAll(Arrays.asList(p));

		if (ea != null) {
			ea.getPedidos().addAll(Arrays.asList(p));
			enderecoAlternativoRepository.saveAll(Arrays.asList(ea));
		}
		localizacaoRepository.saveAll(Arrays.asList(l));
		statusRepository.saveAll(Arrays.asList(st));
		statusPedidoRepository.saveAll(Arrays.asList(sp));
		pedidoProdutosRepository.saveAll(ppList);
		tipoPedidoRepository.saveAll(Arrays.asList(tp));
		repo.saveAll(Arrays.asList(p));

		return objDto;
	}

	@SuppressWarnings("deprecation")
	public PedidoDTO alteraStatus(PedidoDTO objDto, boolean syncMobile) {

		Pedido p = new Pedido();
		Date data = new Date();
		p = repo.getOne(objDto.getIdPedido());
		p.setStatus(objDto.getStPstatusStatus());
		p.setSyncMobile(syncMobile);
		if (objDto.getDtEntrega() != null) {
			p.setDtEntrega(objDto.getDtEntrega());
		}
		if (objDto.getNomeEntregador() != null) {
			p.setNomeEntregador(objDto.getNomeEntregador());
		}
		if (objDto.getTelefoneEntregador() != null) {
			p.setTelefoneEntregador(objDto.getTelefoneEntregador());
		}
		if (objDto.getObservacao() != null) {
			p.setObservacao(objDto.getObservacao());
		}
		p.setBuscaPedido(objDto.isBuscaPedido());
		p.setDataUltimaAlteracao(data);

		repo.save(p);

		try {
			Usuario user = usuarioRepository.findFirstByUsuario(objDto.getStPstatusUsuario());
			StatusPedido sp = new StatusPedido(null, data, user.getNome());

			Status st = this.statusRepository.findFirstByStatusOrderByIdAsc(objDto.getStPstatusStatus());
			st.getStatusPedidos().add(sp);
			statusRepository.save(st);
			sp.setPedidos(p);
			sp.setStatus(st);
			statusPedidoRepository.save(sp);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return objDto;
	}

	public List<PedidoDTO> toDTO(List<Pedido> pedidos) {
		List<PedidoDTO> pdtoList = new ArrayList<PedidoDTO>();
		for (int i = 0; i < pedidos.size(); i++) {
			PedidoDTO pdto = new PedidoDTO();
			try {
				pdto.setIdPedido(pedidos.get(i).getId());
				pdto.setDtEntrega(pedidos.get(i).getDtEntrega());
				pdto.setNomeEntregador(pedidos.get(i).getNomeEntregador());
				pdto.setTelefoneEntregador(pedidos.get(i).getTelefoneEntregador());
				pdto.setObservacao(pedidos.get(i).getObservacao());
				pdto.setBuscaPedido(pedidos.get(i).isBuscaPedido());
				pdto.setDataUltimaAlteracao(pedidos.get(i).getDataUltimaAlteracao());
				pdto.setViaMobile(pedidos.get(i).isViaMobile());

				Transporte transporte = transporteRepository.getById(pedidos.get(i).getTransporte().getId());
				TransporteDTO transporteDTO = new TransporteDTO(transporte);
				pdto.setTransporte(transporteDTO);

//				pdto.setStPstatusData(
//						pedidos.get(i).getStatusPedidos().get(pedidos.get(i).getStatusPedidos().size() - 1).getData());
				
				pdto.setStPstatusData(pedidos.get(i).getDataCriacao());

				pdto.setStPstatusUsuario(pedidos.get(i).getStatusPedidos()
						.get(pedidos.get(i).getStatusPedidos().size() - 1).getUsuario());

				pdto.setStPstatusStatus(pedidos.get(i).getStatus());

				pdto.setNomeLocalizacao(pedidos.get(i).getLocalizacao().getNomeLocalizacao());

				pdto.setTipoPedido(pedidos.get(i).getTipoPedido().getTipoPedido());

				try {
					pdto.setIdTarefa(pedidos.get(i).getTarefa().getId());
					pdto.setDtAbertura(pedidos.get(i).getTarefa().getDataAbertura());
					pdto.setPrazoAtendimento(pedidos.get(i).getTarefa().getDataLimiteAtendimento());
					pdto.setPrazoSolucao(pedidos.get(i).getTarefa().getDataLimiteSolucao());
					pdto.setDescricaoDoEquipamento(pedidos.get(i).getTarefa().getDescricaoDoEquipamento());
					pdto.setNumeroDeSerieDoEquipamento(pedidos.get(i).getTarefa().getNumeroDeSerieDoEquipamento());
					pdto.setCatEquipamento(pedidos.get(i).getTarefa().getAttribute8());
					pdto.setEnderecoSite(pedidos.get(i).getTarefa().getSite().getEndereco() + " - "
							+ pedidos.get(i).getTarefa().getSite().getCep() + " - "
							+ pedidos.get(i).getTarefa().getSite().getBairro() + " - "
							+ pedidos.get(i).getTarefa().getSite().getCidade() + " - "
							+ pedidos.get(i).getTarefa().getSite().getEstado() + " - RT: "
							+ pedidos.get(i).getTarefa().getSite().getRegiaoTecnica());
					pdto.setCliente(pedidos.get(i).getTarefa().getSite().getCliente());
					pdto.setIdSite(pedidos.get(i).getTarefa().getSite().getId());
					pdto.setNmSite(pedidos.get(i).getTarefa().getSite().getSite());

				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					pdto.setNomeFilial(pedidos.get(i).getTecnico().getUser().getFiliais().get(0).getNome());
				} catch (Exception e) {
					System.out.println("Erro ao pegar filial no Técnico, possivelmente sem filial.");
				}

				pdto.setIdTecnico(pedidos.get(i).getTecnico().getIdTecnico());
				pdto.setErpId(pedidos.get(i).getTecnico().getErp());

				pdto.setNmTecnico(pedidos.get(i).getTecnico().getNome());

				for (int j = 0; j < pedidos.get(i).getPedidoProdutos().size(); j++) {
					PedidoProdutosDTO ppDTO = new PedidoProdutosDTO(
							pedidos.get(i).getPedidoProdutos().get(j).getQuantidade(),
							pedidos.get(i).getPedidoProdutos().get(j).getProduto().getProductCode(),
							pedidos.get(i).getPedidoProdutos().get(j).getProduto().getProductName(),
							pedidos.get(i).getPedidoProdutos().get(j).getProduto().getItemCode(),
							pedidos.get(i).getPedidoProdutos().get(j).getProduto().getItemDescription(),
							pedidos.get(i).getPedidoProdutos().get(j).getProduto().isItemBom(),
							pedidos.get(i).getPedidoProdutos().get(j).getProduto().getDataUltimaAlteracao(),
							pedidos.get(i).getPedidoProdutos().get(j).isVerificadoTotvs(),
							pedidos.get(i).getPedidoProdutos().get(j).isTemSaldoTotvs(),
							pedidos.get(i).getPedidoProdutos().get(j).isRequisitadoTotvs(),
							pedidos.get(i).getPedidoProdutos().get(j).getMensagemTotvs(),
							pedidos.get(i).getPedidoProdutos().get(j).getQuantidadeTotvs());
					pdto.getProduto().add(ppDTO);
				}
				if (pedidos.get(i).getEnderecoAlternativo() == null) {
					pdto.setEaLogradouro(pedidos.get(i).getTarefa().getSite().getEndereco());

					pdto.setEaCep(pedidos.get(i).getTarefa().getSite().getCep());

					pdto.setEaBairro(pedidos.get(i).getTarefa().getSite().getBairro());

					pdto.setEaCidade(pedidos.get(i).getTarefa().getSite().getCidade());

				} else {
					pdto.setEaLogradouro(pedidos.get(i).getEnderecoAlternativo().getLogradouro());

					pdto.setEaCep(pedidos.get(i).getEnderecoAlternativo().getCep());

					pdto.setEaBairro(pedidos.get(i).getEnderecoAlternativo().getBairro());

					pdto.setEaCidade(pedidos.get(i).getEnderecoAlternativo().getCidade());

					pdto.setEaNum(pedidos.get(i).getEnderecoAlternativo().getNumero());
				}

			} catch (Exception e) {
				System.out.println("Erro no pedido " + pdto.getIdPedido() + "  -  " + e.getMessage());
				e.printStackTrace();
			}
			pdtoList.add(pdto);
		}
		return pdtoList;
	}

}
