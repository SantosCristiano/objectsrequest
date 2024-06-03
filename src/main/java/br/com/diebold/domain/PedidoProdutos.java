package br.com.diebold.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "PR_PEDIDOPRODUTOS")
public class PedidoProdutos implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pedido_produtos_id")
	private Integer id;

	@Column(name="qtd")
	private Integer quantidade;
	
	@Column(name="data_ultima_alteracao")
	private Date dataUltimaAlteracao;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name= "PR_PEDIDOPRODUTOS_PEDIDO", 
	joinColumns= @JoinColumn(name="pedido_produtos_id"),
	inverseJoinColumns = @JoinColumn(name = "pedido_id"))
	private List<Pedido> pedidos = new ArrayList<>();
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto ;

	@JsonManagedReference
	@ManyToMany(mappedBy="pedidoProdutos")
	private List<NotaFiscal> notaFiscal = new ArrayList<>();
	
	@Column(name="verificado_totvs")
	private boolean verificadoTotvs;
	
	@Column(name="tem_saldo_totvs")
	private boolean temSaldoTotvs;
	
	@Column(name="requisitado_totvs")
	private boolean requisitadoTotvs;
	
	@Column(name="mensagem_totvs")
	private String mensagemTotvs;
	
	@Column(name="quantidade_totvs")
	private Integer quantidadeTotvs;

	public PedidoProdutos(Integer id, Integer quantidade, Date dataUltimaAlteracao, boolean verificadoTotvs, 
			boolean temSaldoTotvs, boolean requisitadoTotvs, String mensagemTotvs, Integer quantidadeTotvs) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.dataUltimaAlteracao = dataUltimaAlteracao;
		this.verificadoTotvs = verificadoTotvs;
		this.temSaldoTotvs = temSaldoTotvs;
		this.requisitadoTotvs = requisitadoTotvs;
		this.mensagemTotvs = mensagemTotvs;
		this.quantidadeTotvs = quantidadeTotvs;
	}

	public PedidoProdutos(Integer id, Integer quantidade, Date dataUltimaAlteracao, List<Pedido> pedidos, Produto produto,
			List<NotaFiscal> notaFiscal, boolean verificadoTotvs, boolean temSaldoTotvs, boolean requisitadoTotvs, 
			String mensagemTotvs, Integer quantidadeTotvs) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.dataUltimaAlteracao = dataUltimaAlteracao;
		this.pedidos = pedidos;
		this.produto = produto;
		this.notaFiscal = notaFiscal;
		this.verificadoTotvs = verificadoTotvs;
		this.temSaldoTotvs = temSaldoTotvs;
		this.requisitadoTotvs = requisitadoTotvs;
		this.mensagemTotvs = mensagemTotvs;
		this.quantidadeTotvs = quantidadeTotvs;
	}

	public PedidoProdutos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}
	
	public Date getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<NotaFiscal> getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(List<NotaFiscal> notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public boolean isVerificadoTotvs() {
		return verificadoTotvs;
	}

	public void setVerificadoTotvs(boolean verificadoTotvs) {
		this.verificadoTotvs = verificadoTotvs;
	}

	public boolean isTemSaldoTotvs() {
		return temSaldoTotvs;
	}

	public void setTemSaldoTotvs(boolean temSaldoTotvs) {
		this.temSaldoTotvs = temSaldoTotvs;
	}

	public boolean isRequisitadoTotvs() {
		return requisitadoTotvs;
	}

	public void setRequisitadoTotvs(boolean requisitadoTotvs) {
		this.requisitadoTotvs = requisitadoTotvs;
	}

	public String getMensagemTotvs() {
		return mensagemTotvs;
	}

	public void setMensagemTotvs(String mensagemTotvs) {
		this.mensagemTotvs = mensagemTotvs;
	}

	public Integer getQuantidadeTotvs() {
		return quantidadeTotvs;
	}

	public void setQuantidadeTotvs(Integer quantidadeTotvs) {
		this.quantidadeTotvs = quantidadeTotvs;
	}
}
