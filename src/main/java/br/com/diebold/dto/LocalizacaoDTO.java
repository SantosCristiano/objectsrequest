package br.com.diebold.dto;

import javax.persistence.Column;

public class LocalizacaoDTO {

	@Column(name = "nome_localizacao")
	private String nomeLocalizacao;

	public LocalizacaoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalizacaoDTO(String nomeLocalizacao) {
		super();
		this.nomeLocalizacao = nomeLocalizacao;
	}

	public String getNomeLocalizacao() {
		return nomeLocalizacao;
	}

	public void setNomeLocalizacao(String nomeLocalizacao) {
		this.nomeLocalizacao = nomeLocalizacao;
	}

}
