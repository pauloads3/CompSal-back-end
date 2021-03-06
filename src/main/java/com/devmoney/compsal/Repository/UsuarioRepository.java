package com.devmoney.compsal.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmoney.compsal.domain.UsuarioNew;

public interface UsuarioRepository extends JpaRepository<UsuarioNew, Integer> {

	Optional<UsuarioNew> findByCpf(String cpf);

	List<UsuarioNew> findBySexo(String string);

	List<UsuarioNew> findAllByOrderByIdDesc();

	List<UsuarioNew> findAllByOrderByNomeDesc();

	List<UsuarioNew> findAllByOrderByNomeAsc();

	List<UsuarioNew> findBySexoNotIn(String string);

	List<UsuarioNew> findBySexoAndIdNotIn(String string, List<Integer> findAllNotJogadores);  

	 
	
	
		
}
