package org.adra.app.bi.serviceImpl;

import java.util.List;

import org.adra.app.bi.entity.Pedido_Oracion;
import org.adra.app.bi.repository.Pedido_OracionRepository;
import org.adra.app.bi.service.Pedido_OracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Pedido_OracionServiceImpl implements Pedido_OracionService {

	@Autowired
	private Pedido_OracionRepository pedido_oracionRepository;
	
	@Override
	public Pedido_Oracion create(Pedido_Oracion pedido_oracion) {
		// TODO Auto-generated method stub
		return pedido_oracionRepository.save(pedido_oracion);
	}

	@Override
	public List<Pedido_Oracion> readAll() {
		// TODO Auto-generated method stub
		return pedido_oracionRepository.findAll();
	}

	@Override
	public Pedido_Oracion read(int id) {
		// TODO Auto-generated method stub
		return pedido_oracionRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		pedido_oracionRepository.deleteById(id);
	}

	@Override
	public Pedido_Oracion update(Pedido_Oracion pedido_oracion) {
		// TODO Auto-generated method stub
		return pedido_oracionRepository.save(pedido_oracion);
	}

}
