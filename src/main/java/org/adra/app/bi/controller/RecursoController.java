package org.adra.app.bi.controller;

import java.util.ArrayList;
import java.util.List;

import org.adra.app.bi.entity.Recurso;
import org.adra.app.bi.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/recursos")
public class RecursoController {
	@Autowired
	private RecursoService recursoService;
	@GetMapping("/all")
	public ResponseEntity<List<Recurso>> getAlumnos(){
		try {
			List<Recurso> list = new ArrayList<>();
			list = recursoService.readAll();
			if(list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
