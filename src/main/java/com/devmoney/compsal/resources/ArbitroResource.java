package com.devmoney.compsal.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devmoney.compsal.domain.Arbitro;
import com.devmoney.compsal.dto.ArbitroDTO;
import com.devmoney.compsal.dto.ArbitroNewDTO;
import com.devmoney.compsal.services.ArbitroService;

@RestController
@RequestMapping(value="/arbitros")
@CrossOrigin(origins="*")
public class ArbitroResource {
	
	@Autowired
	private ArbitroService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@CrossOrigin(origins="*")
	public ResponseEntity<Arbitro> find(@PathVariable Integer id) {
		Arbitro arbitro = service.findId(id);
		return ResponseEntity.ok().body(arbitro);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ArbitroDTO>> findAll() {	
		List<Arbitro> list = service.findAll();
		List<ArbitroDTO> listDTO = list.stream().map(obj -> new ArbitroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Arbitro> insert(@Valid @RequestBody ArbitroNewDTO objDto) {
		Arbitro arbitro = service.fromDTO(objDto);
		arbitro = service.insert(arbitro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(arbitro.getId()).toUri();	
		return ResponseEntity.created(uri).build();
	}
	
}
