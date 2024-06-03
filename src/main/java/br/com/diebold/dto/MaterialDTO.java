package br.com.diebold.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDTO {

	@JsonProperty("Status")
	private Integer status;

	@JsonProperty("CodigoMensagem")
	private String codigoMensagem;

	@JsonProperty("RequisicaoId")
	private Integer requisicaoId;

	@JsonProperty("Mensagem")
	private String mensagem;
}
