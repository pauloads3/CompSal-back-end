package com.devmoney.compsal.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmoney.compsal.domain.Eventos;

public interface EventosRepository extends JpaRepository<Eventos, Integer> {

	List<Eventos> findByTipo(String string);

	List<Eventos> findByTipoAndIdJogoAndNomeTime(String string, Integer idJogo, String nomeTime);

	
}
