package com.devmoney.compsal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.devmoney.compsal.Repository.UsuarioRepository;
import com.devmoney.compsal.domain.UsuarioNew;
import com.devmoney.compsal.dto.UsuarioDTO;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	public UsuarioNew findId(Integer id) {
		Optional<UsuarioNew> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<UsuarioNew> findAll() {
		return repo.findAll();
	}
	
	public UsuarioNew insert(UsuarioNew obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public UsuarioNew update(UsuarioNew obj) {
		UsuarioNew newObj = findId(obj.getId());
		updateArbitro(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		findId(id);
		repo.deleteById(id);
	}
	
	
	
	//public UsuarioNew fromDTO(UsuarioDTO objDto) {
	//	return new UsuarioNew(objDto.getId(), objDto.getNome(), null);
	//}
	
	public UsuarioNew fromDTO(UsuarioDTO objDto) {
		return new UsuarioNew(null, objDto.getNome(), objDto.getCpf(),
				objDto.getApelido(), 
				objDto.getSexo(), 
				objDto.getDtNascimento(),
				objDto.getTelefone(),
				objDto.getEmail(),
				objDto.getEndereco(),
				objDto.getNumeroEnd(),
				objDto.getCep(),
				objDto.getBairro(),
				objDto.getMunicipio(),
				objDto.getUf());
	}
	
	public void updateArbitro(UsuarioNew newObj, UsuarioNew obj) {
		newObj.setNome(obj.getNome());
		newObj.setCpf(obj.getCpf());
		newObj.setApelido(obj.getApelido());
	// xxxxxxxxxx termina....	
	}
	
}
