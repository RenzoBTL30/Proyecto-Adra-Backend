package org.adra.app.bi.service;

import java.util.List;
import java.util.Map;

public interface ReporteService {
	List<Map<String, Object>> listarUsuariosActivos();
	List<Map<String, Object>> listarUsuariosRoles();
	List<Map<String, Object>> reporteProgresoModulo(int id);
	List<Map<String, Object>> reporteAsistenciaSeminario(int id);
	List<Map<String, Object>> listarSociosporBanco(int id);
	List<Map<String, Object>> reporteSatisfacModulos(int id);
}
