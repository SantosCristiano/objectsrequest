package br.com.diebold.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "PR_EVENTO_PARTS")
@Table(name = "PR_EVENTO_PARTS")
public class EventoParts implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pr_evento_parts")
	private Integer id;

	@Column(name = "dt_servidor")
	private Date dt_servidor;
	@Column(name = "evento")
	private String evento;
	@Column(name = "usuario")
	private String usuario;
	@Column(name = "metodo")
	private String metodo;
	@Column(name = "observacao")
	private String observacao;
	@Column(name = "erro")
	private String erro;

	public EventoParts(Date dt_servidor, String evento, String usuario, String metodo, String observacao, String erro) {
		super();
		this.dt_servidor = dt_servidor;
		this.evento = evento;
		this.usuario = usuario;
		this.metodo = metodo;
		this.observacao = observacao;
		this.erro = erro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDt_servidor() {
		return dt_servidor;
	}

	public void setDt_servidor(Date dt_servidor) {
		this.dt_servidor = dt_servidor;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
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
		EventoParts other = (EventoParts) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
