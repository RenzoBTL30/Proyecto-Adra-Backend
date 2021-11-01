package org.adra.app.bi.service;

import java.util.List;

import org.adra.app.bi.entity.Recurso;

public interface RecursoService {
	Recurso create(Recurso recurso);
	List<Recurso> readAll();
	Recurso read(int id);
	void delete(int id);
	Recurso update(Recurso recurso);
}
