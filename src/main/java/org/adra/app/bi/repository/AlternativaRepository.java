package org.adra.app.bi.repository;

import java.util.List;

import org.adra.app.bi.entity.Alternativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlternativaRepository extends JpaRepository<Alternativa, Integer>{
	
	@Query(value = "{call SP_LIST_TBL_ALTERNATIVA()}", nativeQuery = true) 
	List<Alternativa> listaAltenativas();
}
