package com.devmoney.compsal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmoney.compsal.Repository.EquipeRepository;
import com.devmoney.compsal.domain.Equipe;

@Service
public class EquipeService {
	
	@Autowired
	private EquipeRepository repo;
	
	public Equipe findId(Integer id) {
		Optional<Equipe> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}
