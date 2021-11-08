package org.adra.app.bi.repository;

import java.util.List;
import java.util.Optional;

import org.adra.app.bi.entity.Alternativa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlternativaRepository extends JpaRepository<Alternativa, Integer>{
	
				// Listar
				@Query(value = "{call SP_LIST_TBL_ALTERNATIVA()}", nativeQuery = true) 
				List<Alternativa> listaAltenativas();
				
				
				// Buscar
				@Query(value = "{call SP_BUSCAR_TBL_ALTERNATIVA(:p_nIDALT)}", nativeQuery = true) 
				Optional<Alternativa> buscarAlternativa(@Param("p_nIDALT") int p_nIDALT);
				
				
				// Insertar
				@Query(value = "{call SP_INS_TBL_ALTERNATIVA(:p_vNO_ALTERNATIVA, :p_cES_ALTERNATIVA_CORRECTA, :p_nID_PREGUNTA, @V_ID)}", nativeQuery = true) 
						String insertarAlternativa(@Param("p_vNO_ALTERNATIVA") String p_vNO_ALTERNATIVA,
						@Param("p_cES_ALTERNATIVA_CORRECTA") char p_cES_ALTERNATIVA_CORRECTA,
						@Param("p_nID_PREGUNTA") int p_nID_PREGUNTA);
				
				// Eliminar
				@Query(value = "{call SP_DEL_TBL_ALTERNATIVA(:p_nIDALT)}", nativeQuery = true) 
				String eliminarAlternativa(@Param("p_nIDALT") int p_nIDALT);
				
				
				// Actualizar
				@Query(value = "{call SP_UPD_TBL_ALTERNATIVA(:p_vNO_ALTERNATIVA, :p_cES_ALTERNATIVA_CORRECTA, :p_nID_PREGUNTA, :p_nID_ALTERNATIVA, @V_OK)}", nativeQuery = true) 
				String actualizarAlternativa(@Param("p_vNO_ALTERNATIVA") String p_vNO_ALTERNATIVA,
						@Param("p_cES_ALTERNATIVA_CORRECTA") char p_cES_ALTERNATIVA_CORRECTA,
						@Param("p_nID_PREGUNTA") int p_nID_PREGUNTA);
}
