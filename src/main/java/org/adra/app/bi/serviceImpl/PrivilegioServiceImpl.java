package org.adra.app.bi.serviceImpl;

import java.util.List;

import org.adra.app.bi.entity.Privilegio;
import org.adra.app.bi.repository.PrivilegioRepository;
import org.adra.app.bi.service.PrivilegioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivilegioServiceImpl implements PrivilegioService {
	
	@Autowired
	private PrivilegioRepository privilegioRepository;
	
	@Override
	public Privilegio create(Privilegio privilegio) {
		// TODO Auto-generated method stub
		return privilegioRepository.save(privilegio);
	}

	@Override
	public List<Privilegio> readAll() {
		// TODO Auto-generated method stub
		return privilegioRepository.findAll();
	}

	@Override
	public Privilegio read(int id) {
		// TODO Auto-generated method stub
		return privilegioRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		privilegioRepository.deleteById(id);
	}

	@Override
	public Privilegio update(Privilegio privilegio) {
		// TODO Auto-generated method stub
		return privilegioRepository.save(privilegio);
	}

}
