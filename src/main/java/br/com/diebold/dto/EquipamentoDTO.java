package br.com.diebold.dto;

import java.io.Serializable;

public class EquipamentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String equipamento;

	public EquipamentoDTO() {
		super();
	}

	public EquipamentoDTO(String equipamento) {
		super();
		this.equipamento = equipamento;
	}

	public String getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(String equipamento) {
		this.equipamento = equipamento;
	}
}
