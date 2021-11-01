package org.adra.app.bi.service;

import java.util.List;

import org.adra.app.bi.entity.Rol_privilegio;

public interface Rol_privilegioService {
	Rol_privilegio create(Rol_privilegio rol_privilegio);
	List<Rol_privilegio> readAll();
	Rol_privilegio read(int id);
	void delete(int id);
	Rol_privilegio update(Rol_privilegio rol_privilegio);
}
