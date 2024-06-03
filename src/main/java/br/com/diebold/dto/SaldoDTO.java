package br.com.diebold.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SaldoDTO {

	@JsonProperty("ListaProdutos")
	private List<ProdutosDTO> listaProdutos = new ArrayList<ProdutosDTO>();

	@JsonProperty("CodigoMensagem")
	private String codigoMensagem;

	@JsonProperty("CodFilial")
	private String codFilial;

	@JsonProperty("Mensagem")
	private String mensagem;

	public SaldoDTO() {
		super();
	}

	public SaldoDTO(List<ProdutosDTO> listaProdutos, String codigoMensagem, String codFilial, String mensagem) {
		super();
		this.listaProdutos = listaProdutos;
		this.codigoMensagem = codigoMensagem;
		this.codFilial = codFilial;
		this.mensagem = mensagem;
	}

	public SaldoDTO(List<ProdutosDTO> produtosList, String filial) {
		this.listaProdutos = produtosList;
		this.codFilial = filial;
	}

	public List<ProdutosDTO> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<ProdutosDTO> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public String getCodigoMensagem() {
		return codigoMensagem;
	}

	public void setCodigoMensagem(String codigoMensagem) {
		this.codigoMensagem = codigoMensagem;
	}

	public String getCodFilial() {
		return codFilial;
	}

	public void setCodFilial(String codFilial) {
		this.codFilial = codFilial;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
