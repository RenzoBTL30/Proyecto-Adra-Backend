package org.adra.app.bi.repository;

import java.util.List;
import java.util.Optional;

import org.adra.app.bi.entity.Control_Vista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Control_VistaRepository extends JpaRepository<Control_Vista, Integer>{
				// Listar
				@Query(value = "{call SP_LIST_TBL_CONTROL_VISTA()}", nativeQuery = true) 
				List<Control_Vista> listaControles();
					
					
				// Buscar
				@Query(value = "{call SP_BUS_TBL_CONTROL_VISTA(:p_nIDUSA)}", nativeQuery = true) 
				Optional<Control_Vista> buscarControles(@Param("p_nIDUSA") int p_nIDUSA);
					
					
				// Insertar
				@Query(value = "{call SP_INS_TBL_CONTROL_VISTA(:p_cES_VISTO, :p_nID_PERSONA,:p_nID_RECURSO, @V_ID)}", nativeQuery = true) 
				String insertarControles(@Param("p_cES_VISTO") String  p_cES_VISTO,
						@Param("p_nID_PERSONA") int p_nID_PERSONA,
						@Param("p_nID_RECURSO") int p_nID_RECURSO);
					
				// Eliminar
				@Query(value = "{call SP_DEL_TBL_CONTROL_VISTA(:p_nIDCON,@V_ES_VISTO)}", nativeQuery = true) 
				String eliminarControles(@Param("p_nIDCON") int p_nIDCON);
					
					
				// Actualizar
				@Query(value = "{call SP_UPD_TBL_CONTROL_VISTA(:p_nID_CONTROL_VISTA,:p_cES_VISTO, :p_nID_PERSONA, :p_nID_RECURSO, @V_OK)}", nativeQuery = true) 
				String actualizarControles(@Param("p_nID_CONTROL_VISTA") int p_nID_CONTROL_VISTA,
										   @Param("p_cES_VISTO") String p_cES_VISTO,
										   @Param("p_nID_PERSONA") int p_nID_PERSONA,
										   @Param("p_nID_RECURSO") int p_nID_RECURSO);
				
				
				@Query(value = "{call SP_UPD_VISTO_RECURSO(?, ?)}", nativeQuery = true) 
				String actualizarVisto(int p_nID_AFILIACION, int p_nID_RECURSO);
}
