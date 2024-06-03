package br.com.diebold.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diebold.domain.Site;

@Repository
public interface SiteRepository extends JpaRepository<Site, Integer> {

	Site findById(String idSite);

	boolean existsById(String idSite);

	
}
