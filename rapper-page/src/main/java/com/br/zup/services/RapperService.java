package com.br.zup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.zup.models.Rapper;
import com.br.zup.repositories.RapperRepository;

@Service
public class RapperService {
	@Autowired
	RapperRepository rapperRepository;
	
	public long quantityRapper() {
		return rapperRepository.count();
	}
	
	public Iterable<Rapper> allRapper() {
		return rapperRepository.findAll();
	}
	
	public Rapper rapperId(int id) {
		return rapperRepository.findById(id).get();
	}
	public void createRapper(Rapper newRapper) {
		rapperRepository.save(newRapper);
	}

}
