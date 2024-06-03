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

import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
public class NotaFiscal implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "row_id")
	private Integer id;

	@Column(name = "numero_nf")
	private Integer notaFiscal;

	@Column(name = "serie_nf")
	private String serie;

	@Column(name = "status_nf")
	private char status;

	@Column(name = "data_nf")
	private Date dataNota;

	@Column(name = "numero_tec")
	private Integer tecnico;

	@Column(name = "numero_filial")
	private Integer filial;

	@Column(name = "codigo_item")
	private String codigoItem;

	@Column(name = "qtde")
	private Integer quantidade;

	@Column(name = "process_status")
	private char processStatus;

	@Column(name = "update_oracle")
	private char updateOracle;

	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "sent_date")
	private Date sentDate;

	@Column(name = "received_date")
	private Date receivedDate;

	@Column(name = "batch_number")
	private long batchNumber;

	@Column(name = "attribute1")
	private String attribute1;

	@Column(name = "attribute2")
	private String attribute2;
	
	@Column(name = "attribute3")
	private String attribute3;
	
	@Column(name = "attribute4")
	private String attribute4;
	
	@Column(name = "attribute5")
	private String attribute5;
	
	@Column(name = "attribute6")
	private String attribute6;
	
	@Column(name = "attribute7")
	private String attribute7;
	
	@Column(name = "attribute8")
	private String attribute8;
	
	@Column(name = "attribute9")
	private String attribute9;
	
	@Column(name = "attribute10")
	private String attribute10;
	
	@Column(name = "attribute11")
	private String attribute11;
	
	@Column(name = "attribute12")
	private String attribute12;
	
	@Column(name = "attribute13")
	private String attribute13;
	
	@Column(name = "attribute14")
	private String attribute14;
	
	@Column(name = "attribute15")
	private String attribute15;

	@JsonBackReference
	@ManyToMany
	@JoinTable(name= "PR_NOTAFISCAL_PEDIDOPRODUTOS", 
	joinColumns= @JoinColumn(name="row_id"),
	inverseJoinColumns = @JoinColumn(name = "pedido_produtos_id"))
	private List<PedidoProdutos> pedidoProdutos = new ArrayList<>();

	public NotaFiscal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotaFiscal(Integer id, Integer notaFiscal, String serie, char status, Date dataNota, Integer tecnico,
			Integer filial, String codigoItem, Integer quantidade, char processStatus, char updateOracle,
			Date creationDate, Date sentDate, Date receivedDate, long batchNumber, String attribute1, String attribute2,
			String attribute3, String attribute4, String attribute5, String attribute6, String attribute7,
			String attribute8, String attribute9, String attribute10, String attribute11, String attribute12,
			String attribute13, String attribute14, String attribute15) {
		super();
		this.id = id;
		this.notaFiscal = notaFiscal;
		this.serie = serie;
		this.status = status;
		this.dataNota = dataNota;
		this.tecnico = tecnico;
		this.filial = filial;
		this.codigoItem = codigoItem;
		this.quantidade = quantidade;
		this.processStatus = processStatus;
		this.updateOracle = updateOracle;
		this.creationDate = creationDate;
		this.sentDate = sentDate;
		this.receivedDate = receivedDate;
		this.batchNumber = batchNumber;
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



	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getNotaFiscal() {
		return notaFiscal;
	}


	public void setNotaFiscal(Integer notaFiscal) {
		this.notaFiscal = notaFiscal;
	}


	public String getSerie() {
		return serie;
	}


	public void setSerie(String serie) {
		this.serie = serie;
	}


	public char getStatus() {
		return status;
	}


	public void setStatus(char status) {
		this.status = status;
	}


	public Date getDataNota() {
		return dataNota;
	}


	public void setDataNota(Date dataNota) {
		this.dataNota = dataNota;
	}


	public Integer getTecnico() {
		return tecnico;
	}


	public void setTecnico(Integer tecnico) {
		this.tecnico = tecnico;
	}


	public Integer getFilial() {
		return filial;
	}


	public void setFilial(Integer filial) {
		this.filial = filial;
	}


	public String getCodigoItem() {
		return codigoItem;
	}


	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public char getProcessStatus() {
		return processStatus;
	}


	public void setProcessStatus(char processStatus) {
		this.processStatus = processStatus;
	}


	public char getUpdateOracle() {
		return updateOracle;
	}


	public void setUpdateOracle(char updateOracle) {
		this.updateOracle = updateOracle;
	}


	public Date getCreationDate() {
		return creationDate;
	}


	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public Date getSentDate() {
		return sentDate;
	}


	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}


	public Date getReceivedDate() {
		return receivedDate;
	}


	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}


	public long getBatchNumber() {
		return batchNumber;
	}


	public void setBatchNumber(long batchNumber) {
		this.batchNumber = batchNumber;
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


	public List<PedidoProdutos> getPedidoProdutos() {
		return pedidoProdutos;
	}


	public void setPedidoProdutos(List<PedidoProdutos> pedidoProdutos) {
		this.pedidoProdutos = pedidoProdutos;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaFiscal other = (NotaFiscal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
