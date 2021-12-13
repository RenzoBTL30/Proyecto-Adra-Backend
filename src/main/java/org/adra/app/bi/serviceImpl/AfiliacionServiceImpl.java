package org.adra.app.bi.serviceImpl;

import java.util.List;

import org.adra.app.bi.entity.Afiliacion;
import org.adra.app.bi.repository.AfiliacionRepository;
import org.adra.app.bi.service.AfiliacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AfiliacionServiceImpl implements AfiliacionService {

	@Autowired
	private AfiliacionRepository afiliacionRepository;
	
	@Override
	public Afiliacion create(Afiliacion afiliacion) {
		// TODO Auto-generated method stub
		return afiliacionRepository.save(afiliacion);
	}

	@Override
	public List<Afiliacion> readAll() {
		// TODO Auto-generated method stub
		return afiliacionRepository.findAll();
	}

	@Override
	public Afiliacion read(int id) {
		// TODO Auto-generated method stub
		return afiliacionRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		afiliacionRepository.deleteById(id);
	}

	@Override
	public Afiliacion update(Afiliacion afiliacion) {
		// TODO Auto-generated method stub
		return afiliacionRepository.save(afiliacion);
	}

	@Override
	public String asignarAfiliacion(String param1, String param2) {
		// TODO Auto-generated method stub
		return afiliacionRepository.asignarAfiliacion(param1, param2);
	}

}
