package org.adra.app.bi.repository;

import java.util.List;
import java.util.Optional;

import org.adra.app.bi.entity.Banco_Comunal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Banco_ComunalRepository extends JpaRepository<Banco_Comunal, Integer>{
	
	// Listar
	@Query(value = "{call SP_LIST_TBL_BANCO_COMUNAL()}", nativeQuery = true) 
	List<Banco_Comunal> listaBanco_Comunals();
	
	
	// Buscar
	@Query(value = "{call SP_BUSCAR_TBL_BANCO_COMUNAL(:p_nIDBANC)}", nativeQuery = true) 
	Optional<Banco_Comunal> buscarBanco_comunal(@Param("p_nIDBANC") int p_nIDBANC);
	
	
	// Insertar
	@Query(value = "{call SP_INS_TBL_BANCO_COMUNAL(:p_vNO_BANCO_COMUNAL, @V_ID)}", nativeQuery = true) 
	String insertarBanco_Comunal(@Param("p_vNO_BANCO_COMUNAL") String p_vNO_BANCO_COMUNAL);
	
	
	// Eliminar
	@Query(value = "{call SP_DEL_TBL_BANCO_COMUNAL(:p_nIDPRIV)}", nativeQuery = true) 
	String eliminarBanco_Comunal(@Param("p_nIDPRIV") int p_nIDPRIV);
	
	
	// Actualizar
	@Query(value = "{call SP_UPD_TBL_BANCO_COMUNAL(:p_vNO_BANCO_COMUNAL, :p_nID_BANCO_COMUNAL, @V_OK)}", nativeQuery = true) 
	String actualizarBanco_comunal(
			@Param("p_vNO_BANCO_COMUNAL") String p_vNO_BANCO_COMUNAL,
			@Param("p_nID_BANCO_COMUNAL") int p_nID_BANCO_COMUNAL);
	
}
