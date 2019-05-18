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

import com.devmoney.compsal.domain.Time;
import com.devmoney.compsal.domain.UsuarioNew;
import com.devmoney.compsal.dto.TimeDTO;
import com.devmoney.compsal.dto.UsuarioDTO;
import com.devmoney.compsal.services.TimeService;


@RestController
@RequestMapping(value="/times")
@CrossOrigin(origins="*")
public class TimeResource {
	
	@Autowired
	private TimeService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@CrossOrigin(origins="*")
	public ResponseEntity<Time> find(@PathVariable Integer id) {
		Time time = service.findId(id);
		return ResponseEntity.ok().body(time);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<TimeDTO>> findAll() {	
		List<Time> list = service.findAll();
		List<TimeDTO> listDTO = list.stream().map(obj -> new TimeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}	
	
	@RequestMapping(value="/createTime", method=RequestMethod.POST)
	@CrossOrigin(origins="*")
	public ResponseEntity<Time> insert(@RequestBody TimeDTO objDto) {
		System.err.println(objDto.getNome() + objDto.getGenero());
		Time time = new Time();		
		time = service.fromDTO(objDto);
		System.err.println(time.getNome() + time.getGenero());
		time = service.insert(time);
		System.err.println(time.getNome() + time.getGenero());
		return  ResponseEntity.ok().body(time);				
		}
	
	@RequestMapping(value="/updateTime", method=RequestMethod.POST)
	public ResponseEntity<Time> update(@Valid @RequestBody Time objDto) {
		
			service.update(objDto);
				
			System.err.println("*** updateTime:");
			System.err.println(objDto.getId());
			URI uri = null;	
			System.err.println(ResponseEntity.created(uri).build());
			return  ResponseEntity.ok().body(objDto);
		
	}
	
	@RequestMapping(value="/deleteTime", method=RequestMethod.POST)
	public ResponseEntity<Time> delete(@Valid @RequestBody Integer id) {
		Time time = new Time();
		time = null;
		System.err.println("*** deleteUsuario: objDto." + "id=" + id);
		
		try {
			service.delete(id);			
		} catch (Exception e) {
			System.err.println(e);
			time = service.findId(id);
		}		
		return  ResponseEntity.ok().body(time);
	
	}
}

