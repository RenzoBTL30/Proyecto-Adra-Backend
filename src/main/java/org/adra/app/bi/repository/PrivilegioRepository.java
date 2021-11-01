package org.adra.app.bi.repository;

import org.adra.app.bi.entity.Privilegio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrivilegioRepository extends JpaRepository<Privilegio, Integer>{

}
