package br.com.diebold.dto;

import java.io.Serializable;

import javax.persistence.Column;

import br.com.diebold.domain.Filial;

@SuppressWarnings("serial")
public class FilialDTO implements Serializable{
	
	@Column(name="filial_id")
	private Integer id;
	
	@Column(name="nm_filial")
	private String nome;
	
	
	public FilialDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FilialDTO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	public FilialDTO(Filial filial) {
		super();
		this.id = filial.getId();
		this.nome = filial.getNome();
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

	
	
	
	

}
