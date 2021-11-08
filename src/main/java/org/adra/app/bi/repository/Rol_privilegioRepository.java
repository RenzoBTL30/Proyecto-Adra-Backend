package org.adra.app.bi.repository;

import java.util.List;
import java.util.Optional;

import org.adra.app.bi.entity.Rol_privilegio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Rol_privilegioRepository extends JpaRepository<Rol_privilegio, Integer>{
		
		// Listar
			@Query(value = "{call SP_LIST_TBL_ROL_PRIVILEGIO()}", nativeQuery = true) 
			List<Rol_privilegio> listaRol_privilegios();
			
		// Buscar
			@Query(value = "{call SP_BUSCAR_TBL_ROL_PRIVILEGIO(:p_nID_PRIV)}", nativeQuery = true) 
			Optional<Rol_privilegio> buscarRol_privilegio(@Param("p_nID_PRIV") int p_nID_PRIV);
			
		// Insertar
			@Query(value = "{call SP_INS_TBL_ROL_PRIVILEGIO(:p_nID_ROL, :p_nID_PRIVILEGIO, @V_ID)}", nativeQuery = true) 
			String insertarRol_privilegio(
					@Param("p_nID_ROL") int p_nID_ROL,
					@Param("p_nID_PRIVILEGIO") int p_nID_PRIVILEGIO);
			
		// Eliminar
			@Query(value = "{call SP_DEL_TBL_ROL_PRIVILEGIO(:p_nID_PRV)}", nativeQuery = true) 
			String eliminarRol_privilegio(@Param("p_nID_PRV") int p_nID_PRV);
			
			
		// Actualizar
			@Query(value = "{call SP_UPD_TBL_ROL_PRIVILEGIO(:p_nID_ROL, :p_nID_PRIVILEGIO, :p_nID_ROL_PRIVILEGIO, @V_OK)}", nativeQuery = true) 
			String actualizarRol_privilegio(
				@Param("p_nID_ROL") int p_nID_ROL,
				@Param("p_nID_PRIVILEGIO") int p_nID_PRIVILEGIO,
				@Param("p_nID_ROL_PRIVILEGIO") int p_nID_ROL_PRIVILEGIO
			);
}
