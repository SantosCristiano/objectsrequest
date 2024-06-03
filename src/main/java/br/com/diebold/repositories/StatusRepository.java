package br.com.diebold.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diebold.domain.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

	Status findFirstByStatusOrderByIdAsc(String Status);

	
}
