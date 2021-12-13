package org.adra.app.bi.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.adra.app.bi.entity.Pedido_Oracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Pedido_OracionRepository extends JpaRepository<Pedido_Oracion, Integer>{
	
	// Listar
	@Query(value = "{call SP_LIST_TBL_PEDIDO_ORACION()}", nativeQuery = true) 
	List<Pedido_Oracion> listaPedido();
	
	
	// Buscar
	@Query(value = "{call SP_BUSCAR_TBL_PEDIDO_ORACION(:p_nIDTIPORA)}", nativeQuery = true) 
	Optional<Pedido_Oracion> buscarPedido(@Param("p_nIDTIPORA") int p_nIDTIPORA);
	
	
	// Insertar
	@Query(value = "{call SP_INS_TBL_PEDIDO_ORACION(:p_vDE_PEDIDO_ORACION, :p_nID_PERSONA, @V_ID)}", nativeQuery = true) 
	String insertarPedido(@Param("p_vDE_PEDIDO_ORACION") String p_vDE_PEDIDO_ORACION,
			@Param("p_nID_PERSONA") int p_nID_PERSONA);
	
	// Eliminar
	@Query(value = "{call SP_DEL_TBL_PEDIDO_ORACION(:p_nIDTIPORA)}", nativeQuery = true) 
	String eliminarPedido(@Param("p_nIDTIPORA") int p_nIDTIPORA);
	
	
	// Actualizar
	@Query(value = "{call SP_UPD_TBL_PEDIDO_ORACION(:p_vDE_PEDIDO_ORACION, :p_nID_PERSONA, :p_nID_PEDIDO_ORACION, @V_OK)}", nativeQuery = true) 
	String actualizarPedido(@Param("p_vDE_PEDIDO_ORACION") String p_vDE_PEDIDO_ORACION,
			@Param("p_nID_PERSONA") int p_nID_PERSONA, @Param("p_nID_PEDIDO_ORACION") int p_nID_PEDIDO_ORACION);
	
	@Query(value = "SELECT P.DE_PEDIDO_ORACION AS PEDIDO, P.FE_CREACION AS FECHA_CREACION, P.ID_SOCIO AS IDSOCIO, PP.NO_PERSONA AS NOMBRE, PP.AP_PATERNO AS APELLIDO_PATERNO\r\n"
			+ "FROM TBL_PEDIDO_ORACION P JOIN TBL_SOCIO S\r\n"
			+ "ON P.ID_SOCIO = S.ID_SOCIO\r\n"
			+ "JOIN TBL_BANCO_COMUNAL B\r\n"
			+ "ON B.ID_BANCO_COMUNAL = S.ID_BANCO_COMUNAL\r\n"
			+ "JOIN TBL_PERSONA PP\r\n"
			+ "ON PP.ID_PERSONA = S.ID_PERSONA\r\n"
			+ "JOIN TBL_PERSONA PPP\r\n"
			+ "ON PPP.ID_PERSONA = B.ID_PERSONA\r\n"
			+ "WHERE PPP.ID_PERSONA=?;", nativeQuery=true)
	List<Map<String, Object>> listarPedidosBancoAsesor(int id);
}
