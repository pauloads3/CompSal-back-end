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

import com.devmoney.compsal.domain.Eventos;
import com.devmoney.compsal.dto.EventosDTO;
import com.devmoney.compsal.services.EventosService;


@RestController
@RequestMapping(value = "/eventos")
@CrossOrigin(origins = "*")
public class EventosResource {

	@Autowired
	private EventosService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Eventos> find(@PathVariable Integer id) {
		Eventos time = service.findId(id);
		return ResponseEntity.ok().body(time);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EventosDTO>> findAll() {
		List<Eventos> list = service.findAll();
		List<EventosDTO> listDTO = list.stream().map(obj -> new EventosDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value = "/createEventos", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Eventos> insert(@RequestBody EventosDTO objDto) {
		
		Eventos eventos = new Eventos();
		eventos = service.fromDTO(objDto);		
		eventos = service.insert(eventos);		
		return ResponseEntity.ok().body(eventos);
	}
	
	@RequestMapping(value="/findAllGols", method=RequestMethod.GET)
	public ResponseEntity<List<EventosDTO>> findAllGols() {	
		List<Eventos> list = service.findByTipoGol();
		List<EventosDTO> listDTO = list.stream().map(obj -> new EventosDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/findAllCV", method=RequestMethod.GET)
	public ResponseEntity<List<EventosDTO>> findAllCV() {	
		List<Eventos> list = service.findByTipoCV();
		List<EventosDTO> listDTO = list.stream().map(obj -> new EventosDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/findAllCA", method=RequestMethod.GET)
	public ResponseEntity<List<EventosDTO>> findAllCA() {	
		List<Eventos> list = service.findByTipoCA();
		List<EventosDTO> listDTO = list.stream().map(obj -> new EventosDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/findByGolsPorTimeAndJogo", method=RequestMethod.GET)
	public ResponseEntity<List<EventosDTO>> findByGolsPorTimeAndJogo() {	
		List<Eventos> list = service.findByGolsPorTimeAndJogo(1, "");
		List<EventosDTO> listDTO = list.stream().map(obj -> new EventosDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	/*
	@RequestMapping(value = "/nomeM/{nome}", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Time> findM(@PathVariable String nome) {
		Time time = service.findByNomeAndGenero(nome,"M");
		return ResponseEntity.ok().body(time);
	}
	@RequestMapping(value = "/nomeF/{nome}", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Time> findF(@PathVariable String nome) {
		Time time = service.findByNomeAndGenero(nome,"F");
		return ResponseEntity.ok().body(time);
	}
	
	

	@RequestMapping(value="/findAllM", method=RequestMethod.GET)
	public ResponseEntity<List<TimeDTO>> findAllM() {	
		List<Time> list = service.findByGeneroM();
		List<TimeDTO> listDTO = list.stream().map(obj -> new TimeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
		
	@RequestMapping(value="/findAllF", method=RequestMethod.GET)
	public ResponseEntity<List<TimeDTO>> findAllF() {	
		List<Time> list = service.findByGeneroF();
		List<TimeDTO> listDTO = list.stream().map(obj -> new TimeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	
	@RequestMapping(value = "/createTimeOk", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> insertOK(@RequestBody TimeDTO objDto) {
		Time time = new Time();
		time = service.fromDTO(objDto);
		String msg = "";
		msg = service.insertVerifica(time);
		System.err.println(msg);
		return ResponseEntity.ok().body(msg);
	}

	@RequestMapping(value = "/updateTime", method = RequestMethod.POST)
	public ResponseEntity<Time> update(@Valid @RequestBody Time objDto) {

		service.update(objDto);

		System.err.println("*** updateTime:");
		System.err.println(objDto.getId());
		URI uri = null;
		System.err.println(ResponseEntity.created(uri).build());
		return ResponseEntity.ok().body(objDto);

	}

	@RequestMapping(value = "/updateTimeOk", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> updateOK(@RequestBody Time objDto) {
		String msg = "";
		msg = service.updateVerifica(objDto).toString();
		System.err.println(msg);
		return ResponseEntity.ok().body(msg);
	}

	@RequestMapping(value = "/deleteTime", method = RequestMethod.POST)
	public ResponseEntity<String> delete(@Valid @RequestBody Integer id) {
		System.err.println("*** deleteUsuario: objDto." + "id=" + id);
		
		String msg = "";
		try {
			 msg =service.deleteVerifica(id);
			System.err.println(msg);
			
			service.deleteVerifica(id);
			
			if (msg.equals("OK")) {
				service.delete(id);
			}
			
		} catch (Exception e) {
			System.err.println("Erro " + e);
		}		
		return ResponseEntity.ok().body(msg);
	}		
	*/
}
