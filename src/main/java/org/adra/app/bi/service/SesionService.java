package org.adra.app.bi.service;

import java.util.List;

import org.adra.app.bi.entity.Sesion;

public interface SesionService {
	Sesion create(Sesion sesion);
	List<Sesion> readAll();
	Sesion read(int id);
	void delete(int id);
	Sesion update(Sesion sesion);
}
