package com.devmoney.compsal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmoney.compsal.domain.UsuarioNew;

public interface UsuarioRepository extends JpaRepository<UsuarioNew, Integer> {
	
	
	
}
