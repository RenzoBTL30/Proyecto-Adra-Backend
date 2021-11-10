package org.adra.app.bi.controller;

import java.util.ArrayList;
import java.util.List;

import org.adra.app.bi.entity.Capacitacion;
import org.adra.app.bi.serviceImpl.CapacitacionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/capacitaciones")
public class CapacitacionController {
	
	@Autowired
	private CapacitacionServiceImpl capacitacionService;
	
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
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			capacitacionService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
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
}
