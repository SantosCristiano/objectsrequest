package br.com.diebold.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AtendimentoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_atendimento")
	private Integer id;

	@Column(name = "fg_confirma_cancelamento")
	private Integer fgConfirmaCancelamento;

	@Column(name = "dt_acionamento")
	private Date dtAcionamento;

	@Column(name = "dt_prevista_chegada")
	private Date dtPrevisaoChegada;

	@Column(name = "dt_prevista_conclusao")
	private Date dtPrevistaConclusao;

	@Column(name = "fg_confirma_recebimento")
	private Integer fgConfirmaRecebimento;

	@Column(name = "st_atendimento")
	private char stAtendimento;

	@Column(name = "id_tarefa")
	private Integer idTarefa;
	
	@Column(name = "id_tecnico")
	private Integer idTecnico;
	
	@Column(name = "nr_geo_latitude")
	private Double nrGeoLatitude;
	
	@Column(name = "nr_geo_longitude")
	private Double nrGeoLongitude;

	public AtendimentoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AtendimentoDTO(Integer id, Integer fgConfirmaCancelamento, Date dtAcionamento, Date dtPrevisaoChegada,
			Date dtPrevistaConclusao, Integer fgConfirmaRecebimento, char stAtendimento, Integer idTarefa,
			Integer idTecnico, Double nrGeoLatitude, Double nrGeoLongitude) {
		super();
		this.id = id;
		this.fgConfirmaCancelamento = fgConfirmaCancelamento;
		this.dtAcionamento = dtAcionamento;
		this.dtPrevisaoChegada = dtPrevisaoChegada;
		this.dtPrevistaConclusao = dtPrevistaConclusao;
		this.fgConfirmaRecebimento = fgConfirmaRecebimento;
		this.stAtendimento = stAtendimento;
		this.idTarefa = idTarefa;
		this.idTecnico = idTecnico;
		this.nrGeoLatitude = nrGeoLatitude;
		this.nrGeoLongitude = nrGeoLongitude;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFgConfirmaCancelamento() {
		return fgConfirmaCancelamento;
	}

	public void setFgConfirmaCancelamento(Integer fgConfirmaCancelamento) {
		this.fgConfirmaCancelamento = fgConfirmaCancelamento;
	}

	public Date getDtAcionamento() {
		return dtAcionamento;
	}

	public void setDtAcionamento(Date dtAcionamento) {
		this.dtAcionamento = dtAcionamento;
	}

	public Date getDtPrevisaoChegada() {
		return dtPrevisaoChegada;
	}

	public void setDtPrevisaoChegada(Date dtPrevisaoChegada) {
		this.dtPrevisaoChegada = dtPrevisaoChegada;
	}

	public Date getDtPrevistaConclusao() {
		return dtPrevistaConclusao;
	}

	public void setDtPrevistaConclusao(Date dtPrevistaConclusao) {
		this.dtPrevistaConclusao = dtPrevistaConclusao;
	}

	public Integer getFgConfirmaRecebimento() {
		return fgConfirmaRecebimento;
	}

	public void setFgConfirmaRecebimento(Integer fgConfirmaRecebimento) {
		this.fgConfirmaRecebimento = fgConfirmaRecebimento;
	}

	public char getStAtendimento() {
		return stAtendimento;
	}

	public void setStAtendimento(char stAtendimento) {
		this.stAtendimento = stAtendimento;
	}

	public Integer getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(Integer idTarefa) {
		this.idTarefa = idTarefa;
	}

	public Integer getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(Integer idTecnico) {
		this.idTecnico = idTecnico;
	}

	public Double getNrGeoLatitude() {
		return nrGeoLatitude;
	}

	public void setNrGeoLatitude(Double nrGeoLatitude) {
		this.nrGeoLatitude = nrGeoLatitude;
	}

	public Double getNrGeoLongitude() {
		return nrGeoLongitude;
	}

	public void setNrGeoLongitude(Double nrGeoLongitude) {
		this.nrGeoLongitude = nrGeoLongitude;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AtendimentoDTO other = (AtendimentoDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
		
	
}
