package com.devmoney.compsal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmoney.compsal.Repository.ArbitroRepository;
import com.devmoney.compsal.domain.Arbitro;
import com.devmoney.compsal.domain.enums.FuncaoArbitro;
import com.devmoney.compsal.dto.ArbitroDTO;
import com.devmoney.compsal.dto.ArbitroNewDTO;

@Service
public class ArbitroService {
	
	@Autowired
	private ArbitroRepository repo;
	
	public Arbitro findId(Integer id) {
		Optional<Arbitro> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Arbitro> findAll() {
		return repo.findAll();
	}
	
	public Arbitro insert(Arbitro obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Arbitro update(Arbitro obj) {
		Arbitro newObj = findId(obj.getId());
		updateArbitro(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		findId(id);
		repo.deleteById(id);
	}
	
	
	
	public Arbitro fromDTO(ArbitroDTO objDto) {
		return new Arbitro(objDto.getId(), objDto.getNome(), null);
	}
	
	public Arbitro fromDTO(ArbitroNewDTO objDto) {
		return new Arbitro(null, objDto.getNome(), FuncaoArbitro.toEnum(objDto.getFuncao()));
	}
	
	public void updateArbitro(Arbitro newObj, Arbitro obj) {
		newObj.setNome(obj.getNome());
		newObj.setFuncaoArbitro(obj.getFuncao());
	}
	
}
