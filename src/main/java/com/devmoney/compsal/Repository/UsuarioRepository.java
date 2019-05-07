package com.devmoney.compsal.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmoney.compsal.domain.UsuarioNew;

public interface UsuarioRepository extends JpaRepository<UsuarioNew, Integer> {

	Optional<UsuarioNew> findByCpf(String cpf);
	
		
}
