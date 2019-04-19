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
import com.devmoney.compsal.domain.UsuarioNew;
import com.devmoney.compsal.dto.ArbitroDTO;
import com.devmoney.compsal.dto.ArbitroNewDTO;
import com.devmoney.compsal.dto.UsuarioDTO;
import com.devmoney.compsal.services.ArbitroService;
import com.devmoney.compsal.services.UsuarioService;

@RestController
@RequestMapping(value="/usuarios")
@CrossOrigin(origins="*")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@CrossOrigin(origins="*")
	public ResponseEntity<UsuarioNew> find(@PathVariable Integer id) {
		UsuarioNew usuario = service.findId(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findAll() {	
		List<UsuarioNew> list = service.findAll();
		List<UsuarioDTO> listDTO = list.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	

	@RequestMapping(value="/createUsuario", method=RequestMethod.POST)
	public ResponseEntity<UsuarioNew> insert(@Valid @RequestBody UsuarioDTO objDto) {
		UsuarioNew usuario = service.fromDTO(objDto);
		System.err.println("*** createUsuario: objDto."
				+ "nome=" + objDto.getNome()
				+ ", cpf=" + objDto.getCpf()
				+ ", apelido=" + objDto.getApelido()
				);
		System.err.println("*** createUsuario: usuario."
				+ "nome=" + usuario.getNome()
				+ ", cpf=" + usuario.getCpf()
				+ ", apelido=" + usuario.getApelido()
				);		usuario = service.insert(usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();	
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/deleteUsuario", method=RequestMethod.POST)
	public ResponseEntity<UsuarioNew> delete(@Valid @RequestBody UsuarioDTO objDto) {
		service.delete(objDto.getId());
		return null;
	}
	
}
