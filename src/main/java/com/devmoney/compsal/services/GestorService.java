package com.devmoney.compsal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmoney.compsal.Repository.GestorRepository;
import com.devmoney.compsal.domain.Gestor;

@Service
public class GestorService {

	@Autowired
	private GestorRepository repo;

	public Gestor findId(Integer id) {
		Optional<Gestor> obj = repo.findById(id);
		return obj.orElse(null);
	}

}
