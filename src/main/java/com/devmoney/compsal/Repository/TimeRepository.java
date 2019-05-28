package com.devmoney.compsal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmoney.compsal.domain.Time;

public interface TimeRepository extends JpaRepository<Time, Integer> {

	Time findByGoleiro(Integer i);

	Time findByFixo(Integer i);

	Time findByAlaDireita(Integer i);

	Time findByAlaEsquerda(Integer i);

	Time findByPivo(Integer id);

	Time findByTreinador(Integer id);

	Time findByMassagista(Integer id);

	Time findByJogadorReserva1(Integer id);

	Time findByJogadorReserva2(Integer id);

	Time findByJogadorReserva3(Integer id);

	Time findByJogadorReserva4(Integer id);

	Time findByJogadorReserva5(Integer id);

	Time findByNomeAndGenero(String nome, String genero);

	List<Time> findByGenero(String string);
	
	List<Time> findAllByFixoIsNull(); 
	
	List<Time> findAllByGoleiroIsNull(); 
	
	List<Time> findByGoleiroOrFixoOrAlaDireitaOrAlaEsquerdaOrPivo(Integer id, Integer id2 , Integer id3, Integer id4, Integer id5); 
	
	List<Time> findAllByGoleiroOrFixoOrAlaDireitaOrAlaEsquerdaIsNullOrPivoIsNull(Integer id, Integer id2 , Integer id3);

	
}
