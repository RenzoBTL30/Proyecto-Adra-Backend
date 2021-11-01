package org.adra.app.bi.serviceImpl;

import java.util.List;

import org.adra.app.bi.entity.Recurso;
import org.adra.app.bi.repository.RecursoRepository;
import org.adra.app.bi.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecursoServiceImpl implements RecursoService {
	
	@Autowired
	private RecursoRepository recursoRepository;
	
	@Override
	public Recurso create(Recurso recurso) {
		// TODO Auto-generated method stub
		return recursoRepository.save(recurso);
	}

	@Override
	public List<Recurso> readAll() {
		// TODO Auto-generated method stub
		return recursoRepository.findAll();
	}

	@Override
	public Recurso read(int id) {
		// TODO Auto-generated method stub
		return recursoRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		recursoRepository.deleteById(id);
	}

	@Override
	public Recurso update(Recurso recurso) {
		// TODO Auto-generated method stub
		return recursoRepository.save(recurso);
	}

}
