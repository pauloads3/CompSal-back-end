package com.devmoney.compsal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmoney.compsal.Repository.JogoRepository;
import com.devmoney.compsal.Repository.TimeRepository;
import com.devmoney.compsal.Repository.UsuarioRepository;
import com.devmoney.compsal.domain.Jogo;
import com.devmoney.compsal.domain.Time;
import com.devmoney.compsal.domain.UsuarioNew;
import com.devmoney.compsal.dto.TimeDTO;

@Service
public class TimeService {

	@Autowired
	private TimeRepository repo;
	@Autowired
	private UsuarioService UsuService;
	@Autowired
	private JogoRepository repoJogo;

	public Time findId(Integer id) {
		Optional<Time> obj = repo.findById(id);
		return obj.orElse(null);
	}

	public List<Time> findAll() {
		return repo.findAll();
	}

	public List<Integer> findAllNotJogadores() {
		List<Time> times ;
		times = repo.findAll();
		ArrayList<Integer> pessoas = new ArrayList<Integer>();
		ArrayList<Integer> usuarios = new ArrayList<Integer>();		
		for (int i = 0; i < times.size(); i++) {
			pessoas.add(times.get(i).getGoleiro());
			pessoas.add(times.get(i).getFixo());
			pessoas.add(times.get(i).getAlaDireita());
			pessoas.add(times.get(i).getAlaEsquerda());
			pessoas.add(times.get(i).getPivo());
			pessoas.add(times.get(i).getTreinador());
			pessoas.add(times.get(i).getMassagista());
			pessoas.add(times.get(i).getJogadorReserva1());
			pessoas.add(times.get(i).getJogadorReserva2());
			pessoas.add(times.get(i).getJogadorReserva3());
			pessoas.add(times.get(i).getJogadorReserva4());
			pessoas.add(times.get(i).getJogadorReserva5());			
		}			
		
		for (int i = 0; i < pessoas.size(); i++) {			
			if (pessoas.get(i) != null) {
				usuarios.add(pessoas.get(i));				
			}
		}		
		return usuarios;
	}

	public List<Time> findByGeneroM() {

		return repo.findByGenero("M");
	}

	public List<Time> findByGeneroF() {

		return repo.findByGenero("F");
	}
	/*
	 * public List<Time> findByGoleiroOrFixoOrAlaDireitaNotNull() {
	 * 
	 * return repo.findAllByFixoIsNull(); }
	 */

	public Time findByNomeAndGenero(String nome, String genero) {

		return repo.findByNomeAndGenero(nome, genero);
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
		return new Time(null, objDto.getNome().toUpperCase(), objDto.getGenero(), objDto.getGoleiro(), objDto.getFixo(),
				objDto.getAlaDireita(), objDto.getAlaEsquerda(), objDto.getPivo(), objDto.getTreinador(),
				objDto.getMassagista(), objDto.getJogadorReserva1(), objDto.getJogadorReserva2(),
				objDto.getJogadorReserva3(), objDto.getJogadorReserva4(), objDto.getJogadorReserva5());
	}

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

	public String deleteVerifica(Integer id) {

		Time time = findId(id);
		System.err.println(time.getNome());

		String msg = "";
		try {
			if (repoJogo.findByTimeA(time.getNome()).size() > 0) {
				System.err.println(time.getNome());
				msg = "O Time não pode ser excluído pois está cadastrado em um ou mais Jogos";
				return msg;
			} else if (repoJogo.findByTimeB(time.getNome()).size() > 0) {
				System.err.println(time.getNome());
				msg = "O Time não pode ser excluído pois está cadastrado em um ou mais Jogos";
				return msg;
			} else {
				return "OK";
			}

		} catch (Exception e) {
			return "Erro: " + e.getMessage();
		}
	}

	public void updateTime(Time newObj, Time obj) {
		System.err.println("*** updateTme:");
		// newObj.setNome(obj.getNome()); //Não pode alterar
		// newObj.setGenero(obj.getGenero());//Não pode alterar
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
