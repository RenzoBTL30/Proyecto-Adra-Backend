package org.adra.app.bi.repository;

import java.util.List;
import java.util.Optional;

import org.adra.app.bi.entity.Capacitacion;
import org.adra.app.bi.entity.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CapacitacionRepository extends JpaRepository<Capacitacion, Integer>{
	
	// Listar
	@Query(value = "{call SP_LIST_TBL_CAPACITACION()}", nativeQuery = true) 
	List<Capacitacion> listaCapacitaciones();
	
	
	// Buscar
	@Query(value = "{call SP_BUSCAR_TBL_PREGUNTA(:p_nIDPREG)}", nativeQuery = true) 
	Optional<Capacitacion> buscarCapacitacion(@Param("p_nIDPREG") int p_nIDPREG);
	
	
	// Insertar
	@Query(value = "{call SP_INS_TBL_PREGUNTA(:p_vDE_PREGUNTA, :p_nID_RECURSO, @V_ID)}", nativeQuery = true) 
	String insertarCapacitacion(@Param("p_vDE_PREGUNTA") String p_vDE_PREGUNTA,
			@Param("p_nID_RECURSO") int p_nID_RECURSO);
	
	// Eliminar
	@Query(value = "{call SP_DEL_TBL_PREGUNTA(:p_nIDPREG)}", nativeQuery = true) 
	String eliminarPregunta(@Param("p_nIDPREG") int p_nIDPREG);
	
	
	// Actualizar
	@Query(value = "{call SP_UPD_TBL_PREGUNTA(:p_vDE_PREGUNTA, :p_nID_RECURSO, :p_nID_PREGUNTA, @V_OK)}", nativeQuery = true) 
	String actualizarPregunta(@Param("p_vDE_PREGUNTA") String p_vDE_PREGUNTA,
			@Param("p_nID_RECURSO") int p_nID_RECURSO, @Param("p_nID_PREGUNTA") int p_nID_PREGUNTA);
}
