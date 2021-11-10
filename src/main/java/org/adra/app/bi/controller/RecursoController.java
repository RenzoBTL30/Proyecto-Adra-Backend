package org.adra.app.bi.controller;

import java.util.ArrayList;
import java.util.List;

import org.adra.app.bi.entity.Recurso;
import org.adra.app.bi.serviceImpl.RecursoServiceImpl;
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
@CrossOrigin(origins="*")
@RequestMapping("/api/recursos")
public class RecursoController {
	
	@Autowired
	private RecursoServiceImpl recursoService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Recurso>> getRecursos(){
		try {
			List<Recurso> list = new ArrayList<>();
			list = recursoService.readAll();
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
	public ResponseEntity<Recurso> save(@RequestBody Recurso rec){
		try {
			Recurso re = recursoService.create(rec);
			return new ResponseEntity<>(re, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<Recurso> getRecurso(@PathVariable("id") int id){
			Recurso recurso = recursoService.read(id);
			if(recurso.getId()>0) {
				return new ResponseEntity<>(recurso, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			recursoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Recurso> update(@RequestBody Recurso re, @PathVariable("id") int id){
		try {
			Recurso ul = recursoService.read(id);
			if (ul.getId()>0) {
				ul.setNo_recurso(re.getNo_recurso());
				ul.setNu_orden(re.getNu_orden());
				ul.setDi_url(re.getDi_url());
				ul.setSesion(re.getSesion());
				ul.setTipo_recurso(re.getTipo_recurso());
				return new ResponseEntity<>(recursoService.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
