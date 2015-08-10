package com.ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ps.entity.Operation;
import com.ps.entity.OperationType;

public interface OperationTypeRepository extends JpaRepository<OperationType, Integer> {
	@Query("Select o from OperationType o where o.type=:type")
	public OperationType findOne(@Param("type")String type);
}
