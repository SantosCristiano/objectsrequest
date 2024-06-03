package br.com.diebold.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import br.com.diebold.domain.Usuario;
import br.com.diebold.utils.ObjectMapperUtils;

public class UsuarioDTO  {


	@Column(name="usuario_id")
	private Integer id;
	
	@Column(name="usuario")
	private String usuario;

	@Column(name="senha")
	private String senha;
	
	@Column(name="nm_usuario")
	private String nome;	

	@Column(name="dt_inicio")
	private Date dataInicio;
	
	@Column(name="dt_fim")
	private Date dataFim;			
	
	@Column(name="perfis")
	private List<PerfilDTO> perfis = new ArrayList<>();

	@Column(name="filiais")
	private List<FilialDTO> filiais = new ArrayList<>();
	
	@Column(name="tecnicoDTO")
	private TecnicoDTO tecnicoDTO = new TecnicoDTO();
	
	@Column(name = "altera_senha")
	private boolean alteraSenha;

	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioDTO(Usuario user) {
		this.id = user.getId();
		this.usuario = user.getUsuario();
		//this.senha = user.getSenha();
		this.nome = user.getNome();
		this.dataInicio = user.getDataInicio();
		this.dataFim = user.getDataFim();
		List<PerfilDTO>  perfilDTO = new ArrayList<PerfilDTO>((ObjectMapperUtils.mapAll(user.getPerfis(), PerfilDTO.class)));	
		this.perfis =  perfilDTO;
		List<FilialDTO>  filialDTO = new ArrayList<FilialDTO>((ObjectMapperUtils.mapAll(user.getFiliais(), FilialDTO.class)));
		this.filiais =  filialDTO;
		this.alteraSenha = user.isAlteraSenha();
		if(user.getTecnico() != null) {
		TecnicoDTO  tecnicoDTO = new TecnicoDTO(user.getTecnico());
		this.tecnicoDTO =  tecnicoDTO;
		}
	}
	
	
	public UsuarioDTO(Integer id, String usuario, String senha, String nome, Date dataInicio, Date dataFim, boolean alteraSenha) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	

	public List<PerfilDTO> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<PerfilDTO> perfis) {
		this.perfis = perfis;
	}

	public List<FilialDTO> getFiliais() {
		return filiais;
	}

	public void setFiliais(List<FilialDTO> filiais) {
		this.filiais = filiais;
	}
	
	public TecnicoDTO getTecnico() {
		return tecnicoDTO;
	}

	public void setTecnico(TecnicoDTO tecnico) {
		this.tecnicoDTO = tecnico;
	}

	public boolean isAlteraSenha() {
		return alteraSenha;
	}

	public void setAlteraSenha(boolean alteraSenha) {
		this.alteraSenha = alteraSenha;
	}
	
	
	
	
}
