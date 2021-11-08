package org.adra.app.bi.repository;

import java.util.List;
import java.util.Optional;

import org.adra.app.bi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	// Listar
	@Query(value = "{call SP_LIST_TBL_USUARIO()}", nativeQuery = true) 
	List<Usuario> listaUsuarios();

	// Buscar
	@Query(value = "{call SP_BUSCAR_TBL_USUARIO(:p_nID_USA)}", nativeQuery = true) 
	Optional<Usuario> buscarUsuario(@Param("p_nID_USA") int p_nID_USA);
	
	
	// Insertar
	@Query(value = "{call SP_INS_TBL_USUARIO(:p_nID_PERSONA, :p_vNO_USUARIO,:p_vDE_CONTRASENIA)}", nativeQuery = true) 
	<varchar> String insertarUsuario(
			@Param("p_nID_PERSONA") int p_nID_PERSONA,
			@Param("p_vNO_USUARIO") varchar p_vNO_USUARIO,
			@Param("p_vDE_CONTRASENIA") varchar p_vDE_CONTRASENIA);
	
	// Eliminar
	@Query(value = "{call SP_DEL_TBL_USUARIO(:p_nID_PERSONA, @V_IDUS)}", nativeQuery = true) 
	String eliminarUsuario(@Param("p_nID_PERSONA") int p_nID_PER);
	
	
	// Actualizar
	@Query(value = "{call SP_UPD_TBL_USUARIO(:p_vNO_USUARIO,:p_vDE_CONTRASENIA,:p_nID_PERSONA,  @V_OK)}", nativeQuery = true) 
	String actualizarUsuario(
			@Param("p_vNO_USUARIO") String p_vNO_USUARIO,
			@Param("p_vDE_CONTRASENIA") String p_vDE_CONTRASENIA,
			@Param("p_nID_PERSONA") int p_nID_PERSONA
			);
}
