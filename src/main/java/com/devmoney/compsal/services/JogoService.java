package com.devmoney.compsal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmoney.compsal.Repository.JogoRepository;
import com.devmoney.compsal.domain.Jogo;
import com.devmoney.compsal.domain.Time;
import com.devmoney.compsal.dto.JogoDTO;

@Service
public class JogoService {

	@Autowired
	private JogoRepository repo;
	
	public Jogo findId(Integer id) {
		Optional<Jogo> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public List<Jogo> findAll() {
		return repo.findAll();
	}

	public List<Jogo> findByArbitroPrincipal(Integer id) {

		return repo.findByArbitroPrincipal(id);
	}
	
	public List<Jogo> findByArbitroAuxiliar(Integer id) {

		return repo.findByArbitroAuxiliar(id);
	}
	public List<Jogo> findByAnotador(Integer id) {

		return repo.findByAnotador(id);
	}
	
	
	public Jogo insert(Jogo obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Jogo update(Jogo obj) {
		System.err.println("*** update:");
		Jogo newObj = findId(obj.getId());
		updateJogo(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		findId(id);
		repo.deleteById(id);
	}

	public Jogo fromDTO(JogoDTO objDto) {
		return new Jogo(null, objDto.getGenero(), objDto.getTimeA(), objDto.getTimeB(), objDto.getArbitroPrincipal(),
				objDto.getArbitroAuxiliar(), objDto.getAnotador(), objDto.getDataJogo(), objDto.getHorario(),
				objDto.getLocalJogo());
	}
	
	public void updateJogo(Jogo newObj, Jogo obj) {
		System.err.println("*** updateJogo:");
		newObj.setTimeA(obj.getTimeA());
		newObj.setTimeB(obj.getTimeB());
		newObj.setArbitroPrincipal(obj.getArbitroPrincipal());
		newObj.setArbitroAuxiliar(obj.getArbitroAuxiliar());
		newObj.setAnotador(obj.getAnotador());
		newObj.setDataJogo(obj.getDataJogo());
		newObj.setHorario(obj.getHorario());
		newObj.setLocalJogo(obj.getLocalJogo());
	}

	
	/*
	 * *
	 * *  Falta implementar	
	 * *
	 * / 
/*
	public String insertVerifica(Time obj) {
		Boolean pessoaOk;
		pessoaOk = true;
		String msg = "";

		if (repo.findByNomeAndGenero(obj.getNome(), obj.getGenero()) != null) {
			msg = "já existe um Time cadastrado com o mesmo Nome/Gênero <br><br> Nome: " + obj.getNome()
					+ "<br>Gênero: " + obj.getGenero();
		} else {
			Time time = new Time();
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

			for (int i = 0; i < 12 && pessoaOk; i++) {
				if (pessoas.get(i) != null) {
					time = repo.findByGoleiro(pessoas.get(i));
					if (time != null) {
						// if (pessoas.get(i) == time.getGoleiro()) {
						msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
								+ " já está cadastro como Goleiro no Time " + time.getNome();
						pessoaOk = false;
						System.err.println("*****" + msg);
						break;
						// }
					} else {
						time = repo.findByFixo(pessoas.get(i));
					}
					if (time != null) {
						msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
								+ " já está cadastro como Fixo no Time " + time.getNome();
						pessoaOk = false;
						System.err.println("*****" + msg);
						break;
					} else {
						time = repo.findByAlaDireita(pessoas.get(i));
					}
					if (time != null) {
						msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
								+ " já está cadastro como Ala Direita no Time " + time.getNome();
						pessoaOk = false;
						System.err.println("*****" + msg);
						break;
					} else {
						time = repo.findByAlaEsquerda(pessoas.get(i));
					}
					if (time != null) {
						msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
								+ " já está cadastro como Ala Esquerda no Time " + time.getNome();
						pessoaOk = false;
						System.err.println("*****" + msg);
						break;
					} else {
						time = repo.findByPivo(pessoas.get(i));
					}
					if (time != null) {
						msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
								+ " já está cadastro como Pivô no Time " + time.getNome();
						pessoaOk = false;
						System.err.println("*****" + msg);
						break;
					} else {
						time = repo.findByTreinador(pessoas.get(i));
					}
					if (time != null) {
						msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
								+ " já está cadastro como Treinador no Time " + time.getNome();
						pessoaOk = false;
						System.err.println("*****" + msg);
						break;
					} else {
						time = repo.findByMassagista(pessoas.get(i));
					}
					if (time != null) {
						msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
								+ " já está cadastro como Massagista no Time " + time.getNome();
						pessoaOk = false;
						System.err.println("*****" + msg);
						break;
					} else {
						time = repo.findByJogadorReserva1(pessoas.get(i));
					}
					if (time != null) {
						msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
								+ " já está cadastro como Jogador Reserva 1 no Time " + time.getNome();
						pessoaOk = false;
						System.err.println("*****" + msg);
						break;
					} else {
						time = repo.findByJogadorReserva2(pessoas.get(i));
					}
					if (time != null) {
						msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
								+ " já está cadastro como Jogador Reserva 2 no Time " + time.getNome();
						pessoaOk = false;
						System.err.println("*****" + msg);
						break;
					} else {
						time = repo.findByJogadorReserva3(pessoas.get(i));
					}
					if (time != null) {
						msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
								+ " já está cadastro como Jogador Reserva 3 no Time " + time.getNome();
						pessoaOk = false;
						System.err.println("*****" + msg);
						break;
					} else {
						time = repo.findByJogadorReserva4(pessoas.get(i));
					}
					if (time != null) {
						msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
								+ " já está cadastro como Jogador Reserva 4 no Time " + time.getNome();
						pessoaOk = false;
						System.err.println("*****" + msg);
						break;
					} else {
						time = repo.findByJogadorReserva5(pessoas.get(i));
					}
					if (time != null) {
						msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
								+ " já está cadastro como Jogador Reserva 5 no Time " + time.getNome();
						pessoaOk = false;
						System.err.println("*****" + msg);
						break;
					} else {
						msg = "OK";
					}
				}
			}
		}
		return msg;
	}

	public String updateVerifica(Time obj) {
		Boolean pessoaOk;
		pessoaOk = true;
		String msg = "";
		Time time = new Time();
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

		for (int i = 0; i < 12 && pessoaOk; i++) {
			if (pessoas.get(i) != null) {
				time = repo.findByGoleiro(pessoas.get(i));
				if (time != null && obj.getId() != time.getId()) {
					// if (pessoas.get(i) == time.getGoleiro()) {
					msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
							+ " já está cadastro como Goleiro no Time " + time.getNome();
					pessoaOk = false;
					System.err.println("*****" + msg);
					break;
					// }
				} else {
					time = repo.findByFixo(pessoas.get(i));
				}
				if (time != null && obj.getId() != time.getId()) {
					msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
							+ " já está cadastro como Fixo no Time " + time.getNome();
					pessoaOk = false;
					System.err.println("*****" + msg);
					break;
				} else {
					time = repo.findByAlaDireita(pessoas.get(i));
				}
				if (time != null && obj.getId() != time.getId()) {
					msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
							+ " já está cadastro como Ala Direita no Time " + time.getNome();
					pessoaOk = false;
					System.err.println("*****" + msg);
					break;
				} else {
					time = repo.findByAlaEsquerda(pessoas.get(i));
				}
				if (time != null && obj.getId() != time.getId()) {
					msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
							+ " já está cadastro como Ala Esquerda no Time " + time.getNome();
					pessoaOk = false;
					System.err.println("*****" + msg);
					break;
				} else {
					time = repo.findByPivo(pessoas.get(i));
				}
				if (time != null && obj.getId() != time.getId()) {
					msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
							+ " já está cadastro como Pivô no Time " + time.getNome();
					pessoaOk = false;
					System.err.println("*****" + msg);
					break;
				} else {
					time = repo.findByTreinador(pessoas.get(i));
				}
				if (time != null && obj.getId() != time.getId()) {
					msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
							+ " já está cadastro como Treinador no Time " + time.getNome();
					pessoaOk = false;
					System.err.println("*****" + msg);
					break;
				} else {
					time = repo.findByMassagista(pessoas.get(i));
				}
				if (time != null && obj.getId() != time.getId()) {
					msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
							+ " já está cadastro como Massagista no Time " + time.getNome();
					pessoaOk = false;
					System.err.println("*****" + msg);
					break;
				} else {
					time = repo.findByJogadorReserva1(pessoas.get(i));
				}
				if (time != null && obj.getId() != time.getId()) {
					msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
							+ " já está cadastro como Jogador Reserva 1 no Time " + time.getNome();
					pessoaOk = false;
					System.err.println("*****" + msg);
					break;
				} else {
					time = repo.findByJogadorReserva2(pessoas.get(i));
				}
				if (time != null && obj.getId() != time.getId()) {
					msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
							+ " já está cadastro como Jogador Reserva 2 no Time " + time.getNome();
					pessoaOk = false;
					System.err.println("*****" + msg);
					break;
				} else {
					time = repo.findByJogadorReserva3(pessoas.get(i));
				}
				if (time != null && obj.getId() != time.getId()) {
					msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
							+ " já está cadastro como Jogador Reserva 3 no Time " + time.getNome();
					pessoaOk = false;
					System.err.println("*****" + msg);
					break;
				} else {
					time = repo.findByJogadorReserva4(pessoas.get(i));
				}
				if (time != null && obj.getId() != time.getId()) {
					msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
							+ " já está cadastro como Jogador Reserva 4 no Time " + time.getNome();
					pessoaOk = false;
					System.err.println("*****" + msg);
					break;
				} else {
					time = repo.findByJogadorReserva5(pessoas.get(i));
				}
				if (time != null && obj.getId() != time.getId()) {
					msg = "O usuário " + UsuService.findId(pessoas.get(i)).getNome()
							+ " já está cadastro como Jogador Reserva 5 no Time " + time.getNome();
					pessoaOk = false;
					System.err.println("*****" + msg);
					break;
				} else {
					msg = "OK";
				}
			}
		}
		return msg;
	}
*/
	
}
