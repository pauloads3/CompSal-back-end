package com.devmoney.compsal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmoney.compsal.Repository.JogadorRepository;
import com.devmoney.compsal.domain.Jogador;

@Service
public class JogadorService {

	@Autowired
	private JogadorRepository repo;
	
	public Jogador findId(Integer id) {
		Optional<Jogador> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Jogador> findAll() {
		return repo.findAll();
	}
	
}
