package com.devmoney.compsal.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devmoney.compsal.domain.Equipe;
import com.devmoney.compsal.services.EquipeService;

@RestController
@RequestMapping(value="/equipes")
@CrossOrigin(origins="*")
public class EquipeResource {
	
	@Autowired
	private EquipeService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Equipe> find(@PathVariable Integer id) {
		Equipe equipe = service.findId(id);
		return ResponseEntity.ok().body(equipe);
	}
	
}
