package com.devmoney.compsal.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devmoney.compsal.domain.ResolucaoEquipe;
import com.devmoney.compsal.services.ResolucaoEquipeService;

@RestController
@RequestMapping(value="/resolucaoEquipes")
public class ResolucaoEquipeResource {
	
	@Autowired
	private ResolucaoEquipeService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<ResolucaoEquipe> find(@PathVariable Integer id) {
		ResolucaoEquipe resEquipe = service.findId(id);
		return ResponseEntity.ok().body(resEquipe);
	}
	
}
