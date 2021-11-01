package org.adra.app.bi.service;

import java.util.List;

import org.adra.app.bi.entity.Tipo_Recurso;

public interface Tipo_RecursoService {
	Tipo_Recurso create(Tipo_Recurso tipo_recurso);
	List<Tipo_Recurso> readAll();
	Tipo_Recurso read(int id);
	void delete(int id);
	Tipo_Recurso update(Tipo_Recurso tipo_recurso);
}
