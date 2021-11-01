package org.adra.app.bi.service;

import java.util.List;

import org.adra.app.bi.entity.Alternativa;

public interface AlternativaService {
	Alternativa create(Alternativa alternativa);
	List<Alternativa> readAll();
	Alternativa read(int id);
	void delete(int id);
	Alternativa update(Alternativa alternativa);
}
