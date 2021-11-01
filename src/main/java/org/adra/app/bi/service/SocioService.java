package org.adra.app.bi.service;

import java.util.List;

import org.adra.app.bi.entity.Socio;

public interface SocioService {
	Socio create(Socio socio);
	List<Socio> readAll();
	Socio read(int id);
	void delete(int id);
	Socio update(Socio socio);
}
