package org.adra.app.bi.controller;

import java.util.ArrayList;
import java.util.List;

import org.adra.app.bi.entity.Anuncio;
import org.adra.app.bi.serviceImpl.AnuncioServiceImpl;
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
@RequestMapping("/api/anuncios")
public class AnuncioController {
	
	@Autowired
	private AnuncioServiceImpl anuncioService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Anuncio>> getRecursos(){
		try {
			List<Anuncio> list = new ArrayList<>();
			list = anuncioService.readAll();
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
	public ResponseEntity<Anuncio> save(@RequestBody Anuncio anc){
		try {
			Anuncio an = anuncioService.create(anc);
			return new ResponseEntity<>(an, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<Anuncio> getRecurso(@PathVariable("id") int id){
		Anuncio anuncio = anuncioService.read(id);
			if(anuncio.getId()>0) {
				return new ResponseEntity<>(anuncio, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			anuncioService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Anuncio> update(@RequestBody Anuncio an, @PathVariable("id") int id){
		try {
			Anuncio ul = anuncioService.read(id);
			if (ul.getId()>0) {
				ul.setNo_anuncio(an.getNo_anuncio());
				ul.setDi_anuncio(an.getDi_anuncio());
				ul.setFe_inicio(an.getFe_inicio());
				ul.setFe_fin(an.getFe_fin());
				ul.setPersona(an.getPersona());
				return new ResponseEntity<>(anuncioService.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
