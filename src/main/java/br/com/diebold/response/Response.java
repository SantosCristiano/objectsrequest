package br.com.diebold.response;

import java.util.ArrayList;
import java.util.List;

import br.com.diebold.dto.BomDTO;
import br.com.diebold.dto.FilialDTO;
import br.com.diebold.dto.FiltrosDTO;
import br.com.diebold.dto.FuncionalidadeDTO;
import br.com.diebold.dto.PedidoDTO;
import br.com.diebold.dto.PerfilDTO;
import br.com.diebold.dto.StatusDTO;
import br.com.diebold.dto.UsuarioDTO;
import br.com.diebold.dto.VerificaDTO;

public class Response<T> {

	private T data;
	
	private List<T> listData;
	
	private List<PedidoDTO> pDto;
	
	private List<StatusDTO> sDto;
	
	private List<String> errors;
	
	private FiltrosDTO filtroCP ;
	
	private VerificaDTO verificaDTO;
	
	private List<BomDTO> bDto;

	private List<PerfilDTO> perfilDto;
	
	private List<FuncionalidadeDTO> funcionalidadeDto;
	
	private List<UsuarioDTO>  usuarioDTO  = new ArrayList<UsuarioDTO>() ;			

	private List<FilialDTO> filialDTO;
	
	private FilialDTO filial = new FilialDTO();
	
	private UsuarioDTO  usuario  = new UsuarioDTO() ;			

	public List<FilialDTO> getFilialDTO() {
		return filialDTO;
	}

	public void setFilialDTO(List<FilialDTO> filialDTO) {
		this.filialDTO = filialDTO;
	}

	public List<UsuarioDTO> getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(List<UsuarioDTO> usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<T> getListData() {
		return listData;
	}

	public void setListData(List<T> listData) {
		this.listData = listData;
	}

	public List<PedidoDTO> getpDto() {
		return pDto;
	}

	public void setpDto(List<PedidoDTO> pDto) {
		this.pDto = pDto;
	}

	public List<StatusDTO> getsDto() {
		return sDto;
	}

	public void setsDto(List<StatusDTO> sDto) {
		this.sDto = sDto;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public FiltrosDTO getFiltroCP() {
		return filtroCP;
	}

	public void setFiltroCP(FiltrosDTO filtroCP) {
		this.filtroCP = filtroCP;
	}

	public VerificaDTO getVerificaDTO() {
		return verificaDTO;
	}

	public void setVerificaDTO(VerificaDTO verificaDTO) {
		this.verificaDTO = verificaDTO;
	}

	public List<BomDTO> getbDto() {
		return bDto;
	}

	public void setbDto(List<BomDTO> bDto) {
		this.bDto = bDto;
	}

	public List<PerfilDTO> getPerfilDto() {
		return perfilDto;
	}

	public void setPerfilDto(List<PerfilDTO> perfilDto) {
		this.perfilDto = perfilDto;
	}

	public List<FuncionalidadeDTO> getFuncionalidadeDto() {
		return funcionalidadeDto;
	}

	public void setFuncionalidadeDto(List<FuncionalidadeDTO> funcionalidadeDto) {
		this.funcionalidadeDto = funcionalidadeDto;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public FilialDTO getFilial() {
		return filial;
	}

	public void setFilial(FilialDTO filial) {
		this.filial = filial;
	}
	
	





	
}
