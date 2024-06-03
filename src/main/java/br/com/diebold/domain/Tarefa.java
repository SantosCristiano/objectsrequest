package br.com.diebold.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Tarefa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
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

	@JsonBackReference
	@OneToMany(mappedBy = "tarefa")
	private List<Pedido> pedidos = new ArrayList<>();

	@JsonBackReference
	@OneToMany(mappedBy = "tarefa")
	private List<Atendimento> atendimento = new ArrayList<>();

	public Tarefa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tarefa(Integer id, Date dataAbertura, Date dataLimiteAtendimento, Date dataLimiteSolucao,
			Date dataAgendadaParaAtendimento, String descricaoDoEquipamento, String numeroDeSerieDoEquipamento, 
			String statusTarefa, String attribute8, Site site, List<Pedido> pedidos) {
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
		this.pedidos = pedidos;
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

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Atendimento> getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(List<Atendimento> atendimento) {
		this.atendimento = atendimento;
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
		Tarefa other = (Tarefa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
