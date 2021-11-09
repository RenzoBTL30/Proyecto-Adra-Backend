package org.adra.app.bi.controller;

import java.util.ArrayList;
import java.util.List;

import org.adra.app.bi.entity.Tipo_Recurso;
import org.adra.app.bi.serviceImpl.Tipo_RecursoServiceImpl;
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
@RequestMapping("/api/tiposrecurso")
public class Tipo_RecursoController {
	
	@Autowired
	private Tipo_RecursoServiceImpl tipo_recursoService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Tipo_Recurso>> getTiposrecurso(){
		try {
			List<Tipo_Recurso> list = new ArrayList<>();
			list = tipo_recursoService.readAll();
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
	public ResponseEntity<Tipo_Recurso> save(@RequestBody Tipo_Recurso tip){
		try {
			Tipo_Recurso ti = tipo_recursoService.create(tip);
			return new ResponseEntity<>(ti, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<Tipo_Recurso> getTipoRecurso(@PathVariable("id") int id){
			Tipo_Recurso tiporec = tipo_recursoService.read(id);
			if(tiporec.getId()>0) {
				return new ResponseEntity<>(tiporec, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			tipo_recursoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Tipo_Recurso> update(@RequestBody Tipo_Recurso tip, @PathVariable("id") int id){
		try {
			Tipo_Recurso ul = tipo_recursoService.read(id);
			if (ul.getId()>0) {
				ul.setNo_tipo_recurso(tip.getNo_tipo_recurso());
				ul.setRecurso(tip.getRecurso());
				return new ResponseEntity<>(tipo_recursoService.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
