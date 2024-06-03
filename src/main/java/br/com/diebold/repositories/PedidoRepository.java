package br.com.diebold.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diebold.domain.Filial;
import br.com.diebold.domain.Localizacao;
import br.com.diebold.domain.Pedido;
import br.com.diebold.domain.Tecnico;
import br.com.diebold.domain.TipoPedido;
import br.com.diebold.domain.Transporte;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

	List<Pedido> findByTecnico(Integer id);

	List<Pedido> findByIdIn(List<Integer> ids);	

	List<Pedido>  findDistinctIdByFilialInAndStatusInAndLocalizacaoInAndTipoPedidoInAndTransporteInOrderByIdDesc(List<Filial> filiaisS, List<String> statusS, List<Localizacao> locaisS, List<TipoPedido> tipoPedido, List<Transporte> transportesS);
	
	List<Pedido>  findDistinctIdByTecnicoAndFilialInAndStatusInAndLocalizacaoInAndTipoPedidoInAndTransporteInOrderByIdDesc(Tecnico idTecnico, List<Filial> filiaisS, List<String> statusS, List<Localizacao> locaisS, List<TipoPedido> tipoPedido, List<Transporte> transportesS);
	
	List<Pedido>  findDistinctIdByIdAndFilialInAndStatusInAndLocalizacaoInAndTipoPedidoInAndTransporteInOrderByIdDesc(Integer idPedido, List<Filial> filiaisS, List<String> statusS, List<Localizacao> locaisS, List<TipoPedido> tipoPedido, List<Transporte> transportesS);

	List<Pedido> findByTecnicoIdTecnicoOrderByIdDesc(Integer tecnico);
	
	List<Pedido> findByTecnicoIdTecnicoAndStatusOrderByIdDesc(Integer tecnico, String status);
	
	List<Pedido> findByTecnicoIdTecnicoAndTipoPedidoTipoPedidoOrderByIdDesc(Integer tecnico, String tipo);
}
