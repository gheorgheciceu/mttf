package com.ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.entity.Credit;

public  interface CreditRepository extends JpaRepository<Credit, Integer> {

}
