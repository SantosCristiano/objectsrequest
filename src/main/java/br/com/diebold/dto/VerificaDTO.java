package br.com.diebold.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

@SuppressWarnings("serial")
public class VerificaDTO implements Serializable {

	@Column(name = "vTarefa")
	private boolean vTarefa = false;

	@Column(name = "vSite")
	private boolean vSite = false;

	@Column(name = "vTecnico")
	private boolean vTecnico = false;

	@Column(name = "idTecnico")
	private Integer idTecnico;

	// tarefa
	@Column(name = "idTarefa")
	private Integer idTarefa;

	@Column(name = "prodTarefa")
	private String prodTarefa;

	@Column(name = "nSerie")
	private Integer nSerie;

	@Column(name = "dtAbertura")
	private Date dtAbertura;

	@Column(name = "dtAgendamento")
	private Date dtAgendamento;

	@Column(name = "prazoAtendimento")
	private Date prazoAtendimento;

	@Column(name = "prazoSolucao")
	private Date prazoSolucao;

	@Column(name = "ds_equipamento")
	private String descricaoDoEquipamento;

	@Column(name = "nr_serie_equipamento")
	private String numeroDeSerieDoEquipamento;

	@Column(name = "attribute8", nullable = true)
	private String catEquipamento;

	// site
	@Column(name = "idSite")
	private String idSite;

	@Column(name = "nmSite")
	private String nmSite;

	@Column(name = "enderecoSite")
	private String enderecoSite;

	@Column(name = "id_regiao_tecnica")
	private Integer regiaoTecnica;

	@Column(name = "id_cliente")
	private String cliente;

	public VerificaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VerificaDTO(boolean vTarefa, boolean vSite, boolean vTecnico, Integer idTecnico, Integer idTarefa, String prodTarefa,
			Integer nSerie, Date dtAbertura, Date dtAgendamento, Date prazoAtendimento, Date prazoSolucao,
			String descricaoDoEquipamento, String numeroDeSerieDoEquipamento, String catEquipamento, String idSite,
			String nmSite, String enderecoSite, Integer regiaoTecnica, String cliente) {
		super();
		this.vTarefa = vTarefa;
		this.vSite = vSite;
		this.vTecnico = vTecnico;
		this.idTecnico = idTecnico;
		this.idTarefa = idTarefa;
		this.prodTarefa = prodTarefa;
		this.nSerie = nSerie;
		this.dtAbertura = dtAbertura;
		this.dtAgendamento = dtAgendamento;
		this.prazoAtendimento = prazoAtendimento;
		this.prazoSolucao = prazoSolucao;
		this.descricaoDoEquipamento = descricaoDoEquipamento;
		this.numeroDeSerieDoEquipamento = numeroDeSerieDoEquipamento;
		this.catEquipamento = catEquipamento;
		this.idSite = idSite;
		this.nmSite = nmSite;
		this.enderecoSite = enderecoSite;
		this.regiaoTecnica = regiaoTecnica;
		this.cliente = cliente;
	}

	public boolean isvTarefa() {
		return vTarefa;
	}

	public void setvTarefa(boolean vTarefa) {
		this.vTarefa = vTarefa;
	}

	public boolean isvSite() {
		return vSite;
	}

	public void setvSite(boolean vSite) {
		this.vSite = vSite;
	}

	public boolean isvTecnico() {
		return vTecnico;
	}

	public void setvTecnico(boolean vTecnico) {
		this.vTecnico = vTecnico;
	}

	public Integer getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(Integer idTecnico) {
		this.idTecnico = idTecnico;
	}

	public Integer getIdTarefa() {
		return idTarefa;
	}

	public void setIdTarefa(Integer idTarefa) {
		this.idTarefa = idTarefa;
	}

	public String getProdTarefa() {
		return prodTarefa;
	}

	public void setProdTarefa(String prodTarefa) {
		this.prodTarefa = prodTarefa;
	}

	public Integer getnSerie() {
		return nSerie;
	}

	public void setnSerie(Integer nSerie) {
		this.nSerie = nSerie;
	}

	public Date getDtAbertura() {
		return dtAbertura;
	}

	public void setDtAbertura(Date dtAbertura) {
		this.dtAbertura = dtAbertura;
	}

	public Date getDtAgendamento() {
		return dtAgendamento;
	}

	public void setDtAgendamento(Date dtAgendamento) {
		this.dtAgendamento = dtAgendamento;
	}

	public Date getPrazoAtendimento() {
		return prazoAtendimento;
	}

	public void setPrazoAtendimento(Date prazoAtendimento) {
		this.prazoAtendimento = prazoAtendimento;
	}

	public Date getPrazoSolucao() {
		return prazoSolucao;
	}

	public void setPrazoSolucao(Date prazoSolucao) {
		this.prazoSolucao = prazoSolucao;
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

	public String getCatEquipamento() {
		return catEquipamento;
	}

	public void setCatEquipamento(String catEquipamento) {
		this.catEquipamento = catEquipamento;
	}

	public String getIdSite() {
		return idSite;
	}

	public void setIdSite(String idSite) {
		this.idSite = idSite;
	}

	public String getNmSite() {
		return nmSite;
	}

	public void setNmSite(String nmSite) {
		this.nmSite = nmSite;
	}

	public String getEnderecoSite() {
		return enderecoSite;
	}

	public void setEnderecoSite(String enderecoSite) {
		this.enderecoSite = enderecoSite;
	}

	public Integer getRegiaoTecnica() {
		return regiaoTecnica;
	}

	public void setRegiaoTecnica(Integer regiaoTecnica) {
		this.regiaoTecnica = regiaoTecnica;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

}
