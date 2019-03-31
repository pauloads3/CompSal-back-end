package com.devmoney.compsal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmoney.compsal.domain.Anotador;

@Repository
public interface AnotadorRepository extends JpaRepository<Anotador, Integer> {

}
