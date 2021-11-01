package org.adra.app.bi.service;

import java.util.List;

import org.adra.app.bi.entity.Pregunta;

public interface PreguntaService {
	Pregunta create(Pregunta pregunta);
	List<Pregunta> readAll();
	Pregunta read(int id);
	void delete(int id);
	Pregunta update(Pregunta pregunta);
}
