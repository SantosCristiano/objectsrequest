package br.com.diebold.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequisicaoDTO {

	@JsonProperty("Status")
	private Integer status;

	@JsonProperty("CodigoMensagem")
	private String codigoMensagem;

	@JsonProperty("RequisicaoId")
	private String requisicaoId;

	@JsonProperty("Mensagem")
	private String mensagem;

	public RequisicaoDTO() {
		super();
	}

	public RequisicaoDTO(Integer status, String codigoMensagem, String requisicaoId, String mensagem) {
		super();
		this.status = status;
		this.codigoMensagem = codigoMensagem;
		this.requisicaoId = requisicaoId;
		this.mensagem = mensagem;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCodigoMensagem() {
		return codigoMensagem;
	}

	public void setCodigoMensagem(String codigoMensagem) {
		this.codigoMensagem = codigoMensagem;
	}

	public String getRequisicaoId() {
		return requisicaoId;
	}

	public void setRequisicaoId(String requisicaoId) {
		this.requisicaoId = requisicaoId;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}
