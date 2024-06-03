package br.com.diebold.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequisitaDTO {

	@JsonProperty("RequisicaoId")
	private Integer requisicaoId;

	@JsonProperty("CodFilial")
	private String codFilial;

	@JsonProperty("CodTecnico")
	private Integer codTecnico;

	@JsonProperty("ListaProdutos")
	private List<ProdutosDTO> listaProdutos = new ArrayList<ProdutosDTO>();

	public RequisitaDTO() {
		super();
	}

	public RequisitaDTO(Integer requisicaoId, String codFilial, Integer codTecnico, List<ProdutosDTO> listaProdutos) {
		super();
		this.requisicaoId = requisicaoId;
		this.codFilial = codFilial;
		this.codTecnico = codTecnico;
		this.listaProdutos = listaProdutos;
	}

	public Integer getRequisicaoId() {
		return requisicaoId;
	}

	public void setRequisicaoId(Integer requisicaoId) {
		this.requisicaoId = requisicaoId;
	}

	public String getCodFilial() {
		return codFilial;
	}

	public void setCodFilial(String codFilial) {
		this.codFilial = codFilial;
	}

	public Integer getCodTecnico() {
		return codTecnico;
	}

	public void setCodTecnico(Integer codTecnico) {
		this.codTecnico = codTecnico;
	}

	public List<ProdutosDTO> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<ProdutosDTO> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

}
