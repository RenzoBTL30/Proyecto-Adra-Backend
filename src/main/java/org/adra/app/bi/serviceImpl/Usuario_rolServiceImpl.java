package org.adra.app.bi.serviceImpl;

import java.util.List;

import org.adra.app.bi.entity.Usuario_rol;
import org.adra.app.bi.repository.Usuario_rolRepository;
import org.adra.app.bi.service.Usuario_rolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Usuario_rolServiceImpl implements Usuario_rolService {
	
	@Autowired
	private Usuario_rolRepository usuario_rolRepository;
	
	@Override
	public Usuario_rol create(Usuario_rol usuario_rol) {
		// TODO Auto-generated method stub
		return usuario_rolRepository.save(usuario_rol);
	}

	@Override
	public List<Usuario_rol> readAll() {
		// TODO Auto-generated method stub
		return usuario_rolRepository.findAll();
	}

	@Override
	public Usuario_rol read(int id) {
		// TODO Auto-generated method stub
		return usuario_rolRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		usuario_rolRepository.deleteById(id);;
	}

	@Override
	public Usuario_rol update(Usuario_rol usuario_rol) {
		// TODO Auto-generated method stub
		return usuario_rolRepository.save(usuario_rol);
	}

}
