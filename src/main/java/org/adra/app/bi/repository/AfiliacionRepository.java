package org.adra.app.bi.repository;

import org.adra.app.bi.entity.Afiliacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AfiliacionRepository extends JpaRepository<Afiliacion, Integer>{

}
