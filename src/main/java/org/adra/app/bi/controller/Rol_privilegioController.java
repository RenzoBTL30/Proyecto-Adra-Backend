package org.adra.app.bi.controller;

import java.util.ArrayList;
import java.util.List;

import org.adra.app.bi.entity.Rol_privilegio;
import org.adra.app.bi.serviceImpl.Rol_privilegioServiceImpl;
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
@RequestMapping("/api/rolesprivilegio")
public class Rol_privilegioController {

	@Autowired
	private Rol_privilegioServiceImpl rol_privilegioService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Rol_privilegio>> getRol_privilegio(){
		try {
			List<Rol_privilegio> list = new ArrayList<>();
			list = rol_privilegioService.readAll();
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
	public ResponseEntity<Rol_privilegio> save(@RequestBody Rol_privilegio rolpr){
		try {
			Rol_privilegio rolp = rol_privilegioService.create(rolpr);
			return new ResponseEntity<>(rolp, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<Rol_privilegio> getRol_privilegio(@PathVariable("id") int id){
		Rol_privilegio rol_privilegio = rol_privilegioService.read(id);
			if(rol_privilegio.getId()>0) {
				return new ResponseEntity<>(rol_privilegio, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			rol_privilegioService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Rol_privilegio> update(@RequestBody Rol_privilegio re, @PathVariable("id") int id){
		try {
			Rol_privilegio ul = rol_privilegioService.read(id);
			if (ul.getId()>0) {
				ul.setRol(re.getRol());
				ul.setPrivilegio(re.getPrivilegio());
		
				return new ResponseEntity<>(rol_privilegioService.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

