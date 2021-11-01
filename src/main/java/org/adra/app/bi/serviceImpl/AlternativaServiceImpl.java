package org.adra.app.bi.serviceImpl;

import java.util.List;

import org.adra.app.bi.entity.Alternativa;
import org.adra.app.bi.repository.AlternativaRepository;
import org.adra.app.bi.service.AlternativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlternativaServiceImpl implements AlternativaService {
	
	@Autowired
	private AlternativaRepository alternativaRepository;
	
	@Override
	public Alternativa create(Alternativa alternativa) {
		// TODO Auto-generated method stub
		return alternativaRepository.save(alternativa);
	}

	@Override
	public List<Alternativa> readAll() {
		// TODO Auto-generated method stub
		return alternativaRepository.findAll();
	}

	@Override
	public Alternativa read(int id) {
		// TODO Auto-generated method stub
		return alternativaRepository.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		alternativaRepository.deleteById(id);
	}

	@Override
	public Alternativa update(Alternativa alternativa) {
		// TODO Auto-generated method stub
		return alternativaRepository.save(alternativa);
	}

}
