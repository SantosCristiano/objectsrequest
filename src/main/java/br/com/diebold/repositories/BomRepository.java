package br.com.diebold.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.diebold.domain.Bom;


@Repository
public interface BomRepository extends JpaRepository<Bom, Integer> {
	
	@Query(value = "SELECT distinct(product_name)  FROM geoloc.pr_bom order by 1 ", nativeQuery = true)
	List<String> findDistinctProductNameNative();

	List<Bom> findAllByProductNameOrderByItemFamilyAsc(String equipamento);
	
	Bom findFirstByItemCodeOrderByIdDesc(String ItemCode);


	
}
