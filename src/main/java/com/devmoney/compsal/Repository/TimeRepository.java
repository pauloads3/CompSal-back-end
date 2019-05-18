package com.devmoney.compsal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmoney.compsal.domain.Time;
import com.devmoney.compsal.domain.UsuarioNew;

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
	

	

}
