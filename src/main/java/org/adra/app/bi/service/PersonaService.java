package org.adra.app.bi.service;

import java.util.List;

import org.adra.app.bi.entity.Persona;

public interface PersonaService {
	Persona create(Persona persona);
	List<Persona> readAll();
	Persona read(int id);
	void delete(int id);
	Persona update(Persona persona);
}
