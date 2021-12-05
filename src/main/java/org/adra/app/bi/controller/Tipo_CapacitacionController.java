package org.adra.app.bi.controller;

import java.util.ArrayList;
import java.util.List;

import org.adra.app.bi.entity.Tipo_Capacitacion;
import org.adra.app.bi.serviceImpl.Tipo_CapacitacionServiceImpl;
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
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/tiposcapacitacion")
public class Tipo_CapacitacionController {

	@Autowired
	private Tipo_CapacitacionServiceImpl tipo_capacitacionService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Tipo_Capacitacion>> getRecursos(){
		try {
			List<Tipo_Capacitacion> list = new ArrayList<>();
			list = tipo_capacitacionService.readAll();
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
	public ResponseEntity<Tipo_Capacitacion> save(@RequestBody Tipo_Capacitacion rec){
		try {
			Tipo_Capacitacion ca = tipo_capacitacionService.create(rec);
			return new ResponseEntity<>(ca, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<Tipo_Capacitacion> getRecurso(@PathVariable("id") int id){
		Tipo_Capacitacion tipo_capacitacion = tipo_capacitacionService.read(id);
			if(tipo_capacitacion.getId()>0) {
				return new ResponseEntity<>(tipo_capacitacion, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			tipo_capacitacionService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Tipo_Capacitacion> update(@RequestBody Tipo_Capacitacion ca, @PathVariable("id") int id){
		try {
			Tipo_Capacitacion ul = tipo_capacitacionService.read(id);
			if (ul.getId()>0) {
				ul.setNo_tipo_capacitacion(ca.getNo_tipo_capacitacion());
				return new ResponseEntity<>(tipo_capacitacionService.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
