package org.adra.app.bi.service;

import java.util.List;

import org.adra.app.bi.entity.Privilegio;

public interface PrivilegioService {
	Privilegio create(Privilegio privilegio);
	List<Privilegio> readAll();
	Privilegio read(int id);
	void delete(int id);
	Privilegio update(Privilegio privilegio);
}
