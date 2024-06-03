package br.com.diebold.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "PR_STATUSPEDIDO")
public class StatusPedido implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="status_pedido_id")
	private Integer id;

	@Column(name="data")
	private Date data;
	
	@Column(name="usuario")
	private String usuario;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="status_id")
	private Status status;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="pedido_id")
	private Pedido pedidos;

	
	
	public StatusPedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatusPedido(Integer id, Date data, String usuario) {
		super();
		this.id = id;
		this.data = data;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Pedido getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedido pedidos) {
		this.pedidos = pedidos;
	}

	
	
	
}
