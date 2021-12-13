package org.adra.app.bi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.adra.app.bi.repository.ReportesRepository;
import org.adra.app.bi.serviceImpl.ReporteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/reportes")
public class ReporteController {
	
	@Autowired
	private ReporteServiceImpl reporteService;
	
	@Autowired
	private ReportesRepository reporteRepository;
	
	@GetMapping("/listarUserAct")
	public ResponseEntity<List<Map<String, Object>>> listarUserAct(){
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			list = reporteService.listarUsuariosActivos();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listarUserRol")
	public ResponseEntity<List<Map<String, Object>>> listarUserRol(){
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			list = reporteService.listarUsuariosRoles();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/reporteProgMod/{id}")
	public ResponseEntity<List<Map<String,Object>>> reporteProgMod(@PathVariable("id") int id){
		try {
			List<Map<String,Object>> list = new ArrayList<>();
			list = reporteService.reporteProgresoModulo(id);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/reporteAsistSem/{id}")
	public ResponseEntity<List<Map<String, Object>>> reporteAsistSem(@PathVariable("id") int id){
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			list = reporteService.reporteAsistenciaSeminario(id);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listarSociosBanco/{id}")
	public ResponseEntity<List<Map<String, Object>>> listarSociosBanco(@PathVariable("id") int id){
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			list = reporteService.listarSociosporBanco(id);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/reporteSatisfacMod/{id}")
	public ResponseEntity<List<Map<String, Object>>> reporteSatisfacMod(@PathVariable("id") int id){
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			list = reporteService.reporteSatisfacModulos(id);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
