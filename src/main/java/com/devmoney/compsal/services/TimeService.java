package com.devmoney.compsal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmoney.compsal.Repository.TimeRepository;
import com.devmoney.compsal.domain.Time;
import com.devmoney.compsal.dto.TimeDTO;

@Service
public class TimeService {
	
	@Autowired
	private TimeRepository repo;
	
	public Time findId(Integer id) {
		Optional<Time> obj = repo.findById(id);
		return obj.orElse(null);
	}	
	
	public List<Time> findAll() {
		return repo.findAll();
	}
		
	public Time insert(Time obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Time update(Time obj) {
		System.err.println("*** update:");
		Time newObj = findId(obj.getId());
		updateTime(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		findId(id);
		repo.deleteById(id);
	}	
	
	public Time fromDTO(TimeDTO objDto) {
		return new Time(null, objDto.getNome(), objDto.getGenero()/*,
				objDto.get, 
				objDto.get, 
				objDto.get,
				objDto.get,
				objDto.get,
				objDto.get,
				objDto.getNumeroEnd(),
				objDto.getCep(),
				objDto.getBairro(),
				objDto.getMunicipio(),
				objDto.getUf()*/
				);
	}
	
	public void updateTime(Time newObj, Time obj) {
		System.err.println("*** updateTme:");
		/*newObj.setNome(obj.getNome());
		newObj.setCpf(obj.getCpf()); ///// não alterar
		newObj.setApelido(obj.getApelido());
		newObj.setSexo(obj.getSexo());		
		newObj.setDtNascimento(obj.getDtNascimento());
		newObj.setTelefone(obj.getTelefone());
		newObj.setEmail(obj.getEmail());
		newObj.setEndereco(obj.getEndereco());
		newObj.setNumeroEnd(obj.getNumeroEnd());
		newObj.setCep(obj.getCep());
		newObj.setBairro(obj.getBairro());
		newObj.setMunicipio(obj.getMunicipio());
		newObj.setUf(obj.getUf());*/
		
		//repo.update();
		
	// xxxxxxxxxx termina....	
		
		
		
	}
	
}
