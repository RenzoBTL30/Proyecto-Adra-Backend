package org.adra.app.bi.controller;

import java.util.ArrayList;
import java.util.List;

import org.adra.app.bi.entity.Usuario_rol;
import org.adra.app.bi.serviceImpl.Usuario_rolServiceImpl;
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
@RequestMapping("/api/usuariosrol")
public class Usuario_rolController {

	@Autowired
	private Usuario_rolServiceImpl usuario_rolService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Usuario_rol>> getUsuario_rol(){
		try {
			List<Usuario_rol> list = new ArrayList<>();
			list = usuario_rolService.readAll();
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
	public ResponseEntity<Usuario_rol> save(@RequestBody Usuario_rol usl){
		try {
			Usuario_rol urol = usuario_rolService.create(usl);
			return new ResponseEntity<>(urol, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<Usuario_rol> Usuario_rol(@PathVariable("id") int id){
		Usuario_rol usuario_rol = usuario_rolService.read(id);
			if(usuario_rol.getId()>0) {
				return new ResponseEntity<>(usuario_rol, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			usuario_rolService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Usuario_rol> update(@RequestBody Usuario_rol re, @PathVariable("id") int id){
		try {
			Usuario_rol ul = usuario_rolService.read(id);
			if (ul.getId()>0) {
				ul.setUsuario(re.getUsuario());
				ul.setRol(re.getRol());
				return new ResponseEntity<>(usuario_rolService.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

