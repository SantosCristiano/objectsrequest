package br.com.diebold.domain.enums;

public enum StatusPedidos {
	ABERTO(1, "Aberto"),
	EM_ANALISE(2, "Em Análise"),
	EM_SEPARACAO(3, "Em Separação"),
	EMITINDO_NF(4, "Emitindo NF"),
	AGUARDANDO_PREVISAO(5, "Aguardando Previsão"),
	AGUARDANDO_ENVIO(6, "Aguardando Envio"),
	EM_TRANSPORTE(7, "Em Transporte"),
	FINALIZADO(8, "Finalizado"),
	CANCELADO(9, "Cancelado"),
	AGUARDANDO_RETIRADA(10, "Aguardando Retirada"),
	BUSCANDO(11, "Buscando"),
	DEVOLVENDO(12, "Devolvendo"),
	RECEBIDO_ESTOQUE(13, "Recebido no Estoque");
	
	private StatusPedidos(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	private int cod;
	private String descricao;
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
