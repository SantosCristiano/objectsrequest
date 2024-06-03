package br.com.diebold.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.diebold.domain.Site;
import br.com.diebold.domain.Tarefa;

public class TarefaDTO {
	@Column(name = "id_tarefa")
	private Integer id;

	@Column(name = "dt_abertura")
	private Date dataAbertura;

	@Column(name = "dt_limite_atendimento")
	private Date dataLimiteAtendimento;

	@Column(name = "dt_limite_solucao")
	private Date dataLimiteSolucao;

	@Column(name = "dt_agendada_atendimento")
	private Date dataAgendadaParaAtendimento;

	@Column(name = "ds_equipamento")
	private String descricaoDoEquipamento;

	@Column(name = "nr_serie_equipamento")
	private String numeroDeSerieDoEquipamento;
	
	@Column(name = "st_tarefa")
	private String statusTarefa;

	@Column(name = "attribute8", nullable = true)
	private String attribute8;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "id_site")
	private Site site;
	
	public TarefaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TarefaDTO(Integer id, Date dataAbertura, Date dataLimiteAtendimento, Date dataLimiteSolucao,
			Date dataAgendadaParaAtendimento, String descricaoDoEquipamento, String numeroDeSerieDoEquipamento, 
			String statusTarefa, String attribute8, Site site) {
		super();
		this.id = id;
		this.dataAbertura = dataAbertura;
		this.dataLimiteAtendimento = dataLimiteAtendimento;
		this.dataLimiteSolucao = dataLimiteSolucao;
		this.dataAgendadaParaAtendimento = dataAgendadaParaAtendimento;
		this.descricaoDoEquipamento = descricaoDoEquipamento;
		this.numeroDeSerieDoEquipamento = numeroDeSerieDoEquipamento;
		this.statusTarefa = statusTarefa;
		this.attribute8 = attribute8;
		this.site = site;
	}

	public TarefaDTO(Tarefa t) {
		super();
		this.id = t.getId();
		this.dataAbertura = t.getDataAbertura();
		this.dataLimiteAtendimento = t.getDataLimiteAtendimento();
		this.dataLimiteSolucao = t.getDataLimiteSolucao();
		this.dataAgendadaParaAtendimento = t.getDataAgendadaParaAtendimento();
		this.descricaoDoEquipamento = t.getDescricaoDoEquipamento();
		this.numeroDeSerieDoEquipamento = t.getNumeroDeSerieDoEquipamento();
		this.statusTarefa = t.getStatusTarefa();
		this.attribute8 = t.getAttribute8();
		this.site = t.getSite();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Date getDataLimiteAtendimento() {
		return dataLimiteAtendimento;
	}

	public void setDataLimiteAtendimento(Date dataLimiteAtendimento) {
		this.dataLimiteAtendimento = dataLimiteAtendimento;
	}

	public Date getDataLimiteSolucao() {
		return dataLimiteSolucao;
	}

	public void setDataLimiteSolucao(Date dataLimiteSolucao) {
		this.dataLimiteSolucao = dataLimiteSolucao;
	}

	public Date getDataAgendadaParaAtendimento() {
		return dataAgendadaParaAtendimento;
	}

	public void setDataAgendadaParaAtendimento(Date dataAgendadaParaAtendimento) {
		this.dataAgendadaParaAtendimento = dataAgendadaParaAtendimento;
	}

	public String getDescricaoDoEquipamento() {
		return descricaoDoEquipamento;
	}

	public void setDescricaoDoEquipamento(String descricaoDoEquipamento) {
		this.descricaoDoEquipamento = descricaoDoEquipamento;
	}

	public String getNumeroDeSerieDoEquipamento() {
		return numeroDeSerieDoEquipamento;
	}

	public void setNumeroDeSerieDoEquipamento(String numeroDeSerieDoEquipamento) {
		this.numeroDeSerieDoEquipamento = numeroDeSerieDoEquipamento;
	}

	public String getStatusTarefa() {
		return statusTarefa;
	}

	public void setStatusTarefa(String statusTarefa) {
		this.statusTarefa = statusTarefa;
	}

	public String getAttribute8() {
		return attribute8;
	}

	public void setAttribute8(String attribute8) {
		this.attribute8 = attribute8;
	}

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

}
