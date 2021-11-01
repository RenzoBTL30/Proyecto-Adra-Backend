package org.adra.app.bi.serviceImpl;

import java.util.List;

import org.adra.app.bi.entity.Banco_Comunal;
import org.adra.app.bi.repository.Banco_ComunalRepository;
import org.adra.app.bi.service.Banco_ComunalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Banco_ComunalServiceImpl implements Banco_ComunalService {

	@Autowired
	private Banco_ComunalRepository banco_comunalRepository;
	
	@Override
	public Banco_Comunal create(Banco_Comunal banco_comunal) {
		// TODO Auto-generated method stub
		return banco_comunalRepository.save(banco_comunal);
	}

	@Override
	public List<Banco_Comunal> readAll() {
		// TODO Auto-generated method stub
		return banco_comunalRepository.findAll();
	}

	@Override
	public Banco_Comunal read(int id) {
		// TODO Auto-generated method stub
		return banco_comunalRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		banco_comunalRepository.deleteById(id);
	}

	@Override
	public Banco_Comunal update(Banco_Comunal banco_comunal) {
		// TODO Auto-generated method stub
		return banco_comunalRepository.save(banco_comunal);
	}

}
