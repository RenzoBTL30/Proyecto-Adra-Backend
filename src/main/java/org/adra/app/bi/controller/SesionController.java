package org.adra.app.bi.controller;

import java.util.ArrayList;
import java.util.List;

import org.adra.app.bi.entity.Capacitacion;
import org.adra.app.bi.entity.Sesion;
import org.adra.app.bi.serviceImpl.SesionServiceImpl;
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
@RequestMapping("/api/sesiones")
public class SesionController {
	
	@Autowired
	private SesionServiceImpl sesionService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Sesion>> getRecursos(){
		try {
			List<Sesion> list = new ArrayList<>();
			list = sesionService.readAll();
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
	public ResponseEntity<Sesion> save(@RequestBody Sesion ses){
		try {
			Sesion se = sesionService.create(ses);
			return new ResponseEntity<>(se, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<Sesion> getRecurso(@PathVariable("id") int id){
		Sesion sesion = sesionService.read(id);
			if(sesion.getId()>0) {
				return new ResponseEntity<>(sesion, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	/*
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			sesionService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Sesion> update(@RequestBody Sesion ca, @PathVariable("id") int id){
		try {
			Sesion ul = sesionService.read(id);
			if (ul.getId()>0) {
				ul.setDe_tema(ca.getDe_tema());
				ul.setFe_inicio(ca.getFe_inicio());
				ul.setFe_fin(ca.getFe_fin());
				ul.setCapacitacion(ca.getCapacitacion());
				return new ResponseEntity<>(sesionService.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/delete/{id}")
	public ResponseEntity<Sesion> delete(@RequestBody Sesion ca, @PathVariable("id") int id){
		try {
			Sesion ul = sesionService.read(id);
			if (ul.getId()>0) {
				ul.setEs_sesion('0');
				return new ResponseEntity<>(sesionService.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
