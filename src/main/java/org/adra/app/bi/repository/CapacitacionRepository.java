package org.adra.app.bi.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.adra.app.bi.entity.Capacitacion;
import org.adra.app.bi.entity.Rol;
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
	
	
	@Query(value = "SELECT C.ID_CAPACITACION AS Id_cap, C.NO_CAPACITACION AS Nombre, S.ID_SESION AS Id_ses, S.DE_TEMA AS Tema, S.FE_INICIO AS FechaInicio, S.FE_FIN AS FechaFin, R.ID_RECURSO AS Id_rec, R.DI_URL AS Direccion\r\n"
			+ "FROM TBL_CAPACITACION C JOIN TBL_SESION S\r\n"
			+ "ON C.ID_CAPACITACION = S.ID_CAPACITACION\r\n"
			+ "JOIN TBL_RECURSO R\r\n"
			+ "ON S.ID_SESION = R.ID_SESION\r\n"
			+ "WHERE C.ID_TIPO_CAPACITACION = 2 AND C.ES_CAPACITACION = 1;", nativeQuery = true)
	List<Map<String, Object>> listarSeminarios();
	
	
}
