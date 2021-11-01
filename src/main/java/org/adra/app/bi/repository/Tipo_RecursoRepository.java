package org.adra.app.bi.repository;

import org.adra.app.bi.entity.Tipo_Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tipo_RecursoRepository extends JpaRepository<Tipo_Recurso, Integer>{

}
