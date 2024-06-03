package br.com.diebold.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdutosDTO {

	@JsonProperty("CodProduto")
	private String codProduto;

	@JsonProperty("Quantidade")
	private Integer quantidade;

	public ProdutosDTO() {
		super();
	}

	public ProdutosDTO(String codProduto, Integer quantidade) {
		super();
		this.codProduto = codProduto;
		this.quantidade = quantidade;
	}

	public String getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
