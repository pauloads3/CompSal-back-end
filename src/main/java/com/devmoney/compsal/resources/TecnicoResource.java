package com.devmoney.compsal.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devmoney.compsal.domain.Tecnico;
import com.devmoney.compsal.services.TecnicoService;

@RestController
@RequestMapping(value="/tecnicos")
@CrossOrigin(origins="*")
public class TecnicoResource {
	
	@Autowired
	private TecnicoService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Tecnico> find(@PathVariable Integer id) {
		Tecnico tecnico = service.findId(id);
		return ResponseEntity.ok().body(tecnico);
	}
	
}
