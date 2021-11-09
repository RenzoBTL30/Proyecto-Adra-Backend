package org.adra.app.bi.repository;

import java.util.List;
import java.util.Optional;

import org.adra.app.bi.entity.Capacitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CapacitacionRepository extends JpaRepository<Capacitacion, Integer>{
	
	// Listar
	@Query(value = "{call SP_LIST_TBL_CAPACITACION()}", nativeQuery = true) 
	List<Capacitacion> listaCapacitacions();
	
	
	// Buscar
	@Query(value = "{call SP_BUSCAR_TBL_CAPACITACION(:p_nIDCAP)}", nativeQuery = true) 
	Optional<Capacitacion> buscarCapacitacion(@Param("p_nIDCAP") int p_nIDCAP);
	
	
	// Insertar
	@Query(value = "{call SP_INS_TBL_CAPACITACION(:p_vNO_CAPACITACION, :p_vDE_CAPACITACION, :p_nCA_RECURSOS, :p_nID_TIPO_CAPACITACION, @V_ID)}", nativeQuery = true) 
	String insertarCapacitacion(
			@Param("p_vNO_CAPACITACION") String p_vNO_CAPACITACION, 
			@Param("p_vDE_CAPACITACION") String p_vDE_CAPACITACION, 
			@Param("p_nCA_RECURSOS") int p_nCA_RECURSOS,
			@Param("p_nID_TIPO_CAPACITACION") int p_nID_TIPO_CAPACITACION);
	
	// Eliminar
	@Query(value = "{call SP_DEL_TBL_CAPACITACION(:p_nIDCAP)}", nativeQuery = true) 
	String eliminarCapacitacion(@Param("p_nIDCAP") int p_nIDCAP);
	
	
	// Actualizar
	@Query(value = "{call SP_UPD_TBL_PREGUNTA(:p_vNO_CAPACITACION, :p_vDE_CAPACITACION, :p_nCA_RECURSOS, :p_nID_TIPO_CAPACITACION, :p_nID_CAPACITACION, @V_OK)}", nativeQuery = true) 
	String actualizarCapacitacion(
			@Param("p_vNO_CAPACITACION") String p_vNO_CAPACITACION, 
			@Param("p_vDE_CAPACITACION") String p_vDE_CAPACITACION, 
			@Param("p_nCA_RECURSOS") int p_nCA_RECURSOS,
			@Param("p_nID_TIPO_CAPACITACION") int p_nID_TIPO_CAPACITACION,
			@Param("p_nID_CAPACITACION") int p_nID_CAPACITACION);
	
}
