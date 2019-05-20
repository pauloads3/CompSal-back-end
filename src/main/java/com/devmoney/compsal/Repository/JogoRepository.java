package com.devmoney.compsal.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmoney.compsal.domain.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Integer> {

	
	List<Jogo> findByAnotador(Integer id);

	List<Jogo> findByArbitroPrincipal(Integer id);

	List<Jogo> findByArbitroAuxiliar(Integer id);

	 		
}
