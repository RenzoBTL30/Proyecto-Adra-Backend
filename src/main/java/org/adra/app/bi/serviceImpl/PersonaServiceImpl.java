package org.adra.app.bi.serviceImpl;

import java.util.List;

import org.adra.app.bi.entity.Persona;
import org.adra.app.bi.repository.PersonaRepository;
import org.adra.app.bi.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public Persona create(Persona persona) {
		// TODO Auto-generated method stub
		return personaRepository.save(persona);
	}

	@Override
	public List<Persona> readAll() {
		// TODO Auto-generated method stub
		return personaRepository.findAll();
	}

	@Override
	public Persona read(int id) {
		// TODO Auto-generated method stub
		return personaRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		personaRepository.deleteById(id);
	}

	@Override
	public Persona update(Persona persona) {
		// TODO Auto-generated method stub
		return personaRepository.save(persona);
	}

}
