package br.com.diebold.dto;

import javax.persistence.Column;

public class TipoPedidoDTO  {

	
	@Column(name="tipo_pedido")
	private String tipoPedido;

	public TipoPedidoDTO(String tipoPedido) {
		super();
		this.tipoPedido = tipoPedido;
	}

	public TipoPedidoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTipoPedido() {
		return tipoPedido;
	}

	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
	}
	

	
	
}
