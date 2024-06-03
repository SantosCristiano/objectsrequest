package br.com.diebold.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.diebold.dto.StatusDTO;

@Entity(name = "PR_STATUS")
public class Status implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="status_id")
	private Integer id;
	
	@Column(name="status")
	private String status;
	
	@JsonBackReference
	@OneToMany(mappedBy="status")	
	private List<StatusPedido> statusPedidos = new ArrayList<>();

	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Status(StatusDTO stDTO) {
		super();
		this.status = stDTO.getStatus();
	}
	
	public Status(Integer id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<StatusPedido> getStatusPedidos() {
		return statusPedidos;
	}

	public void setStatusPedidos(List<StatusPedido> statusPedidos) {
		this.statusPedidos = statusPedidos;
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
		Status other = (Status) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
}
