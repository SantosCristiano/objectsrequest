package br.com.diebold.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

public class FiltrosDTO {

	// pedidoProdutos lista
	@Column(name = "status")
	private List<StatusDTO> statusDTO = new ArrayList<StatusDTO>();

	// localizacao lista
	@Column(name = "localizacao")
	private List<LocalizacaoDTO> localizacaoDTO = new ArrayList<LocalizacaoDTO>();

	// tipoPedido lista
	@Column(name = "tipoPedido")
	private List<TipoPedidoDTO> tipoPedidoDTO = new ArrayList<TipoPedidoDTO>();

	// filial lista
	@Column(name = "filiais")
	private List<FilialDTO> filialDTO = new ArrayList<FilialDTO>();

	// equipamento lista
	@Column(name = "equipamento")
	private List<EquipamentoDTO> equipamentoDTO = new ArrayList<EquipamentoDTO>();

	// transporte lista
	@Column(name = "transporte")
	private List<TransporteDTO> transporteDTO = new ArrayList<TransporteDTO>();

	@Column(name = "id_pedido")
	private Integer idPedido;

	@Column(name = "id_tecnico")
	private Integer idTecnico;

	public FiltrosDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FiltrosDTO(List<StatusDTO> statusDTO, List<LocalizacaoDTO> localizacaoDTO, List<TipoPedidoDTO> tipoPedidoDTO,
			List<FilialDTO> filialDTO, List<EquipamentoDTO> equipamentoDTO, List<TransporteDTO> transporteDTO,
			Integer idPedido, Integer idTecnico) {
		super();
		this.statusDTO = statusDTO;
		this.localizacaoDTO = localizacaoDTO;
		this.tipoPedidoDTO = tipoPedidoDTO;
		this.filialDTO = filialDTO;
		this.equipamentoDTO = equipamentoDTO;
		this.transporteDTO = transporteDTO;
		this.idPedido = idPedido;
		this.idTecnico = idTecnico;
	}

	public List<StatusDTO> getStatusDTO() {
		return statusDTO;
	}

	public void setStatusDTO(List<StatusDTO> statusDTO) {
		this.statusDTO = statusDTO;
	}

	public List<LocalizacaoDTO> getLocalizacaoDTO() {
		return localizacaoDTO;
	}

	public void setLocalizacaoDTO(List<LocalizacaoDTO> localizacaoDTO) {
		this.localizacaoDTO = localizacaoDTO;
	}

	public List<TipoPedidoDTO> getTipoPedidoDTO() {
		return tipoPedidoDTO;
	}

	public void setTipoPedidoDTO(List<TipoPedidoDTO> tipoPedidoDTO) {
		this.tipoPedidoDTO = tipoPedidoDTO;
	}

	public List<FilialDTO> getFilialDTO() {
		return filialDTO;
	}

	public void setFilialDTO(List<FilialDTO> filialDTO) {
		this.filialDTO = filialDTO;
	}

	public List<EquipamentoDTO> getEquipamentoDTO() {
		return equipamentoDTO;
	}

	public void setEquipamentoDTO(List<EquipamentoDTO> equipamentoDTO) {
		this.equipamentoDTO = equipamentoDTO;
	}

	public List<TransporteDTO> getTransporteDTO() {
		return transporteDTO;
	}

	public void setTransporteDTO(List<TransporteDTO> transporteDTO) {
		this.transporteDTO = transporteDTO;
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Integer getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(Integer idTecnico) {
		this.idTecnico = idTecnico;
	}

}
