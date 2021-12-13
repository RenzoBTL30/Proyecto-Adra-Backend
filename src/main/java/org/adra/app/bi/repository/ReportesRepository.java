package org.adra.app.bi.repository;

import java.util.List;
import java.util.Map;

import org.adra.app.bi.entity.Capacitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportesRepository extends JpaRepository<Capacitacion, Integer>{
	
	// Reporte 1
	@Query(value = "SELECT P.NO_PERSONA AS NOMBRE, P.AP_PATERNO AS APELLIDO_PATERNO, U.NU_DNI AS DNI, U.ES_USUARIO AS ESTADO\r\n"
			+ "FROM TBL_USUARIO U JOIN TBL_PERSONA P\r\n"
			+ "ON U.ID_PERSONA = P.ID_PERSONA\r\n"
			+ "WHERE U.ES_USUARIO =1;", nativeQuery = true)
	List<Map<String, Object>> listarUsuariosActivos();
	
	// Reporte 2
	@Query(value = "SELECT P.NO_PERSONA AS NOMBRE,P.AP_PATERNO AS APELLIDO_PATERNO, U.NU_DNI AS DNI, R.NO_ROL AS ROL\r\n"
			+ "FROM TBL_USUARIO_ROL UR JOIN TBL_USUARIO U \r\n"
			+ "ON UR.ID_USUARIO = U.ID_USUARIO\r\n"
			+ "JOIN TBL_ROL R\r\n"
			+ "ON R.ID_ROL = UR.ID_ROL\r\n"
			+ "JOIN TBL_PERSONA P\r\n"
			+ "ON P.ID_PERSONA = U.ID_PERSONA;", nativeQuery = true)
	List<Map<String, Object>> listarUsuariosRoles();
	
	
	// Reporte 3
	@Query(value = "SELECT C.NO_CAPACITACION AS CAPACITACION, P.NO_PERSONA AS NOMBRE, P.AP_PATERNO AS APELLIDO_PATERNO, A.CA_RECURSOS_VISTOS AS RECURSOS_VISTOS, C.CA_RECURSOS AS TOTAL_RECURSOS, TRUNCATE((A.CA_RECURSOS_VISTOS/C.CA_RECURSOS),2)*100 AS PROGRESO\r\n"
			+ "		FROM TBL_CAPACITACION C JOIN TBL_AFILIACION A\r\n"
			+ "		ON C.ID_CAPACITACION = A.ID_CAPACITACION\r\n"
			+ "		JOIN TBL_SOCIO S\r\n"
			+ "		ON S.ID_SOCIO = A.ID_SOCIO\r\n"
			+ "		JOIN TBL_PERSONA P\r\n"
			+ "		ON S.ID_PERSONA = P.ID_PERSONA\r\n"
			+ "     JOIN TBL_TIPO_CAPACITACION TC\r\n"
			+ "     ON TC.ID_TIPO_CAPACITACION = C.ID_TIPO_CAPACITACION\r\n"
			+ "     WHERE S.ID_BANCO_COMUNAL = ? AND TC.NO_TIPO_CAPACITACION = 'Modulo';", nativeQuery = true)
	List<Map<String,Object>> reporteProgresoModulo(int id);
	
	
	// Reporte 3 otro (---revisar porque no funciona---) (al momento de mandarlo al ReporteController en la línea 54, devuelve un error 500 al probarlo en el Postman)
	/*
	@Query(value = "SELECT C.NO_CAPACITACION AS NOMBRE, P.NO_PERSONA AS PERSONA, A.CA_RECURSOS_VISTOS AS RECURSOS_VISTOS, C.CA_RECURSOS AS TOTAL_RECURSOS, TRUNCATE((A.CA_RECURSOS_VISTOS/C.CA_RECURSOS),2) AS PROGRESO\r\n"
			+ "		FROM TBL_CAPACITACION C JOIN TBL_AFILIACION A\r\n"
			+ "		ON C.ID_CAPACITACION = A.ID_CAPACITACION\r\n"
			+ "		JOIN TBL_SOCIO S\r\n"
			+ "		ON S.ID_SOCIO = A.ID_SOCIO\r\n"
			+ "		JOIN TBL_PERSONA P\r\n"
			+ "		ON S.ID_PERSONA = P.ID_PERSONA\r\n"
			+ "     WHERE S.ID_BANCO_COMUNAL = :id_banco_comunal;", nativeQuery = true)
	List<Map<String,Object>> reporteProgresoModulo(@Param("id_banco_comunal") int id);*/
	
	
	
	// Reporte 4
	@Query(value = "SELECT P.NO_PERSONA AS Nombre, P.AP_PATERNO AS Apellido_Paterno, CA.NO_CAPACITACION AS Seminario, CV.DE_COMENTARIO AS Comentario, SS.NU_VALORACION AS Valoracion\r\n"
			+ "FROM TBL_SESION_SOCIO SS \r\n"
			+ "JOIN TBL_AFILIACION A \r\n"
			+ "ON SS.ID_AFILIACION = A.ID_AFILIACION\r\n"
			+ "JOIN TBL_SOCIO S\r\n"
			+ "ON S.ID_SOCIO = A.ID_SOCIO\r\n"
			+ "JOIN TBL_PERSONA P\r\n"
			+ "ON P.ID_PERSONA = S.ID_PERSONA\r\n"
			+ "JOIN TBL_CONTROL_VISTA CV\r\n"
			+ "ON CV.ID_AFILIACION = A.ID_AFILIACION\r\n"
			+ "JOIN TBL_CAPACITACION CA\r\n"
			+ "ON CA.ID_CAPACITACION = A.ID_CAPACITACION\r\n"
			+ "WHERE S.ID_BANCO_COMUNAL = ? AND CA.ID_TIPO_CAPACITACION=2;", nativeQuery = true)
	List<Map<String,Object>> reporteAsistenciaSeminario(int id);
	
	// Reporte 5
	@Query(value = "SELECT P.NO_PERSONA AS Nombre, P.AP_PATERNO AS Apellido_Paterno, P.AP_MATERNO AS Apellido_Materno, P.EM_CORREO_ELECTRONICO AS Correo_Electronico, P.NU_TELEFONO AS Telefono, B.NO_BANCO_COMUNAL AS Banco_Comunal, PP.NO_PERSONA AS Asesor\r\n"
			+ "FROM tbl_socio S JOIN TBL_PERSONA P \r\n"
			+ "ON S.ID_PERSONA=P.ID_PERSONA\r\n"
			+ "JOIN tbl_banco_comunal B\r\n"
			+ "ON B.ID_BANCO_COMUNAL=S.ID_BANCO_COMUNAL \r\n"
			+ "JOIN TBL_PERSONA PP\r\n"
			+ "ON B.ID_PERSONA=PP.ID_PERSONA\r\n"
			+ "WHERE B.ID_BANCO_COMUNAL = ?;", nativeQuery = true)
	List<Map<String, Object>> listarSociosporBanco(int id);

	
	// Reporte 6
	@Query(value = "select c.no_capacitacion AS Capacitacion, ROUND(AVG(ss.nu_valoracion)) AS Valoracion,  b.no_banco_comunal AS Banco_Comunal\r\n"
			+ "from tbl_sesion_socio ss join tbl_sesion s \r\n"
			+ "on ss.id_sesion = s.id_sesion\r\n"
			+ "join tbl_capacitacion c \r\n"
			+ "on c.id_capacitacion = s.id_capacitacion \r\n"
			+ "join tbl_afiliacion a\r\n"
			+ "on a.id_afiliacion = ss.id_afiliacion\r\n"
			+ "join tbl_socio so\r\n"
			+ "on so.id_socio = a.id_socio\r\n"
			+ "join tbl_banco_comunal b\r\n"
			+ "on b.id_banco_comunal = so.id_banco_comunal\r\n"
			+ "where b.id_banco_comunal = ?\r\n"
			+ "group by c.no_capacitacion;", nativeQuery = true)
	List<Map<String, Object>> reporteSatisfacModulos(int id);
	

}
