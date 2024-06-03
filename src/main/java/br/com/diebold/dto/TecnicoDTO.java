package br.com.diebold.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import br.com.diebold.domain.Tecnico;

@Entity
public class TecnicoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_tecnico")
	private Integer idTecnico;

	@Column(name="cd_categoria")
	private Integer categoria;
	
	@Column(name="dt_ultimo_login")
	private Date ultimoLogin;
	
	@Column(name="dt_fim_vigencia")
	private Date fimVigencia;
	
	@Column(name="dt_inicio_vigencia")
	private Date inicioVigencia;

	@Column(name="nm_tecnico")
	private String nome;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="st_login")
	private char status;

	@Column(name="nr_geo_latitude")
	private Double latitude;
	
	@Column(name="nr_geo_longitude")
	private Double longitude;
	
	@Column(name="nm_usuario")
	private String usuario;
	
	@Column(name="fg_possui_mobile")
	private boolean mobile;
	
	@Column(name="dt_geolocalizacao")
	private Date geolocalizacao;
	
	@Column(name="sg_tipo_geolocalizacao")
	private char tipoGeolocalizacao;

	@Column(name="oracle_id")
	private Integer oracle;
	
	@Column(name="erp_id")
	private Integer erp;
	
	@Column(name="localResidente")
	private String localResidente;
	
//	@JsonBackReference
//	@OneToOne	
//	private Usuario user = new Usuario();

	public TecnicoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TecnicoDTO(Tecnico tecnico) { 
		super();
		this.idTecnico = tecnico.getIdTecnico();
		this.categoria = tecnico.getCategoria();
		this.ultimoLogin = tecnico.getUltimoLogin();
		this.fimVigencia = tecnico.getFimVigencia();
		this.inicioVigencia = tecnico.getInicioVigencia();
		this.nome = tecnico.getNome();
		this.status = tecnico.getStatus();
		this.latitude = tecnico.getLatitude();
		this.longitude = tecnico.getLongitude();
		this.usuario = tecnico.getUsuario();
		this.mobile = tecnico.isMobile();
		this.geolocalizacao = tecnico.getGeolocalizacao();
		this.tipoGeolocalizacao = tecnico.getTipoGeolocalizacao();
		this.oracle = tecnico.getOracle();
		this.erp = tecnico.getErp();
		this.localResidente = tecnico.getLocalResidente();
	}


	public TecnicoDTO(Integer idTecnico, Integer categoria, Date ultimoLogin, Date fimVigencia, Date inicioVigencia, String nome,
			String senha, char status, Double latitude, Double longitude, String usuario, boolean mobile,
			Date geolocalizacao, char tipoGeolocalizacao, Integer oracle, Integer erp,
			String localResidente) {
		super();
		this.idTecnico = idTecnico;
		this.categoria = categoria;
		this.ultimoLogin = ultimoLogin;
		this.fimVigencia = fimVigencia;
		this.inicioVigencia = inicioVigencia;
		this.nome = nome;
		this.senha = senha;
		this.status = status;
		this.latitude = latitude;
		this.longitude = longitude;
		this.usuario = usuario;
		this.mobile = mobile;
		this.geolocalizacao = geolocalizacao;
		this.tipoGeolocalizacao = tipoGeolocalizacao;
		this.oracle = oracle;
		this.erp = erp;
		this.localResidente = localResidente;
		//this.user = user;
	}




	public Integer getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(Integer idTecnico) {
		this.idTecnico = idTecnico;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	public Date getUltimoLogin() {
		return ultimoLogin;
	}

	public void setUltimoLogin(Date ultimoLogin) {
		this.ultimoLogin = ultimoLogin;
	}

	public Date getFimVigencia() {
		return fimVigencia;
	}

	public void setFimVigencia(Date fimVigencia) {
		this.fimVigencia = fimVigencia;
	}

	public Date getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(Date inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public boolean isMobile() {
		return mobile;
	}

	public void setMobile(boolean mobile) {
		this.mobile = mobile;
	}

	public Date getGeolocalizacao() {
		return geolocalizacao;
	}

	public void setGeolocalizacao(Date geolocalizacao) {
		this.geolocalizacao = geolocalizacao;
	}

	public char getTipoGeolocalizacao() {
		return tipoGeolocalizacao;
	}

	public void setTipoGeolocalizacao(char tipoGeolocalizacao) {
		this.tipoGeolocalizacao = tipoGeolocalizacao;
	}

	public Integer getOracle() {
		return oracle;
	}

	public void setOracle(Integer oracle) {
		this.oracle = oracle;
	}

	public Integer getErp() {
		return erp;
	}

	public void setErp(Integer erp) {
		this.erp = erp;
	}

	public String getLocalResidente() {
		return localResidente;
	}

	public void setLocalResidente(String localResidente) {
		this.localResidente = localResidente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTecnico == null) ? 0 : idTecnico.hashCode());
		return result;
	}

}
