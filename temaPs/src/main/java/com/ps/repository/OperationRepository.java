package com.ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ps.entity.Operation;

public interface OperationRepository extends JpaRepository<Operation, Integer> {

	
	
}
