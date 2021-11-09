package org.adra.app.bi.controller;

import java.util.ArrayList;
import java.util.List;

import org.adra.app.bi.entity.Pedido_Oracion;
import org.adra.app.bi.serviceImpl.Pedido_OracionServiceImpl;
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
@RequestMapping("/api/pedidosoracion")
public class Pedido_OracionController {
	
	@Autowired
	private Pedido_OracionServiceImpl pedido_oracionService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Pedido_Oracion>> getPedido(){
		try {
			List<Pedido_Oracion> list = new ArrayList<>();
			list = pedido_oracionService.readAll();
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
	public ResponseEntity<Pedido_Oracion> save(@RequestBody Pedido_Oracion ped){
		try {
			Pedido_Oracion pe = pedido_oracionService.create(ped);
			return new ResponseEntity<>(pe, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/all/{id}")
	public ResponseEntity<Pedido_Oracion> getPedido(@PathVariable("id") int id){
			Pedido_Oracion pedido = pedido_oracionService.read(id);
			if(pedido.getId()>0) {
				return new ResponseEntity<>(pedido, HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			pedido_oracionService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Pedido_Oracion> update(@RequestBody Pedido_Oracion pe, @PathVariable("id") int id){
		try {
			Pedido_Oracion ul = pedido_oracionService.read(id);
			if (ul.getId()>0) {
				ul.setDe_pedido_oracion(pe.getDe_pedido_oracion());
				ul.setFe_creacion(pe.getFe_creacion());
				ul.setSocio(pe.getSocio());
				return new ResponseEntity<>(pedido_oracionService.create(ul),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
