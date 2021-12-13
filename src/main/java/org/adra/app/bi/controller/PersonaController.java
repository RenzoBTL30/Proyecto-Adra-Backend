package org.adra.app.bi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

import org.adra.app.bi.entity.Persona;
import org.adra.app.bi.repository.PersonaRepository;
import org.adra.app.bi.serviceImpl.PersonaServiceImpl;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/personas")
public class PersonaController {

	@Autowired
	private PersonaServiceImpl personaService;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<Persona>> getPersona(){
		try {
			List<Persona> list = new ArrayList<>();
			list = personaService.readAll();
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
	public ResponseEntity<Persona> save(@RequestBody Persona per){
		try {
			Persona persona = personaService.create(per);
			return new ResponseEntity<>(persona, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/all/{id}")
	public ResponseEntity<Persona> getUser(@PathVariable("id") int id){
		Persona personas = personaService.read(id);
			if(personas.getId()>0) {
				return new ResponseEntity<>(personas, HttpStatus.OK);
			}else {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			personaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Persona> update(@RequestBody Persona pc, @PathVariable("id") int id){
		try {
			Persona p = personaService.read(id);
			if(p.getId()>0) {
				p.setNo_persona(pc.getNo_persona());
				p.setAp_paterno(pc.getAp_paterno());
				p.setAp_materno(pc.getAp_materno());
				p.setEm_correo_electronico(pc.getEm_correo_electronico());
				p.setNu_telefono(pc.getNu_telefono());
				return new ResponseEntity<>(personaService.create(p),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listaCapacAsesor/{id}")
	public ResponseEntity<List<Map<String, Object>>> listaCapacAsesor(@PathVariable("id") int id){
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			list = personaRepository.listaCapacAsesor(id);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listaSociosModuloAsesor/{idcap}/{idper}")
	public ResponseEntity<List<Map<String, Object>>> listaSociosModuloAsesor(@PathVariable("idcap") int idcap, @PathVariable("idper") int idper){
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			list = personaRepository.listaSociosModuloAsesor(idcap,idper);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listaProgresoPorSesiones/{idsoc}/{idcap}")
	public ResponseEntity<List<Map<String, Object>>> listaProgresoPorSesiones(@PathVariable("idsoc") int idsoc, @PathVariable("idcap") int idcap){
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			list = personaRepository.listaProgresoPorSesiones(idsoc,idcap);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listaRecursos/{idsoc}/{idses}")
	public ResponseEntity<List<Map<String, Object>>> listaRecursos(@PathVariable("idsoc") int idsoc, @PathVariable("idses") int idses){
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			list = personaRepository.listaRecursos(idsoc,idses);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
