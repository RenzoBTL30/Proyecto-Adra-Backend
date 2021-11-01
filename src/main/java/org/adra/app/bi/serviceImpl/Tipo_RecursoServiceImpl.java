package org.adra.app.bi.serviceImpl;

import java.util.List;

import org.adra.app.bi.entity.Tipo_Recurso;
import org.adra.app.bi.repository.Tipo_RecursoRepository;
import org.adra.app.bi.service.Tipo_RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Tipo_RecursoServiceImpl implements Tipo_RecursoService {

	@Autowired
	private Tipo_RecursoRepository tipo_recursoRepository;
	
	@Override
	public Tipo_Recurso create(Tipo_Recurso tipo_recurso) {
		// TODO Auto-generated method stub
		return tipo_recursoRepository.save(tipo_recurso);
	}

	@Override
	public List<Tipo_Recurso> readAll() {
		// TODO Auto-generated method stub
		return tipo_recursoRepository.findAll();
	}

	@Override
	public Tipo_Recurso read(int id) {
		// TODO Auto-generated method stub
		return tipo_recursoRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		tipo_recursoRepository.deleteById(id);
	}

	@Override
	public Tipo_Recurso update(Tipo_Recurso tipo_recurso) {
		// TODO Auto-generated method stub
		return tipo_recursoRepository.save(tipo_recurso);
	}

}
