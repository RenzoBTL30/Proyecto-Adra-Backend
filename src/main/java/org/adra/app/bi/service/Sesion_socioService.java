package org.adra.app.bi.service;

import java.util.List;

import org.adra.app.bi.entity.Sesion_socio;

public interface Sesion_socioService {
	Sesion_socio create(Sesion_socio sesion_socio);
	List<Sesion_socio> readAll();
	Sesion_socio read(int id);
	void delete(int id);
	Sesion_socio update(Sesion_socio sesion_socio);
	String actualizarValoracion(int param1, int param2, int param3, String param4);
}
