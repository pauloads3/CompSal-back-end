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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devmoney.compsal.domain.UsuarioNew;
import com.devmoney.compsal.dto.UsuarioDTO;
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
		UsuarioNew usuario = new UsuarioNew();
		try {
			usuario = service.findCpf(objDto.getCpf());
		} catch (Exception e) {
			System.err.println(e);
		}if (usuario == null ) {
			usuario = service.fromDTO(objDto);
			usuario = service.insert(usuario);
			usuario = service.findCpf(objDto.getCpf());
			return  ResponseEntity.ok().body(usuario);
		}else {
			System.err.println("*** createUsuario: usuariovalidação.  else  " + "Usuario Já cadastrado");
			URI uri = null;	
			System.err.println(ResponseEntity.created(uri).build());
			return  ResponseEntity.ok().body(null);
		}
	}
	
	@RequestMapping(value="/updateUsuario", method=RequestMethod.POST)
	public ResponseEntity<UsuarioNew> update(@Valid @RequestBody UsuarioNew objDto) {
		
			service.update(objDto);
				
			System.err.println("*** updateUsuario:");
			URI uri = null;	
			System.err.println(ResponseEntity.created(uri).build());
			return  ResponseEntity.ok().body(null);
		
	}
	
	@RequestMapping(value="/deleteUsuario", method=RequestMethod.POST)
	public ResponseEntity<UsuarioNew> delete(@Valid @RequestBody Integer id) {
		System.err.println("*** deleteUsuario: objDto."
				+ "id=" + id
				);
		service.delete(id);
		return null;
	}
	
}
