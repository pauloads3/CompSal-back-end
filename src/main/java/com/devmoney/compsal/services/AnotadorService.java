package com.devmoney.compsal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmoney.compsal.Repository.AnotadorRepository;
import com.devmoney.compsal.domain.Anotador;

@Service
public class AnotadorService {
	
	@Autowired
	private AnotadorRepository repo;
	
	public Anotador findId(Integer id) {
		Optional<Anotador> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}
