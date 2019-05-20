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

import com.devmoney.compsal.domain.Jogo;
import com.devmoney.compsal.dto.JogoDTO;
/*import com.devmoney.compsal.domain.Time;
import com.devmoney.compsal.dto.TimeDTO;*/
import com.devmoney.compsal.services.JogoService;

@RestController
@RequestMapping(value = "/jogos")
@CrossOrigin(origins = "*")
public class JogoResource {

	@Autowired
	private JogoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Jogo> find(@PathVariable Integer id) {
		Jogo jogo = service.findId(id);
		return ResponseEntity.ok().body(jogo);
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<JogoDTO>> findAll() {
		List<Jogo> list = service.findAll();
		List<JogoDTO> listDTO = list.stream().map(obj -> new JogoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/createJogo", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public ResponseEntity<Jogo> insert(@RequestBody JogoDTO objDto) {
		Jogo jogo = new Jogo();
		jogo = service.fromDTO(objDto);
		
		//String msg = "";
		//msg = service.insertVerifica(time);
		//if (msg.equals("OK")) {
		jogo = service.insert(jogo);
		//}
		//System.err.println(msg);		
		return ResponseEntity.ok().body(jogo);
	}
/*
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
*/
	@RequestMapping(value = "/updateJogo", method = RequestMethod.POST)
	public ResponseEntity<Jogo> update(@Valid @RequestBody Jogo objDto) {
		service.update(objDto);
		System.err.println("*** updateJogo:");
		System.err.println(objDto.getId());
		URI uri = null;
		System.err.println(ResponseEntity.created(uri).build());
		return ResponseEntity.ok().body(objDto);

	}
/*
	@RequestMapping(value = "/updateTimeOk", method = RequestMethod.POST)
	@CrossOrigin(origins = "*")
	public ResponseEntity<String> updateOK(@RequestBody Time objDto) {
		String msg = "";
		msg = service.updateVerifica(objDto).toString();
		System.err.println(msg);
		return ResponseEntity.ok().body(msg);
	}

*/	@RequestMapping(value = "/deleteJogo", method = RequestMethod.POST)
	public ResponseEntity<Jogo> delete(@Valid @RequestBody Integer id) {
		Jogo jogo = new Jogo();
		jogo = null;
		System.err.println("*** deleteUsuario: objDto." + "id=" + id);

		try {
			service.delete(id);
		} catch (Exception e) {
			System.err.println(e);
			jogo = service.findId(id);
		}
		return ResponseEntity.ok().body(jogo);
	}
	
}
