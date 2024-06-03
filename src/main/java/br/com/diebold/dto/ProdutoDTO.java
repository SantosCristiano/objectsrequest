package br.com.diebold.dto;

import javax.persistence.Column;

public class ProdutoDTO {

	@Column(name = "produto_id")
	private Integer id;

	@Column(name = "DESTROI_FLAG")
	private Integer destroyFlag;

	@Column(name = "ITEM_CODE")
	private String itemCode;

	@Column(name = "ITEM_DESCRIPTION")
	private String itemDescription;

	@Column(name = "ITEM_FAMILY")
	private String itemFamily;

	@Column(name = "PRODUCT_CODE")
	private String productCode;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "ATTRIBUTE1")
	private String attribute1;

	public ProdutoDTO(Integer id, Integer destroyFlag, String itemCode, String itemDescription, String itemFamily,
			String productCode, String productName, String attribute1, boolean integradoTotvs, String mensagemTotvs) {
		super();
		this.id = id;
		this.destroyFlag = destroyFlag;
		this.itemCode = itemCode;
		this.itemDescription = itemDescription;
		this.itemFamily = itemFamily;
		this.productCode = productCode;
		this.productName = productName;
		this.attribute1 = attribute1;
	}

	public ProdutoDTO() {
		super();
		// TODO Auto-generated constructor stub
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
}
