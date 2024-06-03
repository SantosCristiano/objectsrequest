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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity(name = "PR_PRODUTO")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="produto_id")
	private Integer id;

	@Column(name="DESTROI_FLAG")
	private Integer destroyFlag;

	@Column(name="ITEM_CODE")
	private String itemCode;
	
	@Column(name="ITEM_DESCRIPTION")
	private String itemDescription;
	
	@Column(name="ITEM_FAMILY")
	private String itemFamily;
	
	@Column(name="PRODUCT_CODE")
	private String productCode;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="ATTRIBUTE1")
	private String attribute1;
	
	@Column(name="ITEM_BOM")
	private boolean itemBom;
	
	@Column(name="DATA_ULTIMA_ALTERACAO")
	private Date dataUltimaAlteracao;
	
	@JsonBackReference
	@OneToMany(mappedBy="produto")	
	private List<PedidoProdutos> pedidoProdutos = new ArrayList<>();
	
	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produto(Integer id, Integer destroyFlag, String itemCode, String itemDescription, String itemFamily,
			String productCode, String productName, String attribute1, boolean itemBom, Date dataUltimaAlteracao, 
			boolean integradoTotvs, String mensagemTotvs) {
		super();
		this.id = id;
		this.destroyFlag = destroyFlag;
		this.itemCode = itemCode;
		this.itemDescription = itemDescription;
		this.itemFamily = itemFamily;
		this.productCode = productCode;
		this.productName = productName;
		this.attribute1 = attribute1;
		this.itemBom = itemBom;
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public Produto(Integer id, Integer destroyFlag, String itemCode, String itemDescription, String itemFamily,
			String productCode, String productName, String attribute1, boolean itemBom, Date dataUltimaAlteracao,
			List<PedidoProdutos> pedidoProdutos) {
		super();
		this.id = id;
		this.destroyFlag = destroyFlag;
		this.itemCode = itemCode;
		this.itemDescription = itemDescription;
		this.itemFamily = itemFamily;
		this.productCode = productCode;
		this.productName = productName;
		this.attribute1 = attribute1;
		this.itemBom = itemBom;
		this.dataUltimaAlteracao = dataUltimaAlteracao;
		this.pedidoProdutos = pedidoProdutos;
	}

	public Produto(Bom bom) {
		super();
		this.destroyFlag = bom.getDestroyFlag();
		this.itemCode = bom.getItemCode();
		this.itemDescription = bom.getItemDescription();
		this.itemFamily = bom.getItemFamily();
		this.productCode = bom.getProductCode();
		this.productName = bom.getProductName();
		this.attribute1 = bom.getAttribute1();
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDestroyFlag() {
		return destroyFlag;
	}

	public void setDestroyFlag(Integer destroyFlag) {
		this.destroyFlag = destroyFlag;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemFamily() {
		return itemFamily;
	}

	public void setItemFamily(String itemFamily) {
		this.itemFamily = itemFamily;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public List<PedidoProdutos> getPedidoProdutos() {
		return pedidoProdutos;
	}

	public void setPedidoProdutos(List<PedidoProdutos> pedidoProdutos) {
		this.pedidoProdutos = pedidoProdutos;
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
}
