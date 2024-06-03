package br.com.diebold.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BomDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bom")
	private Integer id;

	@Column(name = "PRODUCT_CODE")
	private String productCode;

	@Column(name = "PRODUCT_NAME")
	private String productName;

	@Column(name = "ITEM_FAMILY")
	private String itemFamily;

	@Column(name = "ITEM_CODE")
	private String itemCode;

	@Column(name = "ITEM_DESCRIPTION")
	private String itemDescription;

	@Column(name = "DESTROI_FLAG")
	private Integer destroyFlag;

	@Column(name = "ATTRIBUTE1")
	private String attribute1;
	
	@Column(name = "ATTRIBUTE2")
	private String attribute2;
	
	@Column(name = "ATTRIBUTE3")
	private String attribute3;
	
	@Column(name = "ATTRIBUTE4")
	private String attribute4;
	
	@Column(name = "ATTRIBUTE5")
	private String attribute5;
	
	@Column(name = "ATTRIBUTE6")
	private String attribute6;
	@Column(name = "ATTRIBUTE7")
	private String attribute7;
	
	@Column(name = "ATTRIBUTE8")
	private String attribute8;
	
	@Column(name = "ATTRIBUTE9")
	private String attribute9;
	
	@Column(name = "ATTRIBUTE10")
	private String attribute10;
	
	@Column(name = "ATTRIBUTE11")
	private String attribute11;
	
	@Column(name = "ATTRIBUTE12")
	private String attribute12;
	
	@Column(name = "ATTRIBUTE13")
	private String attribute13;
	
	@Column(name = "ATTRIBUTE14")
	private String attribute14;
	
	@Column(name = "ATTRIBUTE15")
	private String attribute15;

		
	public BomDTO(Integer id, String productCode, String productName, String itemFamily, String itemCode,
			String itemDescription, Integer destroyFlag, String attribute1, String attribute2, String attribute3,
			String attribute4, String attribute5, String attribute6, String attribute7, String attribute8,
			String attribute9, String attribute10, String attribute11, String attribute12, String attribute13,
			String attribute14, String attribute15) {
		super();
		this.id = id;
		this.productCode = productCode;
		this.productName = productName;
		this.itemFamily = itemFamily;
		this.itemCode = itemCode;
		this.itemDescription = itemDescription;
		this.destroyFlag = destroyFlag;
		this.attribute1 = attribute1;
		this.attribute2 = attribute2;
		this.attribute3 = attribute3;
		this.attribute4 = attribute4;
		this.attribute5 = attribute5;
		this.attribute6 = attribute6;
		this.attribute7 = attribute7;
		this.attribute8 = attribute8;
		this.attribute9 = attribute9;
		this.attribute10 = attribute10;
		this.attribute11 = attribute11;
		this.attribute12 = attribute12;
		this.attribute13 = attribute13;
		this.attribute14 = attribute14;
		this.attribute15 = attribute15;
	}

	public BomDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getItemFamily() {
		return itemFamily;
	}

	public void setItemFamily(String itemFamily) {
		this.itemFamily = itemFamily;
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

	public Integer getDestroyFlag() {
		return destroyFlag;
	}

	public void setDestroyFlag(Integer destroyFlag) {
		this.destroyFlag = destroyFlag;
	}

	public String getAttribute1() {
		return attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getAttribute2() {
		return attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public String getAttribute3() {
		return attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public String getAttribute4() {
		return attribute4;
	}

	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}

	public String getAttribute5() {
		return attribute5;
	}

	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}

	public String getAttribute6() {
		return attribute6;
	}

	public void setAttribute6(String attribute6) {
		this.attribute6 = attribute6;
	}

	public String getAttribute7() {
		return attribute7;
	}

	public void setAttribute7(String attribute7) {
		this.attribute7 = attribute7;
	}

	public String getAttribute8() {
		return attribute8;
	}

	public void setAttribute8(String attribute8) {
		this.attribute8 = attribute8;
	}

	public String getAttribute9() {
		return attribute9;
	}

	public void setAttribute9(String attribute9) {
		this.attribute9 = attribute9;
	}

	public String getAttribute10() {
		return attribute10;
	}

	public void setAttribute10(String attribute10) {
		this.attribute10 = attribute10;
	}

	public String getAttribute11() {
		return attribute11;
	}

	public void setAttribute11(String attribute11) {
		this.attribute11 = attribute11;
	}

	public String getAttribute12() {
		return attribute12;
	}

	public void setAttribute12(String attribute12) {
		this.attribute12 = attribute12;
	}

	public String getAttribute13() {
		return attribute13;
	}

	public void setAttribute13(String attribute13) {
		this.attribute13 = attribute13;
	}

	public String getAttribute14() {
		return attribute14;
	}

	public void setAttribute14(String attribute14) {
		this.attribute14 = attribute14;
	}

	public String getAttribute15() {
		return attribute15;
	}

	public void setAttribute15(String attribute15) {
		this.attribute15 = attribute15;
	}

}
