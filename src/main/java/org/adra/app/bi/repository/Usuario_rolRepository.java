package org.adra.app.bi.repository;

import java.util.List;
import java.util.Optional;

import org.adra.app.bi.entity.Usuario_rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Usuario_rolRepository extends JpaRepository<Usuario_rol, Integer>{
	
	// Listar
	@Query(value = "{call SP_LIST_TBL_USUARIO_ROL()}", nativeQuery = true) 
	List<Usuario_rol> listaUsuario_rols();
	
	// Buscar
	@Query(value = "{call SP_BUSCAR_TBL_USUARIO_ROL(:p_nID_USR)}", nativeQuery = true) 
	Optional<Usuario_rol> buscarUsuario_rol(@Param("p_nID_USR") int p_nID_USR);


	// Insertar
	@Query(value = "{call SP_INS_TBL_USUARIO_ROL(:p_nID_PERSONA,:p_nID_ROL, @V_ID)}", nativeQuery = true) 
	String insertarUsuario_rol(	
			@Param("p_nID_PERSONA") int p_nID_PERSONA,
			@Param("p_nID_ROL") int p_nID_ROL);

	// Eliminar
	@Query(value = "{call SP_DEL_TBL_USUARIO_ROL(:p_nID_USR)}", nativeQuery = true) 
	String eliminarUsuario_rol(@Param("p_nID_USR") int p_nID_USR);


	// Actualizar
	@Query(value = "{call SP_UPD_TBL_USUARIO_ROL(:p_nID_PERSONA, :p_nID_ROL, :p_nID_USUARIO_ROL, @V_OK)}", nativeQuery = true) 
	String actualizarUsuario_rol(
			@Param("p_nID_PERSONA") int p_nID_PERSONA,
			@Param("p_nID_ROL") int p_nID_ROL,
			@Param("p_nID_USUARIO_ROL") int p_nID_USUARIO_ROL);
}
