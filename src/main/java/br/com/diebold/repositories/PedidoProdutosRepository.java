package br.com.diebold.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diebold.domain.PedidoProdutos;

@Repository
public interface PedidoProdutosRepository extends JpaRepository<PedidoProdutos, Integer> {


	
	
}
