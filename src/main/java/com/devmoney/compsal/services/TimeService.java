package com.devmoney.compsal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmoney.compsal.Repository.TimeRepository;
import com.devmoney.compsal.Repository.UsuarioRepository;
import com.devmoney.compsal.domain.Time;
import com.devmoney.compsal.domain.UsuarioNew;
import com.devmoney.compsal.dto.TimeDTO;

@Service
public class TimeService {
	
	@Autowired
	private TimeRepository repo;
	private UsuarioService UsuService;
	
	public Time findId(Integer id) {
		Optional<Time> obj = repo.findById(id);
		return obj.orElse(null);
	}	
	
	public List<Time> findAll() {
		return repo.findAll();
	}
	
	public Time findByGoleiro(Integer id) {
		
		return repo.findByGoleiro(id);
	}
	
	public Time findByFixo(Integer id) {
		
		return repo.findByFixo(id);
	}
	
	public Time findByAlaDireita(Integer id) {
	
	return repo.findByAlaDireita(id);
	}
	
	public Time findByAlaEsquerda(Integer id) {
		
		return repo.findByAlaEsquerda(id);
		}
	
	public Time findByPivo(Integer id) {
		
		return repo.findByPivo(id);
	}
	
	public Time findByTreinador(Integer id) {
		
		return repo.findByTreinador(id);
	}
	
	public Time findByMassagista(Integer id) {
	
	return repo.findByMassagista(id);
	}
	
	public Time findByJogadorReserva1(Integer id) {
	
	return repo.findByJogadorReserva1(id);
	}
	
	public Time findByJogadorReserva2(Integer id) {
	
	return repo.findByJogadorReserva2(id);
	}
	
	public Time findByJogadorReserva3(Integer id) {
	
	return repo.findByJogadorReserva3(id);
	}
	
	public Time findByJogadorReserva4(Integer id) {
	
	return repo.findByJogadorReserva4(id);
	}
	
	public Time findByJogadorReserva5(Integer id) {
	
	return repo.findByJogadorReserva5(id);
	}	
	
	public Time insert(Time obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Time update(Time obj) {
		System.err.println("*** update:");
		Time newObj = findId(obj.getId());
		updateTime(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		findId(id);
		repo.deleteById(id);
	}	
	
	public Time fromDTO(TimeDTO objDto) {
		return new Time(null, objDto.getNome(), objDto.getGenero(), 
				objDto.getGoleiro(),
				objDto.getFixo(), 
				objDto.getAlaDireita(), 
				objDto.getAlaEsquerda(),
				objDto.getPivo(),
				objDto.getTreinador(),
				objDto.getMassagista(),
				objDto.getJogadorReserva1(),
				objDto.getJogadorReserva2(),
				objDto.getJogadorReserva3(),
				objDto.getJogadorReserva4(),
				objDto.getJogadorReserva5()
				);
	}
	
	public String insertVerifica(Time obj) {
		Time num2 = new Time();
		ArrayList<Integer> pessoas = new ArrayList<Integer>();
	    pessoas.add(obj.getGoleiro());
	    pessoas.add(obj.getFixo());
	    pessoas.add(obj.getAlaDireita());
	    pessoas.add(obj.getAlaEsquerda());
	    pessoas.add(obj.getPivo());
	    pessoas.add(obj.getTreinador());
	    pessoas.add(obj.getMassagista());
	    pessoas.add(obj.getJogadorReserva1());
	    pessoas.add(obj.getJogadorReserva2());
	    pessoas.add(obj.getJogadorReserva3());
	    pessoas.add(obj.getJogadorReserva4());
	    pessoas.add(obj.getJogadorReserva5());
				
	    Boolean pessoaOk;
	    pessoaOk = true;
	    
	    String mensagens = "";
		String msg = "";
		try {
			if (repo.findByGoleiro(id) != null) {
				num2 = repo.findByGoleiro(id);
				System.err.println(num2.getNome());
				msg = "O usuário já está cadastro como Goleiro no Time " + num2.getNome();
				return msg;
			} else if (repo.findByFixo(id) != null) {
				num2 = repo.findByFixo(id);
				System.err.println(num2.getNome());
				msg = "O usuário já está cadastro como Fixo no Time " + num2.getNome();
				return msg;
			}else if (repo.findByAlaDireita(id) != null) {
				num2 = repo.findByAlaDireita(id);
				System.err.println(num2.getNome());
				msg = "O usuário já está cadastro como Ala Direita no Time " + num2.getNome();
				return msg;
			}else if (repo.findByAlaEsquerda(id) != null) {
				num2 = repo.findByAlaEsquerda(id);
				System.err.println(num2.getNome());
				msg = "O usuário já está cadastro como Ala Esquerda no Time " + num2.getNome();
				return msg;
			}else if (repo.findByPivo(id) != null) {
				num2 = repo.findByPivo(id);
				System.err.println(num2.getNome());
				msg = "O usuário já está cadastro como Pivô no Time " + num2.getNome();
				return msg;
			}else if (repo.findByTreinador(id) != null) {				
				num2 = repo.findByTreinador(id);
				System.err.println(num2.getNome());
				msg = "O usuário já está cadastro como Treinador no Time " + num2.getNome();
				return msg;
			}else if (repo.findByMassagista(id) != null) {				
				num2 = repo.findByMassagista(id);
				System.err.println(num2.getNome());
				msg = "O usuário já está cadastro como Massagista no Time " + num2.getNome();
				return msg;
			}else if (repo.findByJogadorReserva1(id) != null) {				
				num2 = repo.findByJogadorReserva1(id);
				System.err.println(num2.getNome());
				msg = "O usuário já está cadastro como Jogador Reserva 1 no Time " + num2.getNome();
				return msg;
			}else if (repo.findByJogadorReserva2(id) != null) {
				num2 = repo.findByJogadorReserva2(id);
				System.err.println(num2.getNome());
				msg = "O usuário já está cadastro como Jogador Reserva 2 no Time " + num2.getNome();
				return msg;
			}else if (repo.findByJogadorReserva3(id) != null) {
				num2 = repo.findByJogadorReserva3(id);
				System.err.println(num2.getNome());
				msg = "O usuário já está cadastro como Jogador Reserva 3 no Time " + num2.getNome();
				return msg;
			}else if (repo.findByJogadorReserva4(id) != null) {
				num2 = repo.findByJogadorReserva4(id);
				System.err.println(num2.getNome());
				msg = "O usuário já está cadastro como Jogador Reserva 4 no Time " + num2.getNome();
				return msg;
			}else if (repo.findByJogadorReserva5(id) != null) {
				num2 = repo.findByJogadorReserva5(id);
				System.err.println(num2.getNome());
				msg = "O usuário já está cadastro como Jogador Reserva 5 no Time " + num2.getNome();
				return msg;
			}else {
				return "OK";
			}
			
		} catch (Exception e) {
			return "Erro: " + e.getMessage();
		} 		
		
		for (int i = 0; i < 12 && pessoaOk; i++) {
		      for (int j = 0; j < 12; j++) {
		        if (i != j) {
		          if (pessoas.get(i) == pessoas.get(j) && pessoas.get(i) != null) {
		        	  System.err.println("Pessoa duplicada. i=" + i + "-Id=" + pessoas.get(i) + ", j=" + j + "-Id=" + pessoas.get(j));
		            pessoaOk = false;
		            mensagens += pessoas.get(i);
		            //break;
		          }
		        }
		      }
		    }
		/*if (!pessoaOk) {
		      this.compsalService.detalharUsuario(mensagens).subscribe((result: any) => {
		        console.log(result);
		        this.Alerta("Existe usuários repitidos!!!<br><br>" 
		        + "ID: " + result.id 
		        + "<br>CPF: " + result.cpf
		        + "<br>Nome : " + result.nome);
		      });      
		    } else {
		      
		    }*/
	}
		
	
	public void updateTime(Time newObj, Time obj) {
		System.err.println("*** updateTme:");
		//newObj.setNome(obj.getNome()); //Não pode alterar
		//newObj.setGenero(obj.getGenero());//Não pode alterar
		newObj.setGoleiro(obj.getGoleiro());
		newObj.setFixo(obj.getFixo());
		newObj.setAlaDireita(obj.getAlaDireita());
		newObj.setAlaEsquerda(obj.getAlaEsquerda());
		newObj.setPivo(obj.getPivo());
		newObj.setTreinador(obj.getTreinador());
		newObj.setMassagista(obj.getMassagista());
		newObj.setJogadorReserva1(obj.getJogadorReserva1());
		newObj.setJogadorReserva2(obj.getJogadorReserva2());
		newObj.setJogadorReserva3(obj.getJogadorReserva3());
		newObj.setJogadorReserva4(obj.getJogadorReserva4());
		newObj.setJogadorReserva5(obj.getJogadorReserva5());
				
	}
	
}
