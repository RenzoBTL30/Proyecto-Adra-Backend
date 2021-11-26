package org.adra.app.bi.repository;

import org.adra.app.bi.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositoryOauth extends JpaRepository<Usuario, Integer>{
	public Usuario findByDni(String nu_dni);
}
