package org.adra.app.bi.serviceImpl;

import java.util.List;

import org.adra.app.bi.entity.Control_Vista;
import org.adra.app.bi.repository.Control_VistaRepository;
import org.adra.app.bi.service.Control_VistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Control_VistaServiceImpl implements Control_VistaService {
	
	@Autowired
	private Control_VistaRepository control_vistaRepository;
	
	@Override
	public Control_Vista create(Control_Vista control_vista) {
		// TODO Auto-generated method stub
		return control_vistaRepository.save(control_vista);
	}

	@Override
	public List<Control_Vista> readAll() {
		// TODO Auto-generated method stub
		return control_vistaRepository.findAll();
	}

	@Override
	public Control_Vista read(int id) {
		// TODO Auto-generated method stub
		return control_vistaRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		control_vistaRepository.deleteById(id);
	}

	@Override
	public Control_Vista update(Control_Vista control_vista) {
		// TODO Auto-generated method stub
		return control_vistaRepository.save(control_vista);
	}

}
