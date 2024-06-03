package br.com.diebold.dto;

import javax.persistence.Column;

import br.com.diebold.domain.Funcionalidade;

public class FuncionalidadeDTO {

	@Column(name = "funcionalidade_id")
	private Integer id;
	@Column(name = "funcionalidade")
	private String funcionalidade;
	@Column(name = "nm_funcionalidade")
	private String nmFuncionalidade;
	@Column(name = "pagina")
	private String pagina;

	public FuncionalidadeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FuncionalidadeDTO(Funcionalidade funcionalidade) {
		this.id = funcionalidade.getId();
		this.funcionalidade = funcionalidade.getFuncionalidade();
		this.nmFuncionalidade = funcionalidade.getNmFuncionalidade();
		this.pagina = funcionalidade.getPagina();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFuncionalidade() {
		return funcionalidade;
	}

	public void setFuncionalidade(String funcionalidade) {
		this.funcionalidade = funcionalidade;
	}

	public String getNmFuncionalidade() {
		return nmFuncionalidade;
	}

	public void setNmFuncionalidade(String nmFuncionalidade) {
		this.nmFuncionalidade = nmFuncionalidade;
	}

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

}
