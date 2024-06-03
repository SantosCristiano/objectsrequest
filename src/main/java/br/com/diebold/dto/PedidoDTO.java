package br.com.diebold.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

public class PedidoDTO {
	@Column(name = "idPedido")
	private Integer idPedido;

	// statusPedidos
	@Column(name = "stPstatusData")
	private Date stPstatusData;

	@Column(name = "stPstatusUsuario")
	private String stPstatusUsuario;

	@Column(name = "stPstatusStatus")
	private String stPstatusStatus;

	// localizacao
	@Column(name = "nomeLocalizacao")
	private String nomeLocalizacao;

	// tipoPedido
	@Column(name = "tipoPedido")
	private String tipoPedido;
	// tarefa
	@Column(name = "idTarefa")
	private Integer idTarefa;

	@Column(name = "prodTarefa")
	private String prodTarefa;

	@Column(name = "nSerie")
	private Integer nSerie;

	@Column(name = "dtAbertura")
	private Date dtAbertura;

	@Column(name = "dtAgendamento")
	private Date dtAgendamento;

	@Column(name = "prazoAtendimento")
	private Date prazoAtendimento;

	@Column(name = "prazoSolucao")
	private Date prazoSolucao;

	@Column(name = "ds_equipamento")
	private String descricaoDoEquipamento;

	@Column(name = "nr_serie_equipamento")
	private String numeroDeSerieDoEquipamento;

	@Column(name = "attribute8", nullable = true)
	private String catEquipamento;

	// site
	@Column(name = "idSite")
	private String idSite;

	@Column(name = "nmSite")
	private String nmSite;

	@Column(name = "enderecoSite")
	private String enderecoSite;

	@Column(name = "id_regiao_tecnica")
	private Integer regiaoTecnica;

	@Column(name = "nm_filial")
	private String nomeFilial;

	@Column(name = "id_cliente")
	private String cliente;

	// tecnico
	@Column(name = "idTecnico")
	private Integer idTecnico;

	// tecnico erp_id
	@Column(name = "erpId")
	private Integer erpId;

	@Column(name = "nmTecnico")
	private String nmTecnico;

	// pedidoProdutos lista
	@Column(name = "produto")
	private List<PedidoProdutosDTO> produto = new ArrayList<PedidoProdutosDTO>();

	// enderecoAlternativo
	@Column(name = "eaLogradouro")
	private String eaLogradouro;
	@Column(name = "eaCep")
	private String eaCep;
	@Column(name = "eaBairro")
	private String eaBairro;
	@Column(name = "eaCidade")
	private String eaCidade;
	@Column(name = "eaNum")
	private String eaNum;

	@Column(name = "dtEntrega")
	private Date dtEntrega;

	@Column(name = "nome_entregador")
	private String nomeEntregador;

	@Column(name = "telefone_entregador")
	private String telefoneEntregador;

	@Column(name = "observacao")
	private String observacao;

	@Column(name = "busca_pedido")
	private boolean buscaPedido;

	@Column(name = "data_ultima_alteracao")
	private Date dataUltimaAlteracao;

	@Column(name = "integrado_totvs")
	private boolean integradoTotvs;

	@Column(name = "mensagem_totvs")
	private String mensagemTotvs;

	@Column(name = "transporte")
	private TransporteDTO transporte;

	@Column(name = "sync_mobile")
	private boolean syncMobile;
	
	@Column(name = "via_mobile")
	private boolean viaMobile;

	public PedidoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Date getStPstatusData() {
		return stPstatusData;
	}

	public void setStPstatusData(Date stPstatusData) {
		this.stPstatusData = stPstatusData;
	}

	public String getStPstatusUsuario() {
		return stPstatusUsuario;
	}

	public void setStPstatusUsuario(String stPstatusUsuario) {
		this.stPstatusUsuario = stPstatusUsuario;
	}

	public String getStPstatusStatus() {
		return stPstatusStatus;
	}

	public void setStPstatusStatus(String stPstatusStatus) {
		this.stPstatusStatus = stPstatusStatus;
	}

	public String getNomeLocalizacao() {
		return nomeLocalizacao;
	}

	public void setNomeLocalizacao(String nomeLocalizacao) {
		this.nomeLocalizacao = nomeLocalizacao;
	}

	public String getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
	}

	public Integer getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(Integer idTarefa) {
		this.idTarefa = idTarefa;
	}

	public String getProdTarefa() {
		return prodTarefa;
	}

	public void setProdTarefa(String prodTarefa) {
		this.prodTarefa = prodTarefa;
	}

	public Integer getnSerie() {
		return nSerie;
	}

	public void setnSerie(Integer nSerie) {
		this.nSerie = nSerie;
	}

	public Date getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(Date dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public Date getDtAgendamento() {
		return dtAgendamento;
	}

	public void setDtAgendamento(Date dtAgendamento) {
		this.dtAgendamento = dtAgendamento;
	}

	public Date getPrazoAtendimento() {
		return prazoAtendimento;
	}

	public void setPrazoAtendimento(Date prazoAtendimento) {
		this.prazoAtendimento = prazoAtendimento;
	}

	public Date getPrazoSolucao() {
		return prazoSolucao;
	}

	public void setPrazoSolucao(Date prazoSolucao) {
		this.prazoSolucao = prazoSolucao;
	}

	public String getDescricaoDoEquipamento() {
		return descricaoDoEquipamento;
	}

	public void setDescricaoDoEquipamento(String descricaoDoEquipamento) {
		this.descricaoDoEquipamento = descricaoDoEquipamento;
	}

	public String getNumeroDeSerieDoEquipamento() {
		return numeroDeSerieDoEquipamento;
	}

	public void setNumeroDeSerieDoEquipamento(String numeroDeSerieDoEquipamento) {
		this.numeroDeSerieDoEquipamento = numeroDeSerieDoEquipamento;
	}

	public String getCatEquipamento() {
		return catEquipamento;
	}

	public void setCatEquipamento(String catEquipamento) {
		this.catEquipamento = catEquipamento;
	}

	public String getIdSite() {
		return idSite;
	}

	public void setIdSite(String idSite) {
		this.idSite = idSite;
	}

	public String getNmSite() {
		return nmSite;
	}

	public void setNmSite(String nmSite) {
		this.nmSite = nmSite;
	}

	public String getEnderecoSite() {
		return enderecoSite;
	}

	public void setEnderecoSite(String enderecoSite) {
		this.enderecoSite = enderecoSite;
	}

	public Integer getRegiaoTecnica() {
		return regiaoTecnica;
	}

	public void setRegiaoTecnica(Integer regiaoTecnica) {
		this.regiaoTecnica = regiaoTecnica;
	}

	public String getNomeFilial() {
		return nomeFilial;
	}

	public void setNomeFilial(String nomeFilial) {
		this.nomeFilial = nomeFilial;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Integer getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(Integer idTecnico) {
		this.idTecnico = idTecnico;
	}

	public Integer getErpId() {
		return erpId;
	}

	public void setErpId(Integer erpId) {
		this.erpId = erpId;
	}

	public String getNmTecnico() {
		return nmTecnico;
	}

	public void setNmTecnico(String nmTecnico) {
		this.nmTecnico = nmTecnico;
	}

	public List<PedidoProdutosDTO> getProduto() {
		return produto;
	}

	public void setProduto(List<PedidoProdutosDTO> produto) {
		this.produto = produto;
	}

	public String getEaLogradouro() {
		return eaLogradouro;
	}

	public void setEaLogradouro(String eaLogradouro) {
		this.eaLogradouro = eaLogradouro;
	}

	public String getEaCep() {
		return eaCep;
	}

	public void setEaCep(String eaCep) {
		this.eaCep = eaCep;
	}

	public String getEaBairro() {
		return eaBairro;
	}

	public void setEaBairro(String eaBairro) {
		this.eaBairro = eaBairro;
	}

	public String getEaCidade() {
		return eaCidade;
	}

	public void setEaCidade(String eaCidade) {
		this.eaCidade = eaCidade;
	}

	public String getEaNum() {
		return eaNum;
	}

	public void setEaNum(String eaNum) {
		this.eaNum = eaNum;
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

	public TransporteDTO getTransporte() {
		return transporte;
	}

	public void setTransporte(TransporteDTO transporte) {
		this.transporte = transporte;
	}

	public boolean isSyncMobile() {
		return syncMobile;
	}

	public void setSyncMobile(boolean syncMobile) {
		this.syncMobile = syncMobile;
	}

	public boolean isViaMobile() {
		return viaMobile;
	}

	public void setViaMobile(boolean viaMobile) {
		this.viaMobile = viaMobile;
	}
	
}
