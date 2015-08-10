package com.ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.entity.Overdraft;

public interface OverdraftRepository extends JpaRepository<Overdraft, Integer> {

}
