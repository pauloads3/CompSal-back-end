package com.devmoney.compsal.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devmoney.compsal.domain.Anotador;
import com.devmoney.compsal.services.AnotadorService;

@RestController
@RequestMapping(value="/anotadores")
@CrossOrigin(origins="*")
public class AnotadorResource {
	
	@Autowired
	private AnotadorService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Anotador> find(@PathVariable Integer id) {
		Anotador anotador = service.findId(id);
		return ResponseEntity.ok().body(anotador);
	}
	
}
