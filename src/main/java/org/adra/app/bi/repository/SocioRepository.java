package org.adra.app.bi.repository;

import java.util.List;
import java.util.Optional;

import org.adra.app.bi.entity.Rol;
import org.adra.app.bi.entity.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SocioRepository extends JpaRepository<Socio, Integer>{
	
	// Listar
	@Query(value = "{call SP_LIST_TBL_SOCIO()}", nativeQuery = true) 
	List<Socio> listaSocios();
	
	
	// Buscar
	@Query(value = "{call SP_BUSCAR_TBL_SOCIO(:p_nIDSOC)}", nativeQuery = true) 
	Optional<Socio> buscarSocio(@Param("p_nIDSOC") int p_nIDSOC);
	
	
	// Insertar
	@Query(value = "{call  SP_INS_TBL_SOCIO(:p_nID_PERSONA,:p_nID_BANCO_COMUNAL, @V_ID)}", nativeQuery = true) 
	String insertarSocio(
			@Param("p_nID_PERSONA") int p_nID_PERSONA,
			@Param("p_nID_BANCO_COMUNAL") int p_nID_BANCO_COMUNAL);
			
	
	// Eliminar
	@Query(value = "{call SP_DEL_TBL_SOCIO(:p_nIDPRIV)}", nativeQuery = true) 
	String eliminarSocio(@Param("p_nIDPRIV") int p_nIDPRIV);
	
	
	// Actualizar
	@Query(value = "{call SP_UPD_TBL_SOCIO(:p_nID_PERSONA, :p_nID_BANCO_COMUNAL,  @V_OK)}", nativeQuery = true) 
	String actualizarSocio(
			@Param("p_nID_PERSONA") int p_nID_PERSONA,
			@Param("p_nID_BANCO_COMUNAL") int p_nID_BANCO_COMUNAL);
	
	@Query(value = "SELECT U.ID_USUARIO, (case when S.ID_SOCIO!=\"\" then \"Socio\" else \" \" end) AS SOCIO\r\n"
			+ "FROM TBL_USUARIO U JOIN TBL_SOCIO S \r\n"
			+ "ON U.ID_PERSONA = S.ID_PERSONA\r\n"
			+ "WHERE U.ID_USUARIO = ?", nativeQuery = true)
	List<Object> listarSocios(int id);
}
