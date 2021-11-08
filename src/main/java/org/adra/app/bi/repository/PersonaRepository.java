package org.adra.app.bi.repository;

import java.util.List;
import java.util.Optional;

import org.adra.app.bi.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer>{
	
				// Listar
				@Query(value = "{call SP_LIST_TBL_PERSONA()}", nativeQuery = true) 
				List<Persona> listaPersonas();
				
				// Buscar
				@Query(value = "{call SP_BUSCAR_TBL_PERSONA(:p_nID_PER)}", nativeQuery = true) 
				Optional<Persona> buscarPersona(@Param("p_nID_PER") int p_nID_PER);
				
				// Insertar
				@Query(value = "{call SP_INS_TBL_PERSONA(:p_vNO_PERSONA, :p_vAP_PATERNO,:p_vAP_MATERNO,:p_vNU_DNI,:p_vEM_CORREO_ELECTRONICO,:p_vNU_TELEFONO, @V_ID)}", nativeQuery = true) 
				String insertarPersona(
						@Param("p_vNO_PERSONA") String p_vNO_PERSONA,
						@Param("p_vAP_PATERNO") String p_vAP_PATERNO,
						@Param("p_vAP_MATERNO") String p_vAP_MATERNO,
						@Param("p_vNU_DNI") String p_vNU_DNI,
						@Param("p_vEM_CORREO_ELECTRONICO") String p_vEM_CORREO_ELECTRONICO,
						@Param("p_vNU_TELEFONO") String p_vNU_TELEFONO);
				
				// Eliminar
				@Query(value = "{call SP_DEL_TBL_PERSONA( p_nID_PER)}", nativeQuery = true) 
				String eliminarPersona(@Param("p_nID_PER") int p_nID_PER);
				
				
				// Actualizar
				@Query(value = "{call SP_UPD_TBL_PERSONA(:p_vNO_PERSONA, :p_vAP_PATERNO,:p_vAP_MATERNO,:p_vNU_DNI,:p_vEM_CORREO_ELECTRONICO,:p_vNU_TELEFONO, :p_nID_PERSONA, @V_OK)}", nativeQuery = true) 
				String actualizarPersona(
						@Param("p_vNO_PERSONA") String p_vNO_PERSONA,
						@Param("p_vAP_PATERNO") String p_vAP_PATERNO,
						@Param("p_vAP_MATERNO") String p_vAP_MATERNO,
						@Param("p_vNU_DNI") String p_vNU_DNI,
						@Param("p_vEM_CORREO_ELECTRONICO") String p_vEM_CORREO_ELECTRONICO,
						@Param("p_vNU_TELEFONO") String p_vNU_TELEFONO,
						@Param("p_nID_PERSONA") int p_nID_PERSONA
						);
}
