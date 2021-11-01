package org.adra.app.bi.service;

import java.util.List;

import org.adra.app.bi.entity.Afiliacion;

public interface AfiliacionService {
	Afiliacion create(Afiliacion afiliacion);
	List<Afiliacion> readAll();
	Afiliacion read(int id);
	void delete(int id);
	Afiliacion update(Afiliacion afiliacion);
}
