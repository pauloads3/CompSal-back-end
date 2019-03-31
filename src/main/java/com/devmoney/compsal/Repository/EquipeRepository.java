package com.devmoney.compsal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmoney.compsal.domain.Equipe;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Integer> {

}
