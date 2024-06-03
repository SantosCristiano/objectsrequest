package br.com.diebold.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.diebold.domain.enums.PerfilSistema;
import br.com.diebold.dto.UsuarioDTO;
import br.com.diebold.utils.ObjectMapperUtils;

@Entity(name = "PR_USUARIO")
@Table(name = "PR_USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usuario_id")
	private Integer id;
	@Column(name = "usuario")
	private String usuario;
	@Column(name = "nm_usuario")
	private String nome;
	@JsonIgnore
	@Column(name = "senha")
	private String senha;
	@Column(name = "dt_inicio")
	private Date dataInicio;
	@Column(name = "dt_fim")
	private Date dataFim;
	@Column(name = "dt_ultimo_acesso")
	private Date dataUltimoAcesso;
	
	@Column(name = "altera_senha")
	private boolean alteraSenha;
	

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PR_PerfilSistema")
	private Set<Integer> perfilSistema = new HashSet<>();

	@JsonManagedReference
	@ManyToMany(mappedBy = "usuarios")
	private List<Perfil> perfis = new ArrayList<>();

	@JsonManagedReference
	@ManyToMany(mappedBy = "usuarios")
	private List<Filial> filiais = new ArrayList<>();
	
	@OneToOne
	@NotFound(action = NotFoundAction.IGNORE)
//	@MapsId
	private Tecnico tecnico;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(UsuarioDTO dto) {
		this.id = dto.getId();
		this.usuario = dto.getUsuario();
		this.nome = dto.getNome();
		this.dataInicio = dto.getDataInicio();
		this.dataFim = dto.getDataFim();
		this.alteraSenha = dto.isAlteraSenha();
		List<Perfil> perfil = new ArrayList<Perfil>((ObjectMapperUtils.mapAll(dto.getPerfis(), Perfil.class)));
		this.perfis = perfil;
		List<Filial> filial = new ArrayList<Filial>((ObjectMapperUtils.mapAll(dto.getFiliais(), Filial.class)));
		this.filiais = filial;
//		Tecnico tecnico = new Tecnico(dto.getTecnico());
//		this.tecnico = tecnico; 

	}

	public Usuario(Integer id, String usuario, String nome, String senha, Date dataInicio, Date dataFim,
			Date dataUltimoAcesso, Tecnico tecnico, boolean alteraSenha) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.nome = nome;
		this.senha = senha;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.dataUltimoAcesso = dataUltimoAcesso;
		this.tecnico = tecnico;
		this.alteraSenha = alteraSenha;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Date getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}

	public void setDataUltimoAcesso(Date dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}

	public Set<PerfilSistema> getPerfilSistema() {
		return perfilSistema.stream().map(x -> PerfilSistema.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfilSistema(PerfilSistema perfilS) {
		perfilSistema.add(perfilS.getCod());
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	public List<Filial> getFiliais() {
		return filiais;
	}

	public void setFiliais(List<Filial> filiais) {
		this.filiais = filiais;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public boolean isAlteraSenha() {
		return alteraSenha;
	}

	public void setAlteraSenha(boolean alteraSenha) {
		this.alteraSenha = alteraSenha;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
