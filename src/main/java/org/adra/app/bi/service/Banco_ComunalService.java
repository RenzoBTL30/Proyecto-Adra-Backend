package org.adra.app.bi.service;

import java.util.List;

import org.adra.app.bi.entity.Banco_Comunal;

public interface Banco_ComunalService {
	Banco_Comunal create(Banco_Comunal banco_comunal);
	List<Banco_Comunal> readAll();
	Banco_Comunal read(int id);
	void delete(int id);
	Banco_Comunal update(Banco_Comunal banco_comunal);
}
