package org.adra.app.bi.serviceImpl;

import java.util.List;

import org.adra.app.bi.entity.Anuncio;
import org.adra.app.bi.repository.AnuncioRepository;
import org.adra.app.bi.service.AnuncioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnuncioServiceImpl implements AnuncioService{

	@Autowired
	private AnuncioRepository anuncioRepository;
	
	@Override
	public Anuncio create(Anuncio anuncio) {
		// TODO Auto-generated method stub
		return anuncioRepository.save(anuncio);
	}

	@Override
	public List<Anuncio> readAll() {
		// TODO Auto-generated method stub
		return anuncioRepository.findAll();
	}

	@Override
	public Anuncio read(int id) {
		// TODO Auto-generated method stub
		return anuncioRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		anuncioRepository.deleteById(id);
	}

	@Override
	public Anuncio update(Anuncio anuncio) {
		// TODO Auto-generated method stub
		return anuncioRepository.save(anuncio);
	}

}
