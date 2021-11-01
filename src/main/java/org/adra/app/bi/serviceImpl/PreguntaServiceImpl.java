package org.adra.app.bi.serviceImpl;

import java.util.List;

import org.adra.app.bi.entity.Pregunta;
import org.adra.app.bi.repository.PreguntaRepository;
import org.adra.app.bi.service.PreguntaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreguntaServiceImpl implements PreguntaService {
	
	@Autowired
	private PreguntaRepository preguntaRepository;
	
	@Override
	public Pregunta create(Pregunta pregunta) {
		// TODO Auto-generated method stub
		return preguntaRepository.save(pregunta);
	}

	@Override
	public List<Pregunta> readAll() {
		// TODO Auto-generated method stub
		return preguntaRepository.findAll();
	}

	@Override
	public Pregunta read(int id) {
		// TODO Auto-generated method stub
		return preguntaRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		preguntaRepository.deleteById(id);
	}

	@Override
	public Pregunta update(Pregunta pregunta) {
		// TODO Auto-generated method stub
		return preguntaRepository.save(pregunta);
	}

}
