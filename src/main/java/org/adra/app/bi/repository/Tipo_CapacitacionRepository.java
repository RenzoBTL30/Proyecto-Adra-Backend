package org.adra.app.bi.repository;

import org.adra.app.bi.entity.Tipo_Capacitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tipo_CapacitacionRepository extends JpaRepository<Tipo_Capacitacion, Integer>{

}
