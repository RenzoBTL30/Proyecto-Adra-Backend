package org.adra.app.bi.repository;

import java.util.List;
import java.util.Optional;

import org.adra.app.bi.entity.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Integer>{
	
		// Listar
		@Query(value = "{call SP_LIST_TBL_RECURSO()}", nativeQuery = true) 
		List<Recurso> listaRecursos();
				
				
		// Buscar
		@Query(value = "{call SP_BUSCAR_TBL_RECURSO(:p_nIDREC)}", nativeQuery = true) 
		Optional<Recurso> buscarRecurso(@Param("p_nIDREC") int p_nIDREC);
				
				
		// Insertar
		@Query(value = "{call SP_INS_TBL_RECURSO(:p_vNO_RECURSO, :p_nNU_ORDEN, :p_vDI_URL, :p_cES_RECURSO, :p_nID_SESION, :p_nID_TIPO_RECURSO, @V_ID)}", nativeQuery = true) 
		String insertarRecurso(@Param("p_vNO_RECURSO") String p_vNO_RECURSO, @Param("p_nNU_ORDEN") int p_nNU_ORDEN, 
						@Param("p_vDI_URL") String p_vDI_URL, @Param("p_cES_RECURSO") char p_cES_RECURSO, @Param("p_nID_SESION") int p_nID_SESION, 
						   @Param("p_nID_TIPO_RECURSO") int p_nID_TIPO_RECURSO);
				
		// Eliminar
		@Query(value = "{call SP_DEL_TBL_RECURSO(:p_nIDREC, @V_RECURSO)}", nativeQuery = true) 
		String eliminarRecurso(@Param("p_nIDREC") int p_nIDREC);
				
				
		// Actualizar
		@Query(value = "{call SP_UPD_TBL_RECURSO(:p_vNO_RECURSO, :p_nNU_ORDEN, :p_vDI_URL, :p_cES_RECURSO, :p_nID_SESION, :p_nID_TIPO_RECURSO, :p_nRECURSO, @V_OK)}", nativeQuery = true) 
		String actualizarRecurso(@Param("p_vNO_RECURSO") String p_vNO_RECURSO, @Param("p_nNU_ORDEN") int p_nNU_ORDEN, 
		@Param("p_vDI_URL") String p_vDI_URL, @Param("p_cES_RECURSO") char p_cES_RECURSO, @Param("p_nID_SESION") int p_nID_SESION, 
		@Param("p_nID_TIPO_RECURSO") int p_nID_TIPO_RECURSO, @Param("p_nRECURSO") int p_nRECURSO);
	
}
