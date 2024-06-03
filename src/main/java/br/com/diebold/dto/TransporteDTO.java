package br.com.diebold.dto;

import java.io.Serializable;

import br.com.diebold.domain.Transporte;

public class TransporteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;

	public TransporteDTO() {
		super();
	}

	public TransporteDTO(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public TransporteDTO(Transporte transporte) {
		super();
		this.id = transporte.getId();
		this.nome = transporte.getNome();
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
