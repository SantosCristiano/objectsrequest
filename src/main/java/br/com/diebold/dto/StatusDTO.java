package br.com.diebold.dto;

import javax.persistence.Column;

import br.com.diebold.domain.Status;

public class StatusDTO {

	@Column(name = "usuario_id")
	private Integer idStatus;

	@Column(name = "status")
	private String status;

	public StatusDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatusDTO(Status status) {
		super();
		this.idStatus = status.getId();
		this.status = status.getStatus();
	}

	public StatusDTO(Integer idStatus, String status) {
		super();
		this.idStatus = idStatus;
		this.status = status;
	}

	public Integer getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(Integer idStatus) {
		this.idStatus = idStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
