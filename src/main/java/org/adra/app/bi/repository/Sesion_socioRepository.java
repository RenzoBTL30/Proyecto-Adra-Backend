package org.adra.app.bi.repository;

import org.adra.app.bi.entity.Sesion_socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Sesion_socioRepository extends JpaRepository<Sesion_socio, Integer>{

}
