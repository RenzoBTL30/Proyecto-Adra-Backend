package org.adra.app.bi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.adra.app.bi.entity.Capacitacion;
import org.adra.app.bi.repository.CapacitacionRepository;
import org.adra.app.bi.serviceImpl.CapacitacionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/capacitaciones")
public class CapacitacionController {
	
	@Autowired
	private CapacitacionServiceImpl capacitacionService;
	
	@Autowired
	private CapacitacionRepository capacitacionRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Capacitacion>> getRecursos(){
		try {
			List<Capacitacion> list = new ArrayList<>();
			list = capacitacionService.readAll();
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/post")
	public ResponseEntity<Capacitacion> save(@RequestBody Capacitacion rec){
		try {
			Capacitacion ca = capacitacionService.create(rec);
			return new ResponseEntity<>(ca, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<Capacitacion> getRecurso(@PathVariable("id") int id){
		Capacitacion capacitacion = capacitacionService.read(id);
			if(capacitacion.getId()>0) {
				return new ResponseEntity<>(capacitacion, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	/*
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			capacitacionService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Capacitacion> update(@RequestBody Capacitacion ca, @PathVariable("id") int id){
		try {
			Capacitacion ul = capacitacionService.read(id);
			if (ul.getId()>0) {
				ul.setNo_capacitacion(ca.getNo_capacitacion());
				ul.setDe_capacitacion(ca.getDe_capacitacion());
				ul.setCa_recursos(ca.getCa_recursos());
				ul.setEs_capacitacion(ca.getEs_capacitacion());
				ul.setTipo_capacitacion(ca.getTipo_capacitacion());
				return new ResponseEntity<>(capacitacionService.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/delete/{id}")
	public ResponseEntity<Capacitacion> delete(@RequestBody Capacitacion ca, @PathVariable("id") int id){
		try {
			Capacitacion ul = capacitacionService.read(id);
			if (ul.getId()>0) {
				ul.setEs_capacitacion('0');
				return new ResponseEntity<>(capacitacionService.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/deleteSem/{id}")
	public ResponseEntity<Capacitacion> deleteSem(@RequestBody Capacitacion ca, @PathVariable("id") int id){
		try {
			Capacitacion ul = capacitacionService.read(id);
			if (ul.getId()>0) {
				ul.setEs_capacitacion('0');
				return new ResponseEntity<>(capacitacionService.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*
	@DeleteMapping("")
	public String eliminarCapacitaciones(@RequestParam int id) {
		try {
			String resultado;
			resultado = capacitacionService.eliminarCapacitaciones(id);
			return resultado; 
		} catch (Exception e) {
			// TODO: handle exception
			return resultado;
		}
	}*/
	
	@GetMapping("/list")
	public ResponseEntity<List<Map<String, Object>>> listar(){
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			list = capacitacionRepository.listarSeminarios();
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
