package com.devmoney.compsal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmoney.compsal.domain.Jogador;

@Repository //Annotation coloado para o 'Spring' saber que essa classe sera um repositorio
public interface JogadorRepository extends JpaRepository<Jogador, Integer> {
	
	
	
}
