package org.adra.app.bi.serviceImpl;

import java.util.List;

import org.adra.app.bi.entity.Socio;
import org.adra.app.bi.repository.SocioRepository;
import org.adra.app.bi.service.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocioServiceImpl implements SocioService {
	
	@Autowired
	private SocioRepository socioRepository;
	
	@Override
	public Socio create(Socio socio) {
		// TODO Auto-generated method stub
		return socioRepository.save(socio);
	}

	@Override
	public List<Socio> readAll() {
		// TODO Auto-generated method stub
		return socioRepository.findAll();
	}

	@Override
	public Socio read(int id) {
		// TODO Auto-generated method stub
		return socioRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		socioRepository.deleteById(id);
	}

	@Override
	public Socio update(Socio socio) {
		// TODO Auto-generated method stub
		return socioRepository.save(socio);
	}

}
