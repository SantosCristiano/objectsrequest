package br.com.diebold.dto;

import java.util.Date;

import javax.persistence.Column;

public class PedidoProdutosDTO  {
	
	@Column(name="prodQtd")
	private Integer prodQtd;
	
	@Column(name="prodCodigo")
	private String prodCodigo;
	
	@Column(name="prodName")
	private String prodName;
	
	@Column(name="itemCodigo")
	private String itemCodigo;
	
	@Column(name="itemDescription")
	private String itemDescription;
	
	@Column(name="itemBom")
	private boolean itemBom;
	
	@Column(name="data_ultima_alteracao")
	private Date dataUltimaAlteracao;
	
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
		
	public PedidoProdutosDTO(Integer prodQtd, String prodCodigo, String prodName, String itemCodigo, String itemDescription,
			boolean itemBom, Date dataUltimaAlteracao, boolean verificadoTotvs, boolean temSaldoTotvs, boolean requisitadoTotvs,
			String mensagemTotvs, Integer quantidadeTotvs) {
		super();
		this.prodQtd = prodQtd;
		this.prodCodigo = prodCodigo;
		this.prodName = prodName;
		this.itemCodigo = itemCodigo;
		this.itemDescription = itemDescription;
		this.itemBom = itemBom;
		this.dataUltimaAlteracao = dataUltimaAlteracao;
		this.verificadoTotvs = verificadoTotvs;
		this.temSaldoTotvs = temSaldoTotvs;
		this.requisitadoTotvs = requisitadoTotvs;
		this.mensagemTotvs = mensagemTotvs;
		this.quantidadeTotvs = quantidadeTotvs;
	}
	
	public PedidoProdutosDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getProdQtd() {
		return prodQtd;
	}
	public void setProdQtd(Integer prodQtd) {
		this.prodQtd = prodQtd;
	}
	public String getProdCodigo() {
		return prodCodigo;
	}

	public void setProdCodigo(String prodCodigo) {
		this.prodCodigo = prodCodigo;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getItemCodigo() {
		return itemCodigo;
	}

	public void setItemCodigo(String itemCodigo) {
		this.itemCodigo = itemCodigo;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public boolean isItemBom() {
		return itemBom;
	}

	public void setItemBom(boolean itemBom) {
		this.itemBom = itemBom;
	}

	public Date getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
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