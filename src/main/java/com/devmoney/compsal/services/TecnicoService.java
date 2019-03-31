package com.devmoney.compsal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmoney.compsal.Repository.TecnicoRepository;
import com.devmoney.compsal.domain.Tecnico;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repo;
	
	public Tecnico findId(Integer id) {
		Optional<Tecnico> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}
