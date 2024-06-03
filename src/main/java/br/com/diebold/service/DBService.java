package br.com.diebold.service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.diebold.domain.EnderecoAlternativo;
import br.com.diebold.domain.Filial;
import br.com.diebold.domain.Funcionalidade;
import br.com.diebold.domain.Localizacao;
import br.com.diebold.domain.ModalidadeEntrega;
import br.com.diebold.domain.NotaFiscal;
import br.com.diebold.domain.Pedido;
import br.com.diebold.domain.PedidoProdutos;
import br.com.diebold.domain.Perfil;
import br.com.diebold.domain.Produto;
import br.com.diebold.domain.Site;
import br.com.diebold.domain.Status;
import br.com.diebold.domain.StatusPedido;
import br.com.diebold.domain.Tarefa;
import br.com.diebold.domain.Tecnico;
import br.com.diebold.domain.TipoPedido;
import br.com.diebold.domain.Usuario;
import br.com.diebold.domain.enums.PerfilSistema;
import br.com.diebold.repositories.EnderecoAlternativoRepository;
import br.com.diebold.repositories.FilialRepository;
import br.com.diebold.repositories.FuncionalidadeRepository;
import br.com.diebold.repositories.LocalizacaoRepository;
import br.com.diebold.repositories.ModalidadeRepository;
import br.com.diebold.repositories.NotaFiscalRepository;
import br.com.diebold.repositories.PedidoProdutosRepository;
import br.com.diebold.repositories.PedidoRepository;
import br.com.diebold.repositories.PerfilRepository;
import br.com.diebold.repositories.ProdutoRepository;
import br.com.diebold.repositories.SiteRepository;
import br.com.diebold.repositories.StatusPedidoRepository;
import br.com.diebold.repositories.StatusRepository;
import br.com.diebold.repositories.TarefaRepository;
import br.com.diebold.repositories.TecnicoRepository;
import br.com.diebold.repositories.TipoPedidoRepository;
import br.com.diebold.repositories.UsuarioRepository;

@Service
public class DBService  {
	@Autowired
	private EnderecoAlternativoRepository enderecoAlternativoRepository;
	@Autowired
	private	FilialRepository filialRepository;
	@Autowired
	private	FuncionalidadeRepository funcionalidadeRepository;
	@Autowired
	private	LocalizacaoRepository localizacaoRepository;
	@Autowired
	private	ModalidadeRepository modalidadeRepository;
	@Autowired
	private	NotaFiscalRepository notaFiscalRepository;
	@Autowired
	private	PedidoProdutosRepository pedidoProdutosRepository;
	@Autowired
	private	PedidoRepository pedidoRepository;
	@Autowired
	private PerfilRepository perfilRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private SiteRepository siteRepository;
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
	private BCryptPasswordEncoder pe;
	

	
	
	
	public void instantiateTestDataBase() throws ParseException {

		
		Usuario user1 = new Usuario(null, "ribeirf1","Fagner Costa Ribeiro1" , pe.encode("123456"), new Date(), new Date(), new Date(), new Tecnico(), false);
		user1.addPerfilSistema(PerfilSistema.ADMIN);
		Usuario user2 = new Usuario(null, "ribeirf2","Fagner Costa Ribeiro2" , pe.encode("123456"), new Date(), new Date(), new Date(), new Tecnico(), false);
		user2.addPerfilSistema(PerfilSistema.ADMIN);
		Usuario user3 = new Usuario(null, "ribeirf3","Fagner Costa Ribeiro3" , pe.encode("123456"), new Date(), new Date(), new Date(), new Tecnico(), false);
		user3.addPerfilSistema(PerfilSistema.ADMIN);
		
		Perfil perfil1 = new Perfil(null, "perfil1");
		Perfil perfil2 = new Perfil(null, "perfil2");
		Perfil perfil3 = new Perfil(null, "perfil3");
		Perfil perfil4 = new Perfil(null, "perfil4");
		Perfil perfil5 = new Perfil(null, "perfil5");
		Perfil perfil6 = new Perfil(null, "perfil6");
		Perfil perfil7 = new Perfil(null, "perfil7");
		Perfil perfil8 = new Perfil(null, "perfil8");
		Perfil perfil9 = new Perfil(null, "perfil9");
				
		Funcionalidade f1 = new Funcionalidade(null, "CommandButton1", "Botão1", "Login");
		Funcionalidade f2 = new Funcionalidade(null, "CommandButton1", "Botão2", "Login");
		Funcionalidade f3 = new Funcionalidade(null, "CommandButton1", "Botão3", "Login");
		Funcionalidade f4 = new Funcionalidade(null, "CommandButton1", "Botão4", "Login");
		Funcionalidade f5 = new Funcionalidade(null, "CommandButton1", "Botão5", "Login");
		Funcionalidade f6 = new Funcionalidade(null, "CommandButton1", "Botão6", "Login");
		Funcionalidade f7 = new Funcionalidade(null, "CommandButton1", "Botão7", "Login");
		Funcionalidade f8 = new Funcionalidade(null, "CommandButton1", "Botão8", "Login");
		Funcionalidade f9 = new Funcionalidade(null, "CommandButton1", "Botão9", "Login");
		Funcionalidade f10 = new Funcionalidade(null, "CommandButton1", "Botão10", "Login");
		Funcionalidade f11 = new Funcionalidade(null, "CommandButton1", "Botão11", "Login");
		Funcionalidade f12 = new Funcionalidade(null, "CommandButton1", "Botão12", "Login");
		Funcionalidade f13 = new Funcionalidade(null, "CommandButton1", "Botão13", "Login");
		Funcionalidade f14 = new Funcionalidade(null, "CommandButton1", "Botão14", "Login");
		Funcionalidade f15 = new Funcionalidade(null, "CommandButton1", "Botão15", "Login");
		Funcionalidade f16 = new Funcionalidade(null, "CommandButton1", "Botão16", "Login");
		Funcionalidade f17 = new Funcionalidade(null, "CommandButton1", "Botão17", "Login");
		Funcionalidade f18 = new Funcionalidade(null, "CommandButton1", "Botão18", "Login");
		Funcionalidade f19 = new Funcionalidade(null, "CommandButton1", "Botão19", "Login");
		Funcionalidade f20 = new Funcionalidade(null, "CommandButton1", "Botão20", "Login");
		Funcionalidade f21 = new Funcionalidade(null, "CommandButton1", "Botão21", "Login");
		Funcionalidade f22 = new Funcionalidade(null, "CommandButton1", "Botão22", "Login");
		Funcionalidade f23 = new Funcionalidade(null, "CommandButton1", "Botão23", "Login");
		Funcionalidade f24 = new Funcionalidade(null, "CommandButton1", "Botão24", "Login");
		Funcionalidade f25 = new Funcionalidade(null, "CommandButton1", "Botão25", "Login");
		Funcionalidade f26 = new Funcionalidade(null, "CommandButton1", "Botão26", "Login");
		Funcionalidade f27 = new Funcionalidade(null, "CommandButton1", "Botão27", "Login");
		Funcionalidade f28 = new Funcionalidade(null, "CommandButton1", "Botão28", "Login");
		Funcionalidade f29 = new Funcionalidade(null, "CommandButton1", "Botão29", "Login");

		Filial fi1 = new Filial(null, "SÃO PAULO");
		Filial fi2 = new Filial(null, "SÃO CAETANO");
		Filial fi3 = new Filial(null, "SANTOS");
		Filial fi4 = new Filial(null, "BAHIA");
		
		
		Date data = new Date();
		
		EnderecoAlternativo ea = new EnderecoAlternativo(null, "RUA NAO SEI DE QUE", "02242-001", "BARRA FUNDA", "SÃO Paulo", "S/N");
		Localizacao l = new Localizacao(null, "LOCAL");
		ModalidadeEntrega me = new ModalidadeEntrega(null, "MOTOBOY", "OBSERVAÇÃO : MOTO ROUBADA, ENTREGADOR É BANDIDO E ESTÁ ARMADO");
		NotaFiscal nf = new NotaFiscal(null, 1, "NOTAFISCAL", 'A', data, 52555, 1, "NOTAFISCAL", 4, 'A', 'A', data, data,
				data, 2, "NOTAFISCAL", "teste", "teste", "teste", "teste", "teste", "teste", "teste", 
				"teste", "teste", "teste", "teste", "teste", "teste", "teste");
		Pedido p = new Pedido(null);
		PedidoProdutos pp = new PedidoProdutos(null, 50, new Date(), false, false, false, null, null);
		PedidoProdutos pp1 = new PedidoProdutos(null, 10, new Date(), false, false, false, null, null);
		PedidoProdutos pp2 = new PedidoProdutos(null, 5, new Date(), false, false, false, null, null);		
		Produto pro = new Produto(null, 3, "PRODUTO1", "PRODUTO1", "PRODUTO1", "PRODUTO1", "PRODUTO1", "PRODUTO1", false, new Date(), false, null);
		Produto pro1 = new Produto(null, 3, "PRODUTO2", "PRODUTO2", "PRODUTO2", "PRODUTO2", "PRODUTO2", "PRODUTO2", false, new Date(), false, null);
		Produto pro2 = new Produto(null, 3, "PRODUTO3", "PRODUTO3", "PRODUTO3", "PRODUTO3", "PRODUTO3", "PRODUTO3", false, new Date(), false, null);
		Site s = new Site(null, 55.0, 33.0, "SITE", "SITE", "SITE", "SITE", "SITE", "SITE", "SITE", 'A', "SITE", "SITE", 1);
		Status st = new Status(null, "RECEBIDO");
		StatusPedido sp = new StatusPedido(null, data, "FAGNER");
		Tarefa t = new Tarefa();
		t.setId(1553523);
		Tecnico tec = new Tecnico(99999, 1, data, data, data, "FAGNER", "teste", 'A', null, null, "RIBEIRF2", true, data, 'A', 4444, 0, "LOCAL");
		TipoPedido tp = new TipoPedido(null, "Entrega");
		usuarioRepository.saveAll(Arrays.asList(user1,user2,user3));
		perfilRepository.saveAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		enderecoAlternativoRepository.saveAll(Arrays.asList(ea)) ;		
		filialRepository.saveAll(Arrays.asList(fi1,fi2,fi3,fi4));
		funcionalidadeRepository.saveAll(Arrays.asList(f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24,f25,f26,f27,f28,f29));
		localizacaoRepository.saveAll(Arrays.asList(l));
		modalidadeRepository.saveAll(Arrays.asList(me));
		siteRepository.saveAll(Arrays.asList(s));
		tarefaRepository.saveAll(Arrays.asList(t));
		tecnicoRepository.saveAll(Arrays.asList(tec));
		statusRepository.saveAll(Arrays.asList(st));	
		statusPedidoRepository.saveAll(Arrays.asList(sp));
		produtoRepository.saveAll(Arrays.asList(pro,pro1,pro2));
		pedidoProdutosRepository.saveAll(Arrays.asList(pp,pp1,pp2));
		notaFiscalRepository.saveAll(Arrays.asList(nf));
		tipoPedidoRepository.saveAll(Arrays.asList(tp));
		pedidoRepository.saveAll(Arrays.asList(p));
		user1.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7));	
		user2.getPerfis().addAll(Arrays.asList(perfil8,perfil9));	
		user3.getPerfis().addAll(Arrays.asList(perfil4,perfil5,perfil6,perfil7));
		user1.getFiliais().addAll(Arrays.asList(fi1,fi2));
		user2.getFiliais().addAll(Arrays.asList(fi3,fi4));
		user3.getFiliais().addAll(Arrays.asList(fi1,fi4));
		fi1.getUsuarios().addAll(Arrays.asList(user1,user3));
		fi2.getUsuarios().addAll(Arrays.asList(user1));
		fi3.getUsuarios().addAll(Arrays.asList(user2));
		fi4.getUsuarios().addAll(Arrays.asList(user2,user3));
		
		perfil1.getUsuarios().addAll(Arrays.asList(user1));
		perfil2.getUsuarios().addAll(Arrays.asList(user1));
		perfil3.getUsuarios().addAll(Arrays.asList(user1));
		perfil4.getUsuarios().addAll(Arrays.asList(user1,user3));
		perfil5.getUsuarios().addAll(Arrays.asList(user1,user3));
		perfil6.getUsuarios().addAll(Arrays.asList(user1,user3));
		perfil7.getUsuarios().addAll(Arrays.asList(user1,user3));
		perfil8.getUsuarios().addAll(Arrays.asList(user2));
		perfil9.getUsuarios().addAll(Arrays.asList(user2));
		
		perfil1.getFuncionalidades().addAll(Arrays.asList(f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24,f25,f26,f27,f28,f29));
		perfil2.getFuncionalidades().addAll(Arrays.asList(f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24,f25,f26,f27,f28,f29));
		perfil3.getFuncionalidades().addAll(Arrays.asList(f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24,f25,f26,f27,f28,f29));
		perfil4.getFuncionalidades().addAll(Arrays.asList(f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24,f25,f26,f27,f28,f29));
		perfil5.getFuncionalidades().addAll(Arrays.asList(f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24,f25,f26,f27,f28,f29));
		perfil6.getFuncionalidades().addAll(Arrays.asList(f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24,f25,f26,f27,f28,f29));
		perfil7.getFuncionalidades().addAll(Arrays.asList(f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24,f25,f26,f27,f28,f29));
		perfil8.getFuncionalidades().addAll(Arrays.asList(f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24,f25,f26,f27,f28,f29));
		perfil9.getFuncionalidades().addAll(Arrays.asList(f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24,f25,f26,f27,f28,f29));

		
		f1.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f2.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f3.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f4.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f5.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f6.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f7.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f8.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f9.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f10.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f11.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f12.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f13.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f14.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f15.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f16.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f17.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f18.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f19.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f20.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f21.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f22.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f23.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f24.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f25.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f26.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f27.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f28.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		f29.getPerfis().addAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));

		p.setEnderecoAlternativo(ea);
		p.setLocalizacao(l);
		p.setModalidadeEntrega(me);
		p.setTarefa(t);
		p.setTecnico(tec);
		p.setTipoPedido(tp);
//		p.getPedidoProdutos().addAll(Arrays.asList(pp));
//		p.getStatusPedidos().addAll(Arrays.asList(sp));
		ea.getPedidos().addAll(Arrays.asList(p));
	    l.getPedidos().addAll(Arrays.asList(p));
	    me.getPedidos().addAll(Arrays.asList(p));
	    nf.getPedidoProdutos().addAll(Arrays.asList(pp,pp1,pp2));
	    pro.getPedidoProdutos().addAll(Arrays.asList(pp));
	    pro1.getPedidoProdutos().addAll(Arrays.asList(pp1));
	    pro2.getPedidoProdutos().addAll(Arrays.asList(pp2));
	    s.getTarefas().addAll(Arrays.asList(t));
	    s.setFilial(fi1);
	    fi1.getSites().addAll(Arrays.asList(s));
		st.getStatusPedidos().addAll(Arrays.asList(sp));
//		sp.getPedidos().addAll(Arrays.asList(p));
		sp.setStatus(st);
		t.getPedidos().addAll(Arrays.asList(p));
		t.setSite(s);
		tp.getPedidos().addAll(Arrays.asList(p));
		tec.getPedidos().addAll(Arrays.asList(p));
		pp.getPedidos().addAll(Arrays.asList(p));
		pp.getNotaFiscal().addAll(Arrays.asList(nf));
		pp.setProduto(pro);
		pp1.getPedidos().addAll(Arrays.asList(p));
		pp1.getNotaFiscal().addAll(Arrays.asList(nf));
		pp1.setProduto(pro);
		pp2.getPedidos().addAll(Arrays.asList(p));
		pp2.getNotaFiscal().addAll(Arrays.asList(nf));
		pp2.setProduto(pro);
		
		
		usuarioRepository.saveAll(Arrays.asList(user1,user2,user3));
		perfilRepository.saveAll(Arrays.asList(perfil1,perfil2,perfil3,perfil4,perfil5,perfil6,perfil7,perfil8,perfil9));
		enderecoAlternativoRepository.saveAll(Arrays.asList(ea)) ;		
		filialRepository.saveAll(Arrays.asList(fi1,fi2,fi3,fi4));
		funcionalidadeRepository.saveAll(Arrays.asList(f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21,f22,f23,f24,f25,f26,f27,f28,f29));
		localizacaoRepository.saveAll(Arrays.asList(l));
		modalidadeRepository.saveAll(Arrays.asList(me));
		statusRepository.saveAll(Arrays.asList(st));	
		statusPedidoRepository.saveAll(Arrays.asList(sp));
		produtoRepository.saveAll(Arrays.asList(pro,pro1,pro2));
		pedidoProdutosRepository.saveAll(Arrays.asList(pp,pp1,pp2));
		tipoPedidoRepository.saveAll(Arrays.asList(tp));
		pedidoRepository.saveAll(Arrays.asList(p));
	

	}
	
	
	public FilialRepository getFilialRepository() {
		return filialRepository;
	}

	public void setFilialRepository(FilialRepository filialRepository) {
		this.filialRepository = filialRepository;
	}

	
}
