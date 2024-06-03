package br.com.diebold.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import br.com.diebold.domain.Perfil;
import br.com.diebold.utils.ObjectMapperUtils;

public class PerfilDTO {

	@Column(name = "id")
	private Integer id;

	@Column(name = "nm_perfil")
	private String nome;

	@Column(name = "funcionalidades")
	private List<FuncionalidadeDTO> funcionalidades = new ArrayList<>();

	public PerfilDTO(Perfil perfil) {
		super();
		this.id = perfil.getId();
		this.nome = perfil.getNome();
		List<FuncionalidadeDTO> funcionalidadeDTO = new ArrayList<FuncionalidadeDTO>(
				(ObjectMapperUtils.mapAll(perfil.getFuncionalidades(), FuncionalidadeDTO.class)));
		this.funcionalidades = funcionalidadeDTO;
	}

	public PerfilDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public List<FuncionalidadeDTO> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(List<FuncionalidadeDTO> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

}
