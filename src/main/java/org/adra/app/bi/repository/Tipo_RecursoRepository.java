package org.adra.app.bi.repository;

import java.util.List;
import java.util.Optional;

import org.adra.app.bi.entity.Tipo_Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Tipo_RecursoRepository extends JpaRepository<Tipo_Recurso, Integer>{
			
			// Listar
			@Query(value = "{call SP_LIST_TBL_TIPO_RECURSO()}", nativeQuery = true) 
			List<Tipo_Recurso> listaTipoRecursos();
			
			
			// Buscar
			@Query(value = "{call SP_BUSCAR_TBL_TIPO_RECURSO(:p_nIDTIPREC)}", nativeQuery = true) 
			Optional<Tipo_Recurso> buscarTipoRecurso(@Param("p_nIDTIPREC") int p_nIDTIPREC);
			
			
			// Insertar
			@Query(value = "{call SP_INS_TBL_TIPO_RECURSO(:p_vNO_TIPO_RECURSO, @V_ID)}", nativeQuery = true) 
			String insertarTipoRecurso(@Param("p_vNO_TIPO_RECURSO") String p_vNO_TIPO_RECURSO);
			
			// Eliminar
			@Query(value = "{call SP_DEL_TBL_TIPO_RECURSO(:p_nIDTIPREC)}", nativeQuery = true) 
			String eliminarTipoRecurso(@Param("p_nIDTIPREC") int p_nIDTIPREC);
			
			
			// Actualizar
			@Query(value = "{call SP_UPD_TBL_TIPO_RECURSO(:p_vNO_TIPO_RECURSO, :p_nID_TIPO_RECURSO, @V_OK)}", nativeQuery = true) 
			String actualizarTipoRecurso(@Param("p_vNO_TIPO_RECURSO") String p_vNO_TIPO_RECURSO,
					@Param("p_nID_TIPO_RECURSO") int p_nID_TIPO_RECURSO);
}
