package com.devmoney.compsal.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devmoney.compsal.domain.Gestor;
import com.devmoney.compsal.services.GestorService;

@RestController
@RequestMapping(value="/gestor")
public class GestorResource {

	@Autowired
	private GestorService service;

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Gestor> find(@PathVariable Integer id) {
		Gestor gestor = service.findId(id);
		return ResponseEntity.ok().body(gestor);
	}

}
