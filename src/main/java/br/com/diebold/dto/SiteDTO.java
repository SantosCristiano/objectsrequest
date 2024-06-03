package br.com.diebold.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SiteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_site")
	private String id;

	@Column(name = "nr_geo_latitude")
	private Double latitude;

	@Column(name = "nr_geo_longitude")
	private Double longitude;

	@Column(name = "nm_bairro")
	private String bairro;

	@Column(name = "nr_cep")
	private String cep;

	@Column(name = "nm_cidade")
	private String cidade;

	@Column(name = "nm_endereco")
	private String endereco;

	@Column(name = "sg_estado")
	private String estado;

	@Column(name = "nm_pais")
	private String pais;

	@Column(name = "nm_site")
	private String site;

	@Column(name = "st_site")
	private char status;

	@Column(name = "nr_telefone")
	private String telefone;

	@Column(name = "id_cliente")
	private String cliente;

	@Column(name = "id_regiao_tecnica")
	private Integer regiaoTecnica;

//	@JsonBackReference
//	@OneToMany(mappedBy="site")	
//	private List<Tarefa> tarefas = new ArrayList<>();
//	
//	@JsonManagedReference
//	@ManyToOne
//	@JoinColumn(name="id_filial")
//	private Filial filial;

	public SiteDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SiteDTO(String id, Double latitude, Double longitude, String bairro, String cep, String cidade,
			String endereco, String estado, String pais, String site, char status, String telefone, String cliente,
			Integer regiaoTecnica) {
		super();
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.endereco = endereco;
		this.estado = estado;
		this.pais = pais;
		this.site = site;
		this.status = status;
		this.telefone = telefone;
		this.cliente = cliente;
		this.regiaoTecnica = regiaoTecnica;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Integer getRegiaoTecnica() {
		return regiaoTecnica;
	}

	public void setRegiaoTecnica(Integer regiaoTecnica) {
		this.regiaoTecnica = regiaoTecnica;
	}

//	public Filial getFilial() {
//		return filial;
//	}
//
//	public void setFilial(Filial filial) {
//		this.filial = filial;
//	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

//	public List<Tarefa> getTarefas() {
//		return tarefas;
//	}
//
//	public void setTarefas(List<Tarefa> tarefas) {
//		this.tarefas = tarefas;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

}
