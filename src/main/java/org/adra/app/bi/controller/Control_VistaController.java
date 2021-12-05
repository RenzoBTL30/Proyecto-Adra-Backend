package org.adra.app.bi.controller;

import java.util.ArrayList;
import java.util.List;

import org.adra.app.bi.entity.Control_Vista;
import org.adra.app.bi.serviceImpl.Control_VistaServiceImpl;
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
@RequestMapping("/api/controlvistas")
public class Control_VistaController {

	@Autowired
	private Control_VistaServiceImpl control_vistaService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Control_Vista>> getRecursos(){
		try {
			List<Control_Vista> list = new ArrayList<>();
			list = control_vistaService.readAll();
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
	public ResponseEntity<Control_Vista> save(@RequestBody Control_Vista rec){
		try {
			Control_Vista ca = control_vistaService.create(rec);
			return new ResponseEntity<>(ca, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<Control_Vista> getRecurso(@PathVariable("id") int id){
		Control_Vista control_vista = control_vistaService.read(id);
			if(control_vista.getId()>0) {
				return new ResponseEntity<>(control_vista, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			control_vistaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Control_Vista> update(@RequestBody Control_Vista ca, @PathVariable("id") int id){
		try {
			Control_Vista ul = control_vistaService.read(id);
			if (ul.getId()>0) {
				ul.setDe_comentario(ca.getDe_comentario());
				ul.setEs_visto(ca.getEs_visto());
				ul.setRecurso(ca.getRecurso());
				ul.setAfiliacion(ca.getAfiliacion());
				return new ResponseEntity<>(control_vistaService.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
