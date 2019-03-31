package com.devmoney.compsal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmoney.compsal.Repository.ResolucaoEquipeRepository;
import com.devmoney.compsal.domain.ResolucaoEquipe;

@Service
public class ResolucaoEquipeService {
	
	@Autowired
	private ResolucaoEquipeRepository repo;
	
	public ResolucaoEquipe findId(Integer id) {
		Optional<ResolucaoEquipe> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}
