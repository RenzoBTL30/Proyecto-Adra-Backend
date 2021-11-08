package org.adra.app.bi.repository;

import java.util.List;
import java.util.Optional;

import org.adra.app.bi.entity.Afiliacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AfiliacionRepository extends JpaRepository<Afiliacion, Integer>{
				// Listar
				@Query(value = "{call SP_LIST_TBL_AFILIACION()}", nativeQuery = true) 
				List<Afiliacion> listaAfiliaciones();
				
				
				// Buscar
				@Query(value = "{call SP_BUSCAR_TBL_AFILIACION(:p_nIDEMP)}", nativeQuery = true) 
				Optional<Afiliacion> buscarAfiliacion(@Param("p_nIDEMP") int p_nIDEMP);
				
				
				// Insertar
				@Query(value = "{call SP_INS_TBL_AFILIACION(:p_nCA_RECURSOS_VISTOS, :p_nID_PERSONA,:p_nID_CAPACITACION, @V_ID)}", nativeQuery = true) 
				String insertarAfiliacion(@Param("p_nCA_RECURSOS_VISTOS") int  p_nCA_RECURSOS_VISTOS,
						@Param("p_nID_PERSONA") int p_nID_PERSONA,
						@Param("p_nID_CAPACITACION") int p_nID_CAPACITACION);
				
				// Eliminar
				@Query(value = "{call SP_DEL_TBL_AFILIACION(:p_nIDAFI,@V_RECURSOS_VISTOS)}", nativeQuery = true) 
				String eliminarAfiliacion(@Param("p_nIDAFI") int p_nIDAFI);
				
				
				// Actualizar
				@Query(value = "{call SP_UPD_TBL_AFILIACION(:p_nID_AFILIACION,:p_nCA_RECURSOS_VISTOS, :p_nID_PERSONA, :p_nID_CAPACITACION, @V_OK)}", nativeQuery = true) 
				String actualizarAfiliacion(@Param("p_nID_AFILIACION") int p_nID_AFILIACION,@Param("p_nCA_RECURSOS_VISTOS") int p_nCA_RECURSOS_VISTOS ,
				@Param("p_nID_PERSONA") int p_nID_PERSONA,@Param("p_nID_CAPACITACION") int p_nID_CAPACITACION);
}
