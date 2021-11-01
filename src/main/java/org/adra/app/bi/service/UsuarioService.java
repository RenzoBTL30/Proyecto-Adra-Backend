package org.adra.app.bi.service;

import java.util.List;

import org.adra.app.bi.entity.Usuario;

public interface UsuarioService {
	Usuario create(Usuario usuario);
	List<Usuario> readAll();
	Usuario read(int id);
	void delete(int id);
	Usuario update(Usuario usuario);
}
