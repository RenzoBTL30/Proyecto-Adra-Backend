package org.adra.app.bi.repository;

import java.util.List;
import java.util.Map;
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
				
				@Query(value = "SELECT distinct C.NO_CAPACITACION AS CAPACITACION, C.ID_CAPACITACION AS IDCAPACITACION\r\n"
						+ "FROM TBL_PERSONA P JOIN TBL_SOCIO S\r\n"
						+ "ON P.ID_PERSONA = S.ID_PERSONA\r\n"
						+ "JOIN TBL_AFILIACION A\r\n"
						+ "ON S.ID_SOCIO = A.ID_SOCIO\r\n"
						+ "JOIN TBL_CAPACITACION C\r\n"
						+ "ON C.ID_CAPACITACION = A.ID_CAPACITACION\r\n"
						+ "JOIN TBL_BANCO_COMUNAL B\r\n"
						+ "ON B.ID_BANCO_COMUNAL = S.ID_BANCO_COMUNAL\r\n"
						+ "JOIN TBL_PERSONA PP\r\n"
						+ "ON PP.ID_PERSONA = B.ID_PERSONA\r\n"
						+ "JOIN TBL_TIPO_CAPACITACION T\r\n"
						+ "ON T.ID_TIPO_CAPACITACION = C.ID_TIPO_CAPACITACION\r\n"
						+ "WHERE PP.ID_PERSONA = ? AND T.NO_TIPO_CAPACITACION = 'Modulo';", nativeQuery = true)
				List<Map<String, Object>> listaCapacAsesor(int id);
				
				
				@Query(value = "SELECT A.ID_AFILIACION AS ID_AFILIACION, S.ID_SOCIO AS ID_SOCIO ,P.NO_PERSONA AS NOMBRE, P.AP_PATERNO AS APELLIDO_PATERNO, P.AP_MATERNO AS APELLIDO_MATERNO, TRUNCATE((A.CA_RECURSOS_VISTOS/C.CA_RECURSOS),2)*100 AS PROGRESO\r\n"
						+ "FROM TBL_AFILIACION A JOIN TBL_SOCIO S\r\n"
						+ "ON A.ID_SOCIO = S.ID_SOCIO\r\n"
						+ "JOIN TBL_PERSONA P\r\n"
						+ "ON P.ID_PERSONA = S.ID_PERSONA\r\n"
						+ "JOIN TBL_CAPACITACION C\r\n"
						+ "ON C.ID_CAPACITACION = A.ID_CAPACITACION\r\n"
						+ "JOIN TBL_BANCO_COMUNAL B\r\n"
						+ "ON B.ID_BANCO_COMUNAL = S.ID_BANCO_COMUNAL\r\n"
						+ "JOIN TBL_PERSONA PP\r\n"
						+ "ON B.ID_PERSONA = PP.ID_PERSONA\r\n"
						+ "JOIN TBL_TIPO_CAPACITACION T\r\n"
						+ "ON T.ID_TIPO_CAPACITACION = C.ID_TIPO_CAPACITACION\r\n"
						+ "WHERE C.ID_CAPACITACION = ? AND PP.ID_PERSONA = ? AND T.NO_TIPO_CAPACITACION = 'Modulo';", nativeQuery = true)
				List<Map<String, Object>> listaSociosModuloAsesor(int id_capacitacion, int id_persona);
				
				
				@Query(value = "SELECT A.ID_AFILIACION AS ID_AFILIACION, SE.ID_SESION AS ID_SESION, SE.DE_TEMA AS TEMA, P.NO_PERSONA AS NOMBRE, P.AP_PATERNO AS APELLIDO_PATERNO, P.AP_MATERNO AS APELLIDO_MATERNO, TRUNCATE((SS.CA_RECURSOS_VISTOS/SE.CA_RECURSOS),2)*100 AS PROGRESO\r\n"
						+ "FROM TBL_AFILIACION A JOIN TBL_SOCIO S\r\n"
						+ "ON A.ID_SOCIO = S.ID_SOCIO\r\n"
						+ "JOIN TBL_PERSONA P\r\n"
						+ "ON P.ID_PERSONA = S.ID_PERSONA\r\n"
						+ "JOIN TBL_CAPACITACION C\r\n"
						+ "ON C.ID_CAPACITACION = A.ID_CAPACITACION\r\n"
						+ "JOIN TBL_BANCO_COMUNAL B\r\n"
						+ "ON B.ID_BANCO_COMUNAL = S.ID_BANCO_COMUNAL\r\n"
						+ "JOIN TBL_PERSONA PP\r\n"
						+ "ON B.ID_PERSONA = PP.ID_PERSONA\r\n"
						+ "JOIN TBL_TIPO_CAPACITACION T\r\n"
						+ "ON T.ID_TIPO_CAPACITACION = C.ID_TIPO_CAPACITACION\r\n"
						+ "JOIN TBL_SESION_SOCIO SS\r\n"
						+ "ON SS.ID_AFILIACION = A.ID_AFILIACION\r\n"
						+ "JOIN TBL_SESION SE\r\n"
						+ "ON SE.ID_SESION = SS.ID_SESION\r\n"
						+ "WHERE S.ID_SOCIO = ? AND C.ID_CAPACITACION = ? AND T.NO_TIPO_CAPACITACION = 'Modulo';", nativeQuery = true)
				List<Map<String, Object>> listaProgresoPorSesiones(int id_socio, int id_capacitacion);
				
				@Query(value = "SELECT CV.ID_AFILIACION AS ID_AFILIACION, SE.ID_SESION AS ID_SESION, P.NO_PERSONA AS NOMBRE, P.AP_PATERNO AS APELLIDO_PATERNO, P.AP_MATERNO AS APELLIDO_MATERNO, R.NO_RECURSO AS RECURSO, CV.ID_CONTROL_VISTA AS ID_CONTROL_VISTA,CV.ES_VISTO AS VISTO\r\n"
						+ "FROM TBL_SESION SE JOIN TBL_RECURSO R\r\n"
						+ "ON R.ID_SESION = SE.ID_SESION\r\n"
						+ "JOIN TBL_CONTROL_VISTA CV\r\n"
						+ "ON CV.ID_RECURSO = R.ID_RECURSO\r\n"
						+ "JOIN TBL_AFILIACION A\r\n"
						+ "ON A.ID_AFILIACION = CV.ID_AFILIACION\r\n"
						+ "JOIN TBL_SOCIO S\r\n"
						+ "ON S.ID_SOCIO = A.ID_SOCIO\r\n"
						+ "JOIN TBL_PERSONA P\r\n"
						+ "ON P.ID_PERSONA = S.ID_PERSONA\r\n"
						+ "WHERE S.ID_SOCIO = ? AND SE.ID_SESION = ?;", nativeQuery = true)
				List<Map<String, Object>> listaRecursos(int id_socio, int id_sesion);

}
