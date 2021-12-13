package org.adra.app.bi.controller;

import java.util.ArrayList;
import java.util.List;

import org.adra.app.bi.entity.Sesion_socio;
import org.adra.app.bi.serviceImpl.Sesion_socioServiceImpl;
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
@RequestMapping("/api/sesionsocios")
public class Sesion_socioController {
	
	@Autowired
	private Sesion_socioServiceImpl sesion_socioService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Sesion_socio>> getRecursos(){
		try {
			List<Sesion_socio> list = new ArrayList<>();
			list = sesion_socioService.readAll();
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
	public ResponseEntity<Sesion_socio> save(@RequestBody Sesion_socio rec){
		try {
			Sesion_socio ca = sesion_socioService.create(rec);
			return new ResponseEntity<>(ca, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<Sesion_socio> getRecurso(@PathVariable("id") int id){
		Sesion_socio sesion_socio = sesion_socioService.read(id);
			if(sesion_socio.getId()>0) {
				return new ResponseEntity<>(sesion_socio, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			sesion_socioService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Sesion_socio> update(@RequestBody Sesion_socio ca, @PathVariable("id") int id){
		try {
			Sesion_socio ul = sesion_socioService.read(id);
			if (ul.getId()>0) {
				ul.setNu_valoracion(ca.getNu_valoracion());
				ul.setCa_recursos_vistos(ca.getCa_recursos_vistos());
				ul.setSesion(ca.getSesion());
				ul.setAfiliacion(ca.getAfiliacion());
				return new ResponseEntity<>(sesion_socioService.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/updatevaloracion/{idafil}/{idses}/{nuvalor}/{coment}")
	public String actualizarVisto(@PathVariable("idafil") int idafil, @PathVariable("idses") int idses, @PathVariable("nuvalor") int nuvalor, @PathVariable("coment") String coment ){
		try {
			String result = sesion_socioService.actualizarValoracion(idafil, idses, nuvalor, coment);
			return result;
		} catch (Exception e) {
			return null;
		}
	}
}
