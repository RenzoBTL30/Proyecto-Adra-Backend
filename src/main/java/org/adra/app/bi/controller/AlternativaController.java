package org.adra.app.bi.controller;

import java.util.ArrayList;
import java.util.List;

import org.adra.app.bi.entity.Alternativa;
import org.adra.app.bi.serviceImpl.AlternativaServiceImpl;
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
@RequestMapping("/api/alternativas")
public class AlternativaController {
	
	@Autowired
	private AlternativaServiceImpl alternativaService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Alternativa>> getRecursos(){
		try {
			List<Alternativa> list = new ArrayList<>();
			list = alternativaService.readAll();
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
	public ResponseEntity<Alternativa> save(@RequestBody Alternativa rec){
		try {
			Alternativa ca = alternativaService.create(rec);
			return new ResponseEntity<>(ca, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<Alternativa> getRecurso(@PathVariable("id") int id){
		Alternativa alternativa = alternativaService.read(id);
			if(alternativa.getId()>0) {
				return new ResponseEntity<>(alternativa, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			alternativaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Alternativa> update(@RequestBody Alternativa ca, @PathVariable("id") int id){
		try {
			Alternativa ul = alternativaService.read(id);
			if (ul.getId()>0) {
				ul.setNo_alternativa(ca.getNo_alternativa());
				ul.setEs_alternativa_correcta(ca.getEs_alternativa_correcta());
				ul.setPregunta(ca.getPregunta());
				return new ResponseEntity<>(alternativaService.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
