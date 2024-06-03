package br.com.diebold.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diebold.domain.TipoPedido;

@Repository
public interface TipoPedidoRepository extends JpaRepository<TipoPedido, Integer> {

	TipoPedido findFirstByTipoPedidoOrderByIdAsc(String nomeLocalizacao);

	
}
