package org.adra.app.bi.serviceImpl;

import java.util.List;
import java.util.Map;

import org.adra.app.bi.repository.ReportesRepository;
import org.adra.app.bi.service.ReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporteServiceImpl implements ReporteService {

	@Autowired
	private ReportesRepository reporteRepository;
	
	@Override
	public List<Map<String, Object>> listarUsuariosActivos() {
		// TODO Auto-generated method stub
		return reporteRepository.listarUsuariosActivos();
	}

	@Override
	public List<Map<String, Object>> listarUsuariosRoles() {
		// TODO Auto-generated method stub
		return reporteRepository.listarUsuariosRoles();
	}

	@Override
	public List<Map<String, Object>> reporteProgresoModulo(int id) {
		// TODO Auto-generated method stub
		return reporteRepository.reporteProgresoModulo(id);
	}

	@Override
	public List<Map<String, Object>> reporteAsistenciaSeminario(int id) {
		// TODO Auto-generated method stub
		return reporteRepository.reporteAsistenciaSeminario(id);
	}

	@Override
	public List<Map<String, Object>> listarSociosporBanco(int id) {
		// TODO Auto-generated method stub
		return reporteRepository.listarSociosporBanco(id);
	}

	@Override
	public List<Map<String, Object>> reporteSatisfacModulos(int id) {
		// TODO Auto-generated method stub
		return reporteRepository.reporteSatisfacModulos(id);
	}

}
