package org.adra.app.bi.serviceImpl;

import java.util.List;

import org.adra.app.bi.entity.Capacitacion;
import org.adra.app.bi.repository.CapacitacionRepository;
import org.adra.app.bi.service.CapacitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CapacitacionServiceImpl implements CapacitacionService {
	
	@Autowired
	private CapacitacionRepository capacitacionRepository;
	
	@Override
	public Capacitacion create(Capacitacion capacitacion) {
		// TODO Auto-generated method stub
		return capacitacionRepository.save(capacitacion);
	}

	@Override
	public List<Capacitacion> readAll() {
		// TODO Auto-generated method stub
		return capacitacionRepository.findAll();
	}

	@Override
	public Capacitacion read(int id) {
		// TODO Auto-generated method stub
		return capacitacionRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		capacitacionRepository.deleteById(id);
	}

	@Override
	public Capacitacion update(Capacitacion capacitacion) {
		// TODO Auto-generated method stub
		return capacitacionRepository.save(capacitacion);
	}

}
