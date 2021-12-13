package org.adra.app.bi.controller;

import java.util.ArrayList;
import java.util.List;

import org.adra.app.bi.entity.Afiliacion;
import org.adra.app.bi.repository.AfiliacionRepository;
import org.adra.app.bi.serviceImpl.AfiliacionServiceImpl;
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
@RequestMapping("/api/afiliaciones")
public class AfiliacionController {
	
	@Autowired
	private AfiliacionServiceImpl afiliacionService;
	
	@Autowired
	private AfiliacionRepository afiliacionRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Afiliacion>> getRecursos(){
		try {
			List<Afiliacion> list = new ArrayList<>();
			list = afiliacionService.readAll();
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
	public ResponseEntity<Afiliacion> save(@RequestBody Afiliacion rec){
		try {
			Afiliacion ca = afiliacionService.create(rec);
			return new ResponseEntity<>(ca, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<Afiliacion> getRecurso(@PathVariable("id") int id){
		Afiliacion afiliacion = afiliacionService.read(id);
			if(afiliacion.getId()>0) {
				return new ResponseEntity<>(afiliacion, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			afiliacionService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Afiliacion> update(@RequestBody Afiliacion ca, @PathVariable("id") int id){
		try {
			Afiliacion ul = afiliacionService.read(id);
			if (ul.getId()>0) {
				ul.setCa_recursos_vistos(ca.getCa_recursos_vistos());
				ul.setSocio(ca.getSocio());
				ul.setCapacitacion(ca.getCapacitacion());
				return new ResponseEntity<>(afiliacionService.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/asignar/{idcap}/{idbanc}")
	public String asignar(@PathVariable("idcap") String idcap, @PathVariable("idbanc") String idbanc ){
		try {
			String res = afiliacionService.asignarAfiliacion(idcap, idbanc);
			return res;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
}