package org.adra.app.bi.serviceImpl;

import java.util.List;

import org.adra.app.bi.entity.Rol;
import org.adra.app.bi.repository.RolRepository;
import org.adra.app.bi.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	private RolRepository rolRepository;
	
	@Override
	public Rol create(Rol rol) {
		// TODO Auto-generated method stub
		return rolRepository.save(rol);
	}

	@Override
	public List<Rol> readAll() {
		// TODO Auto-generated method stub
		return rolRepository.findAll();
	}

	@Override
	public Rol read(int id) {
		// TODO Auto-generated method stub
		return rolRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		rolRepository.deleteById(id);
	}

	@Override
	public Rol update(Rol rol) {
		// TODO Auto-generated method stub
		return rolRepository.save(rol);
	}

}
