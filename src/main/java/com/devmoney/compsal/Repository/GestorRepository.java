package com.devmoney.compsal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devmoney.compsal.domain.Gestor;

@Repository
public interface GestorRepository extends JpaRepository<Gestor, Integer> {

}
