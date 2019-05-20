package com.devmoney.compsal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmoney.compsal.Repository.JogoRepository;
import com.devmoney.compsal.Repository.TimeRepository;
import com.devmoney.compsal.Repository.UsuarioRepository;
import com.devmoney.compsal.domain.Time;
import com.devmoney.compsal.domain.UsuarioNew;
import com.devmoney.compsal.dto.UsuarioDTO;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	@Autowired
	private TimeRepository repoTime;
	@Autowired
	private JogoRepository repoJogo;
	
	public UsuarioNew findId(Integer id) {
		Optional<UsuarioNew> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public UsuarioNew findCpf(String cpf) {
		Optional<UsuarioNew> obj = repo.findByCpf(cpf);
		return obj.orElse(null);
	}
	
	public List<UsuarioNew> findAll() {
		return repo.findAll();
	}
	
	public List<UsuarioNew> findBySexoM() {
		
		return repo.findBySexo("M");
	}
	
	public List<UsuarioNew> findBySexoF() {
		
		return repo.findBySexo("F");
	}
		
	public UsuarioNew insert(UsuarioNew obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public UsuarioNew update(UsuarioNew obj) {
		System.err.println("*** update:");
		UsuarioNew newObj = findId(obj.getId());
		updateUsuario(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		findId(id);
		repo.deleteById(id);
	}
	
	public String deleteVerifica(Integer id) {
		Time num2 = new Time();
		//Optional<Time> time = repoTime.findById(id);
		String msg = "";
		try {
			if (repoTime.findByGoleiro(id) != null) {
				num2 = repoTime.findByGoleiro(id);
				System.err.println(num2.getNome());
				msg = "O usuário não pode ser excluído pois está cadastrado como Goleiro no Time " + num2.getNome();
				return msg;
			} else if (repoTime.findByFixo(id) != null) {
				num2 = repoTime.findByFixo(id);
				System.err.println(num2.getNome());
				msg = "O usuário não pode ser excluído pois está cadastrado como Fixo no Time " + num2.getNome();
				return msg;
			}else if (repoTime.findByAlaDireita(id) != null) {
				num2 = repoTime.findByAlaDireita(id);
				System.err.println(num2.getNome());
				msg = "O usuário não pode ser excluído pois está cadastrado como Ala Direita no Time " + num2.getNome();
				return msg;
			}else if (repoTime.findByAlaEsquerda(id) != null) {
				num2 = repoTime.findByAlaEsquerda(id);
				System.err.println(num2.getNome());
				msg = "O usuário não pode ser excluído pois está cadastrado como Ala Esquerda no Time " + num2.getNome();
				return msg;
			}else if (repoTime.findByPivo(id) != null) {
				num2 = repoTime.findByPivo(id);
				System.err.println(num2.getNome());
				msg = "O usuário não pode ser excluído pois está cadastrado como Pivô no Time " + num2.getNome();
				return msg;
			}else if (repoTime.findByTreinador(id) != null) {				
				num2 = repoTime.findByTreinador(id);
				System.err.println(num2.getNome());
				msg = "O usuário não pode ser excluído pois está cadastrado como Treinador no Time " + num2.getNome();
				return msg;
			}else if (repoTime.findByMassagista(id) != null) {				
				num2 = repoTime.findByMassagista(id);
				System.err.println(num2.getNome());
				msg = "O usuário não pode ser excluído pois está cadastrado como Massagista no Time " + num2.getNome();
				return msg;
			}else if (repoTime.findByJogadorReserva1(id) != null) {				
				num2 = repoTime.findByJogadorReserva1(id);
				System.err.println(num2.getNome());
				msg = "O usuário não pode ser excluído pois está cadastrado como Jogador Reserva 1 no Time " + num2.getNome();
				return msg;
			}else if (repoTime.findByJogadorReserva2(id) != null) {
				num2 = repoTime.findByJogadorReserva2(id);
				System.err.println(num2.getNome());
				msg = "O usuário não pode ser excluído pois está cadastrado como Jogador Reserva 2 no Time " + num2.getNome();
				return msg;
			}else if (repoTime.findByJogadorReserva3(id) != null) {
				num2 = repoTime.findByJogadorReserva3(id);
				System.err.println(num2.getNome());
				msg = "O usuário não pode ser excluído pois está cadastrado como Jogador Reserva 3 no Time " + num2.getNome();
				return msg;
			}else if (repoTime.findByJogadorReserva4(id) != null) {
				num2 = repoTime.findByJogadorReserva4(id);
				System.err.println(num2.getNome());
				msg = "O usuário não pode ser excluído pois está cadastrado como Jogador Reserva 4 no Time " + num2.getNome();
				return msg;
			}else if (repoTime.findByJogadorReserva5(id) != null) {
				num2 = repoTime.findByJogadorReserva5(id);
				System.err.println(num2.getNome());
				msg = "O usuário não pode ser excluído pois está cadastrado como Jogador Reserva 5 no Time " + num2.getNome();
				return msg;
			}else if (repoJogo.findByArbitroPrincipal(id).size() > 0) {				
				msg = "O usuário não pode ser excluído pois está cadastrado como Árbitro Principal em um ou mais Jogos";
				return msg;
			}else if (repoJogo.findByArbitroAuxiliar(id).size() > 0) {					
				msg = "O usuário não pode ser excluído pois está cadastrado como Árbitro Auxiliar em um ou mais Jogos";
				return msg;
			}else if (repoJogo.findByAnotador(id) != null) {	 			
				msg = "O usuário não pode ser excluído pois está cadastrado como Anotador em um ou mais Jogos";
				return msg;
			}else {
				return "OK";
			}
			
		} catch (Exception e) {
			return "Erro: " + e.getMessage();
		} 		
	}
	
	public UsuarioNew fromDTO(UsuarioDTO objDto) {
		return new UsuarioNew(null, objDto.getNome(), objDto.getCpf(),
				objDto.getApelido(), 
				objDto.getSexo(), 
				objDto.getDtNascimento(),
				objDto.getTelefone(),
				objDto.getEmail(),
				objDto.getEndereco(),
				objDto.getNumeroEnd(),
				objDto.getCep(),
				objDto.getBairro(),
				objDto.getMunicipio(),
				objDto.getUf());
	}
	
	public void updateUsuario(UsuarioNew newObj, UsuarioNew obj) {
		System.err.println("*** updateUsuario:");
		newObj.setNome(obj.getNome());
		newObj.setCpf(obj.getCpf()); ///// não alterar
		newObj.setApelido(obj.getApelido());
		newObj.setSexo(obj.getSexo());		
		newObj.setDtNascimento(obj.getDtNascimento());
		newObj.setTelefone(obj.getTelefone());
		newObj.setEmail(obj.getEmail());
		newObj.setEndereco(obj.getEndereco());
		newObj.setNumeroEnd(obj.getNumeroEnd());
		newObj.setCep(obj.getCep());
		newObj.setBairro(obj.getBairro());
		newObj.setMunicipio(obj.getMunicipio());
		newObj.setUf(obj.getUf());
		
		//repo.update();
		
	// xxxxxxxxxx termina....	
		
		
		
	}
	
}
