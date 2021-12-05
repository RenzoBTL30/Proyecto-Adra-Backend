package org.adra.app.bi.repository;

import java.util.List;
import java.util.Optional;

import org.adra.app.bi.entity.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
	
		// Listar
		@Query(value = "{call SP_LIST_TBL_ROL()}", nativeQuery = true) 
		List<Rol> listaRol();
				
		// Buscar
		@Query(value = "{call SP_BUSCAR_TBL_ROL(:p_nID_ROL)}", nativeQuery = true) 
		Optional<Rol> buscarRol(@Param("p_nID_ROL") int p_nID_ROL);
		
		
		// Insertar
		@Query(value = "{call SP_INS_TBL_ROL(:p_vNO_ROL, @V_ID)}", nativeQuery = true) 
		String insertarRol(
				@Param("p_vNO_ROL") String p_vNO_ROL);
		
		// Eliminar
		@Query(value = "{call SP_DEL_TBL_ROL(:p_nID_ROL)}", nativeQuery = true) 
		String eliminarRol(@Param("p_nID_ROL") int p_nID_ROL);
		
		
		// Actualizar
		@Query(value = "{call SP_UPD_TBL_ROL(:p_nID_ROL,:p_vNO_ROL,  @V_OK)}", nativeQuery = true) 
		String actualizarRol(
				@Param("p_nID_ROL") int p_nID_ROL,
				@Param("p_vNO_ROL") String p_vNO_ROL);
		
		@Query(value = "SELECT R.ID_ROL, NO_ROL FROM TBL_USUARIO_ROL UR JOIN TBL_USUARIO U ON U.ID_USUARIO = UR.ID_USUARIO JOIN TBL_ROL R ON R.ID_ROL = UR.ID_ROL WHERE U.ID_USUARIO = ?", nativeQuery = true)
		List<Rol> listarRoles(int id);
}
