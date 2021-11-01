package org.adra.app.bi.serviceImpl;

import java.util.List;

import org.adra.app.bi.entity.Sesion;
import org.adra.app.bi.repository.SesionRepository;
import org.adra.app.bi.service.SesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesionServiceImpl implements SesionService {
	
	@Autowired
	private SesionRepository sesionRepository;
	
	@Override
	public Sesion create(Sesion sesion) {
		// TODO Auto-generated method stub
		return sesionRepository.save(sesion);
	}

	@Override
	public List<Sesion> readAll() {
		// TODO Auto-generated method stub
		return sesionRepository.findAll();
	}

	@Override
	public Sesion read(int id) {
		// TODO Auto-generated method stub
		return sesionRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sesionRepository.deleteById(id);
	}

	@Override
	public Sesion update(Sesion sesion) {
		// TODO Auto-generated method stub
		return sesionRepository.save(sesion);
	}

}
