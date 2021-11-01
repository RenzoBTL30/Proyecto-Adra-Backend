package org.adra.app.bi.repository;

import java.util.List;

import org.adra.app.bi.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer>{
	
	@Query(value = "{call SP_LIST_TBL_PERSONA()}", nativeQuery = true) 
	List<Persona> listaPersonas();
}