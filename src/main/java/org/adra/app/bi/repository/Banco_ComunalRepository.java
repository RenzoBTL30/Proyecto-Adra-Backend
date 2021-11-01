package org.adra.app.bi.repository;

import org.adra.app.bi.entity.Banco_Comunal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Banco_ComunalRepository extends JpaRepository<Banco_Comunal, Integer>{

}
