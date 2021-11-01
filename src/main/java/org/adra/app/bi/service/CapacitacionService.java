package org.adra.app.bi.service;

import java.util.List;

import org.adra.app.bi.entity.Capacitacion;

public interface CapacitacionService {
	Capacitacion create(Capacitacion capacitacion);
	List<Capacitacion> readAll();
	Capacitacion read(int id);
	void delete(int id);
	Capacitacion update(Capacitacion capacitacion);
}
