package com.devmoney.compsal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmoney.compsal.Repository.SumulaRepository;
import com.devmoney.compsal.domain.Sumula;

@Service
public class SumulaService {
	
	@Autowired
	private SumulaRepository repo;
	
	public Sumula findId(Integer id) {
		Optional<Sumula> obj = repo.findById(id);
		return obj.orElse(null);
	}
	public List<Sumula> findAll() {
		return repo.findAll();
	}
	
	
}
