package org.adra.app.bi.service;

import java.util.List;

import org.adra.app.bi.entity.Tipo_Capacitacion;

public interface Tipo_CapacitacionService {
	Tipo_Capacitacion create(Tipo_Capacitacion tipo_capacitacion);
	List<Tipo_Capacitacion> readAll();
	Tipo_Capacitacion read(int id);
	void delete(int id);
	Tipo_Capacitacion update(Tipo_Capacitacion tipo_capacitacion);
}
