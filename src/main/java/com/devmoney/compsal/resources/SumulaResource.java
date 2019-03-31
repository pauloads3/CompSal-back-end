package com.devmoney.compsal.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devmoney.compsal.domain.Sumula;
import com.devmoney.compsal.dto.SumulaDTO;
import com.devmoney.compsal.services.SumulaService;

@RestController
@RequestMapping(value="/sumulas")
@CrossOrigin(origins="*")
public class SumulaResource {
	
	@Autowired
	private SumulaService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Sumula> find(@PathVariable Integer id) {
		Sumula sumula = service.findId(id);
		return ResponseEntity.ok().body(sumula);
	}
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<SumulaDTO>> findAll() {	
		List<Sumula> list = service.findAll();
		List<SumulaDTO> listDTO = list.stream().map(obj -> new SumulaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}	
}
