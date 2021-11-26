package org.adra.app.bi.controller;

import java.util.ArrayList;
import java.util.List;

import org.adra.app.bi.entity.Banco_Comunal;
import org.adra.app.bi.serviceImpl.Banco_ComunalServiceImpl;
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
@RequestMapping("/api/bancoscomunales")
public class Banco_ComunalController {
	
	@Autowired
	private Banco_ComunalServiceImpl banco_ComunalService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Banco_Comunal>> getRecursos(){
		try {
			List<Banco_Comunal> list = new ArrayList<>();
			list = banco_ComunalService.readAll();
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
	public ResponseEntity<Banco_Comunal> save(@RequestBody Banco_Comunal rec){
		try {
			Banco_Comunal bc = banco_ComunalService.create(rec);
			return new ResponseEntity<>(bc, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<Banco_Comunal> getRecurso(@PathVariable("id") int id){
		Banco_Comunal banco = banco_ComunalService.read(id);
			if(banco.getId()>0) {
				return new ResponseEntity<>(banco, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			banco_ComunalService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Banco_Comunal> update(@RequestBody Banco_Comunal bc, @PathVariable("id") int id){
		try {
			Banco_Comunal ul = banco_ComunalService.read(id);
			if (ul.getId()>0) {
				ul.setNo_banco_comunal(bc.getNo_banco_comunal());
				ul.setEs_banco_comunal(bc.getEs_banco_comunal());
				return new ResponseEntity<>(banco_ComunalService.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
