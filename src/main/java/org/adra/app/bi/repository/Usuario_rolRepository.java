package org.adra.app.bi.repository;

import org.adra.app.bi.entity.Usuario_rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Usuario_rolRepository extends JpaRepository<Usuario_rol, Integer>{

}
