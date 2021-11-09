package org.adra.app.bi.repository;

import java.util.List;
import java.util.Optional;

import org.adra.app.bi.entity.Privilegio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegioRepository extends JpaRepository<Privilegio, Integer>{
				// Listar
				@Query(value = "{call SP_LIST_TBL_PRIVILEGIO()}", nativeQuery = true) 
				List<Privilegio> listaPrivilegio();
				
				
				// Buscar
				@Query(value = "{call SP_BUSCAR_TBL_PRIVILEGIO(:p_nIDPRIV)}", nativeQuery = true) 
				Optional<Privilegio> buscarPrivilegio(@Param("p_nIDPRIV") int p_nIDPRIV);
				
				
				// Insertar
				@Query(value = "{call SP_INS_TBL_PRIVILEGIO(:p_vNO_PRIVILEGIO, @V_ID)}", nativeQuery = true) 
				String insertarPrivilegio(
						@Param("p_vNO_PRIVILEGIO") String p_vNO_PRIVILEGIO);
				
				// Eliminar
				@Query(value = "{call SP_DEL_TBL_PRIVILEGIO(:p_nIDPRIV)}", nativeQuery = true) 
				String eliminarPrivilegio(@Param("p_nIDPRIV") int p_nIDPRIV);
				
				
				// Actualizar
				@Query(value = "{call SP_UPD_TBL_PRIVILEGIO(:p_vNO_PRIVILEGIO, :p_nID_PRIVILEGIO, @V_OK)}", nativeQuery = true) 
				String actualizarPrivilegio(
						@Param("p_vNO_PRIVILEGIO") String p_vNO_PRIVILEGIO,
						@Param("p_nID_PRIVILEGIO") int p_nID_PRIVILEGIO);
}
