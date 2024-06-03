package br.com.diebold.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "PR_PEDIDO")
@Table(name = "PR_PEDIDO")
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pedido_id")
	private Integer id;
	
	@Column(name="status")
	private String status;
		
	@JsonBackReference
	@OneToMany(mappedBy="pedidos")
	private List<StatusPedido> statusPedidos;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="localizacao_id")
	private Localizacao localizacao;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="tipo_pedido_id")
	private TipoPedido tipoPedido;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="id_tarefa")
	private Tarefa tarefa;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="id_tecnicos")
	private Tecnico tecnico;
	
	@JsonManagedReference
	@ManyToMany(mappedBy="pedidos")
	private List<PedidoProdutos> pedidoProdutos;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="endereco_alternativo_id")
	private EnderecoAlternativo enderecoAlternativo;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="modalidade_entrega_id")
	private ModalidadeEntrega modalidadeEntrega;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="filial_id")
	private Filial filial;
	
	@Column(name="dtEntrega")
	private Date dtEntrega;
	
	@Column(name="nome_entregador")
	private String nomeEntregador;
	
	@Column(name="telefone_entregador")
	private String telefoneEntregador;
	
	@Column(name="observacao")
	private String observacao;
	
	@Column(name="busca_pedido")
	private boolean buscaPedido;
	
	@Column(name="data_ultima_alteracao")
	private Date dataUltimaAlteracao;
	
	@Column(name="integrado_totvs")
	private boolean integradoTotvs;
	
	@Column(name="mensagem_totvs")
	private String mensagemTotvs;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="transporte")
	private Transporte transporte;
	
	@Column(name="sync_mobile")
	private boolean syncMobile;
	
	@Column(name="data_criacao")
	private Date dataCriacao;
	
	@Column(name = "via_mobile")
	private boolean viaMobile;
	
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Pedido(Integer id) {
		super();
		this.id = id;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<StatusPedido> getStatusPedidos() {
		return statusPedidos;
	}

	public void setStatusPedidos(List<StatusPedido> statusPedidos) {
		this.statusPedidos = statusPedidos;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public List<PedidoProdutos> getPedidoProdutos() {
		return pedidoProdutos;
	}

	public void setPedidoProdutos(List<PedidoProdutos> pedidoProdutos) {
		this.pedidoProdutos = pedidoProdutos;
	}

	public EnderecoAlternativo getEnderecoAlternativo() {
		return enderecoAlternativo;
	}

	public void setEnderecoAlternativo(EnderecoAlternativo enderecoAlternativo) {
		this.enderecoAlternativo = enderecoAlternativo;
	}

	public ModalidadeEntrega getModalidadeEntrega() {
		return modalidadeEntrega;
	}

	public void setModalidadeEntrega(ModalidadeEntrega modalidadeEntrega) {
		this.modalidadeEntrega = modalidadeEntrega;
	}


	public TipoPedido getTipoPedido() {
		return tipoPedido;
	}


	public void setTipoPedido(TipoPedido tipoPedido) {
		this.tipoPedido = tipoPedido;
	}


	public Filial getFilial() {
		return filial;
	}


	public void setFilial(Filial filial) {
		this.filial = filial;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Date getDtEntrega() {
		return dtEntrega;
	}


	public void setDtEntrega(Date dtEntrega) {
		this.dtEntrega = dtEntrega;
	}


	public String getNomeEntregador() {
		return nomeEntregador;
	}


	public void setNomeEntregador(String nomeEntregador) {
		this.nomeEntregador = nomeEntregador;
	}


	public String getTelefoneEntregador() {
		return telefoneEntregador;
	}


	public void setTelefoneEntregador(String telefoneEntregador) {
		this.telefoneEntregador = telefoneEntregador;
	}


	public String getObservacao() {
		return observacao;
	}


	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public boolean isBuscaPedido() {
		return buscaPedido;
	}


	public void setBuscaPedido(boolean buscaPedido) {
		this.buscaPedido = buscaPedido;
	}


	public Date getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}


	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}


	public boolean isIntegradoTotvs() {
		return integradoTotvs;
	}


	public void setIntegradoTotvs(boolean integradoTotvs) {
		this.integradoTotvs = integradoTotvs;
	}


	public String getMensagemTotvs() {
		return mensagemTotvs;
	}


	public void setMensagemTotvs(String mensagemTotvs) {
		this.mensagemTotvs = mensagemTotvs;
	}


	public Transporte getTransporte() {
		return transporte;
	}


	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}


	public boolean isSyncMobile() {
		return syncMobile;
	}


	public void setSyncMobile(boolean syncMobile) {
		this.syncMobile = syncMobile;
	}


	public Date getDataCriacao() {
		return dataCriacao;
	}


	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}


	public boolean isViaMobile() {
		return viaMobile;
	}


	public void setViaMobile(boolean viaMobile) {
		this.viaMobile = viaMobile;
	}
	
}
