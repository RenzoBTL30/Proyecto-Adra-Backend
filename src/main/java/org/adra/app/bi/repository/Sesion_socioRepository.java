package org.adra.app.bi.repository;

import java.util.List;
import java.util.Optional;

import org.adra.app.bi.entity.Sesion_socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Sesion_socioRepository extends JpaRepository<Sesion_socio, Integer>{
				// Listar
				@Query(value = "{call SP_LIST_TBL_SESION_SOCIO()}", nativeQuery = true) 
				List<Sesion_socio> listaSesiones();
					
					
				// Buscar
				@Query(value = "{call SP_BUS_TBL_SESION_SOCIO(:p_nIDUSA)}", nativeQuery = true) 
				Optional<Sesion_socio> buscarSesiones(@Param("p_nIDUSA") int p_nIDUSA);
					
					
				// Insertar
				@Query(value = "{call SP_INS_TBL_SESION_SOCIO(:p_nNU_VALORACION, :p_nCA_RECURSOS_VISTOS,:p_nID_PERSONA, :p_nID_SESION, @V_ID)}", nativeQuery = true) 
				String insertarSesiones(@Param("p_nNU_VALORACION") int  p_nNU_VALORACION,
					@Param("p_nCA_RECURSOS_VISTOS") int p_nCA_RECURSOS_VISTOS,	
					@Param("p_nID_PERSONA") int p_nID_PERSONA,
					@Param("p_nID_SESION") int p_nID_SESION);
					
				// Eliminar
				@Query(value = "{call SP_DEL_TBL_SESION_SOCIO(:p_nIDSE,@V_NU_VALORACION)}", nativeQuery = true) 
				String eliminarSesiones(@Param("p_nIDSE") int p_nIDSE);
					
					
				// Actualizar
				@Query(value = "{call SP_UPD_TBL_SESION_SOCIO(:p_nID_SESION_SOCIO,:p_nNU_VALORACION, :p_nCA_RECURSOS_VISTOS, :p_nID_PERSONA, :P_nID_SESION, @V_OK)}", nativeQuery = true) 
				String actualizarSesiones(@Param("p_nID_SESION_SOCIO") int p_nID_SESION_SOCIO,
					@Param("p_nNU_VALORACION") int p_nNU_VALORACION,
					@Param("p_nCA_RECURSOS_VISTOS") int p_nCA_RECURSOS_VISTOS,
					@Param("p_nID_PERSONA") int p_nID_PERSONA,
					@Param("P_nID_SESION") int P_nID_SESION);
}
