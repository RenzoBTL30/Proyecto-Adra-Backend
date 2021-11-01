package org.adra.app.bi.serviceImpl;

import java.util.List;

import org.adra.app.bi.entity.Rol_privilegio;
import org.adra.app.bi.repository.Rol_privilegioRepository;
import org.adra.app.bi.service.Rol_privilegioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Rol_privilegioServiceImpl implements Rol_privilegioService {

	@Autowired
	private Rol_privilegioRepository rol_privilegioRepository;
	
	@Override
	public Rol_privilegio create(Rol_privilegio rol_privilegio) {
		// TODO Auto-generated method stub
		return rol_privilegioRepository.save(rol_privilegio);
	}

	@Override
	public List<Rol_privilegio> readAll() {
		// TODO Auto-generated method stub
		return rol_privilegioRepository.findAll();
	}

	@Override
	public Rol_privilegio read(int id) {
		// TODO Auto-generated method stub
		return rol_privilegioRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		rol_privilegioRepository.deleteById(id);
	}

	@Override
	public Rol_privilegio update(Rol_privilegio rol_privilegio) {
		// TODO Auto-generated method stub
		return rol_privilegioRepository.save(rol_privilegio);
	}

}
