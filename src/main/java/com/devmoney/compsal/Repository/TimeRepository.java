package com.devmoney.compsal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devmoney.compsal.domain.Time;

public interface TimeRepository extends JpaRepository<Time, Integer> {

}
