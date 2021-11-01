package org.adra.app.bi.service;

import java.util.List;

import org.adra.app.bi.entity.Usuario_rol;

public interface Usuario_rolService {
	Usuario_rol create(Usuario_rol usuario_rol);
	List<Usuario_rol> readAll();
	Usuario_rol read(int id);
	void delete(int id);
	Usuario_rol update(Usuario_rol usuario_rol);
}
