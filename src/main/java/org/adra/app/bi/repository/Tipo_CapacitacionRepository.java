package org.adra.app.bi.repository;

import java.util.List;
import java.util.Optional;

import org.adra.app.bi.entity.Tipo_Capacitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Tipo_CapacitacionRepository extends JpaRepository<Tipo_Capacitacion, Integer>{
	// Listar
	@Query(value = "{call SP_LIST_TBL_TIPO_CAPACITACION()}", nativeQuery = true) 
	List<Tipo_Capacitacion> listarTipo_Capacitacion();
	
	
	// Buscar
	@Query(value = "{call SP_BUSCAR_TBL_TIPO_CAPACITACION(:p_nIDTIPCAP)}", nativeQuery = true) 
	Optional<Tipo_Capacitacion> buscarTipo_Capacitacion(@Param("p_nIDTIPCAP") int p_nIDTIPCAP);
	
	
	// Insertar
	@Query(value = "{call SP_INS_TBL_TIPO_CAPACITACION(:p_vNO_TIPO_CAPACITACION, @V_ID)}", nativeQuery = true) 
			String insertarTipo_Capacitacion(@Param("p_vNO_TIPO_CAPACITACION") String p_vNO_TIPO_CAPACITACION);
	
	// Eliminar
	@Query(value = "{call SP_DEL_TBL_TIPO_CAPACITACION(:p_nIDTIPCAP)}", nativeQuery = true) 
	String eliminarTipo_Capacitacion(@Param("p_nIDTIPCAP") int p_nIDTIPCAP);
	
	
	// Actualizar
	@Query(value = "{call SP_UPD_TBL_TIPO_CAPACITACION(:p_vNO_TIPO_CAPACITACION, :p_nID_TIPO_CAPACITACION, @V_OK)}", nativeQuery = true) 
	String insertarTipo_Capacitacion(@Param("p_vNO_TIPO_CAPACITACION") String p_vNO_TIPO_CAPACITACION,
			@Param("p_nID_TIPO_CAPACITACION") int p_nID_TIPO_CAPACITACION);
}
