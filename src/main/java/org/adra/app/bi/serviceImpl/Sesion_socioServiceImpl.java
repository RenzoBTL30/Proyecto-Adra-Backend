package org.adra.app.bi.serviceImpl;

import java.util.List;

import org.adra.app.bi.entity.Sesion_socio;
import org.adra.app.bi.repository.Sesion_socioRepository;
import org.adra.app.bi.service.Sesion_socioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Sesion_socioServiceImpl implements Sesion_socioService {
	
	@Autowired
	private Sesion_socioRepository sesion_socioRepository;
	
	@Override
	public Sesion_socio create(Sesion_socio sesion_socio) {
		// TODO Auto-generated method stub
		return sesion_socioRepository.save(sesion_socio);
	}

	@Override
	public List<Sesion_socio> readAll() {
		// TODO Auto-generated method stub
		return sesion_socioRepository.findAll();
	}

	@Override
	public Sesion_socio read(int id) {
		// TODO Auto-generated method stub
		return sesion_socioRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		sesion_socioRepository.deleteById(id);
	}

	@Override
	public Sesion_socio update(Sesion_socio sesion_socio) {
		// TODO Auto-generated method stub
		return sesion_socioRepository.save(sesion_socio);
	}

	@Override
	public String actualizarValoracion(int param1, int param2, int param3, String param4) {
		// TODO Auto-generated method stub
		return sesion_socioRepository.actualizarValoracion(param1, param2, param3, param4);
	}

}
