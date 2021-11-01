package org.adra.app.bi.service;

import java.util.List;

import org.adra.app.bi.entity.Rol;

public interface RolService {
	Rol create(Rol rol);
	List<Rol> readAll();
	Rol read(int id);
	void delete(int id);
	Rol update(Rol rol);
}
