package br.com.diebold.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import br.com.diebold.dto.FilialDTO;

@Entity(name = "PR_FILIAL")
public class Filial implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="filial_id")
	private Integer id;
	
	@Column(name="nm_filial")
	private String nome;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name= "PR_FILIAL_USUARIO", 
	joinColumns= @JoinColumn(name="filial_id"),
	inverseJoinColumns = @JoinColumn(name = "usuario_id"))
	private List<Usuario> usuarios = new ArrayList<>();
	
	@JsonBackReference
	@OneToMany(mappedBy="filial")
	private List<Site> sites = new ArrayList<>();
	
	
	@JsonBackReference
	@OneToMany(mappedBy="filial")
	private List<Pedido> pedidos = new ArrayList<>();
	
	public Filial(FilialDTO dto) {
		super();
		this.id = dto.getId();
		this.nome = dto.getNome();
	}
	
	public Filial(Integer id, String nome, List<Usuario> usuarios, List<Site> sites, List<Pedido> pedidos) {
		super();
		this.id = id;
		this.nome = nome;
		this.usuarios = usuarios;
		this.sites = sites;
		this.pedidos = pedidos;
	}

	public Filial() {
		super();
	}

	public Filial(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
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
		Filial other = (Filial) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
