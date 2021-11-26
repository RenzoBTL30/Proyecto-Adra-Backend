package org.adra.app.bi.service;

import java.util.List;

import org.adra.app.bi.entity.Anuncio;

public interface AnuncioService {
	Anuncio create(Anuncio anuncio);
	List<Anuncio> readAll();
	Anuncio read(int id);
	void delete(int id);
	Anuncio update(Anuncio anuncio);
}
