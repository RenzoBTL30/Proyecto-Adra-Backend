package org.adra.app.bi.serviceImpl;

import java.util.List;

import org.adra.app.bi.entity.Tipo_Capacitacion;
import org.adra.app.bi.repository.Tipo_CapacitacionRepository;
import org.adra.app.bi.service.Tipo_CapacitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Tipo_CapacitacionServiceImpl implements Tipo_CapacitacionService {
	
	@Autowired
	private Tipo_CapacitacionRepository tipo_capacitacionRepository;
	
	@Override
	public Tipo_Capacitacion create(Tipo_Capacitacion tipo_capacitacion) {
		// TODO Auto-generated method stub
		return tipo_capacitacionRepository.save(tipo_capacitacion);
	}

	@Override
	public List<Tipo_Capacitacion> readAll() {
		// TODO Auto-generated method stub
		return tipo_capacitacionRepository.findAll();
	}

	@Override
	public Tipo_Capacitacion read(int id) {
		// TODO Auto-generated method stub
		return tipo_capacitacionRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		tipo_capacitacionRepository.deleteById(id);
	}

	@Override
	public Tipo_Capacitacion update(Tipo_Capacitacion tipo_capacitacion) {
		// TODO Auto-generated method stub
		return tipo_capacitacionRepository.save(tipo_capacitacion);
	}

}
