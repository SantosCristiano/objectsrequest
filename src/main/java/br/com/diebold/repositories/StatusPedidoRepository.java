package br.com.diebold.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diebold.domain.StatusPedido;

@Repository
public interface StatusPedidoRepository extends JpaRepository<StatusPedido, Integer> {


	
	
}
