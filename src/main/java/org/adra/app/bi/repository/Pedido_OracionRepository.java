package org.adra.app.bi.repository;

import java.util.Date;
import java.util.List;
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
}
