package br.com.diebold.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diebold.domain.Atendimento;
import br.com.diebold.domain.Site;
import br.com.diebold.domain.Tarefa;
import br.com.diebold.domain.Tecnico;
import br.com.diebold.dto.SiteDTO;
import br.com.diebold.dto.TarefaDTO;
import br.com.diebold.dto.TecnicoDTO;
import br.com.diebold.dto.VerificaDTO;
import br.com.diebold.repositories.AtendimentoRepository;
import br.com.diebold.repositories.SiteRepository;
import br.com.diebold.repositories.TarefaRepository;
import br.com.diebold.repositories.TecnicoRepository;

@Service
public class VerificaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	@Autowired
	private SiteRepository siteRepository;
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	public List<TarefaDTO> verificaTarefasPeloTecnico(int idTecnico) {
		List<Atendimento> vAtendimento;
		vAtendimento = atendimentoRepository.findByIdTecnicoAndStAtendimento(idTecnico, 'A');
		
		List<TarefaDTO> tDTO = new ArrayList<>();
		
		for (int i = 0; i < vAtendimento.size(); i++) {
			String statusTarefa = vAtendimento.get(i).getTarefa().getStatusTarefa();
			if(!statusTarefa.equals("Q") && !statusTarefa.equals("R") && !statusTarefa.equals("S") && !statusTarefa.equals("X")) {
				TarefaDTO tarefaDTO = new TarefaDTO(vAtendimento.get(i).getTarefa());
				tDTO.add(tarefaDTO);
			}
        }
		
		return tDTO;
	}
	

	public VerificaDTO verificaTarefa(int idTarefa) {
		Optional<Tarefa> vTarefa;
		VerificaDTO vDTO = new VerificaDTO();
		try {
			vTarefa = tarefaRepository.findById(idTarefa);
			
			if(vTarefa.get().getId() != null) {
			vDTO.setIdTarefa(vTarefa.get().getId());
			vDTO.setDtAbertura(vTarefa.get().getDataAbertura());
			vDTO.setPrazoAtendimento(vTarefa.get().getDataLimiteAtendimento());
			vDTO.setPrazoSolucao(vTarefa.get().getDataLimiteSolucao());
			vDTO.setDescricaoDoEquipamento(vTarefa.get().getDescricaoDoEquipamento());
			vDTO.setNumeroDeSerieDoEquipamento(vTarefa.get().getNumeroDeSerieDoEquipamento());
			vDTO.setCatEquipamento(vTarefa.get().getAttribute8());
			vDTO.setEnderecoSite(vTarefa.get().getSite().getEndereco() + " - "
					+ vTarefa.get().getSite().getCep() + " - "
					+ vTarefa.get().getSite().getBairro() + " - "
					+ vTarefa.get().getSite().getCidade() + " - "
					+ vTarefa.get().getSite().getEstado() + " - RT: "
					+ vTarefa.get().getSite().getRegiaoTecnica());
			vDTO.setCliente(vTarefa.get().getSite().getCliente());
			vDTO.setIdSite(vTarefa.get().getSite().getId());
			vDTO.setNmSite(vTarefa.get().getSite().getSite());
			vDTO.setRegiaoTecnica(vTarefa.get().getSite().getFilial().getId());
			
			System.out.println("Tarefa Verificada: " + vTarefa.get().getId() + 
					"  Site: " + vTarefa.get().getSite().getId() + "  Equipamento: " + vTarefa.get().getDescricaoDoEquipamento());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vDTO;
	}

	public SiteDTO verificaSite(String site) {
		Site vSite;
		vSite = siteRepository.findById(site);
		SiteDTO sDTO = new SiteDTO();
		sDTO.setEndereco(vSite.getEndereco() + " - "
				+ vSite.getCep() + " - "
				+ vSite.getBairro() + " - "
				+ vSite.getCidade() + " - "
				+ vSite.getEstado() + " - RT: "
				+ vSite.getRegiaoTecnica());
		sDTO.setCliente(vSite.getCliente());
		sDTO.setBairro(vSite.getBairro());
		sDTO.setCidade(vSite.getCidade());
		sDTO.setEstado(vSite.getEstado());
		sDTO.setPais(vSite.getPais());
		sDTO.setCep(vSite.getCep());
		sDTO.setId(vSite.getId());
		sDTO.setSite(vSite.getSite());
		sDTO.setRegiaoTecnica(vSite.getFilial().getId());
		sDTO.setLatitude(vSite.getLatitude());
		sDTO.setLongitude(vSite.getLongitude());
		sDTO.setStatus(vSite.getStatus());
		sDTO.setTelefone(vSite.getTelefone());
		
		System.out.println("Tarefa Verificada: " + vSite.getId() + 
				"  Site: " + vSite.getId());
		
		return sDTO;
//		boolean vSite = false;
//		vSite = siteRepository.existsById(idSite);
//		return vSite;
	}
	
	public TecnicoDTO verificaTecnico(int erp) {
		Optional<Tecnico> vTecnico;
		vTecnico = Optional.of(tecnicoRepository.findByErp(erp));
		
		TecnicoDTO tDTO = new TecnicoDTO();
		tDTO.setCategoria(vTecnico.get().getCategoria());
		tDTO.setFimVigencia(vTecnico.get().getFimVigencia());
		tDTO.setGeolocalizacao(vTecnico.get().getGeolocalizacao());
		tDTO.setIdTecnico(vTecnico.get().getIdTecnico());
		tDTO.setInicioVigencia(vTecnico.get().getInicioVigencia());
		tDTO.setLatitude(vTecnico.get().getLatitude());
		tDTO.setLocalResidente(vTecnico.get().getLocalResidente());
		tDTO.setLongitude(vTecnico.get().getLongitude());
		tDTO.setMobile(vTecnico.get().isMobile());
		tDTO.setNome(vTecnico.get().getNome());
		tDTO.setOracle(vTecnico.get().getOracle());
		tDTO.setStatus(vTecnico.get().getStatus());
		tDTO.setTipoGeolocalizacao(vTecnico.get().getTipoGeolocalizacao());
		tDTO.setUltimoLogin(vTecnico.get().getUltimoLogin());
		tDTO.setUsuario(vTecnico.get().getUsuario());
		tDTO.setErp(vTecnico.get().getErp());
		
		System.out.println("Tecnico Verificada: " + vTecnico.get().getIdTecnico());
		
		return tDTO;
	}
//		boolean vTecnico = false;
//		vTecnico = tecnicoRepository.existsById(idTecnico);
//		return vTecnico;
//	}

//	public Tecnico verificaTecnico(int idTecnico) {
//		Tecnico tec = new Tecnico();
//		tec = tecnicoRepository.getOne(idTecnico);	
//		return tec;
//	}

}
