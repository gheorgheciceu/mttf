package com.ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ps.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	@Query("select r from Role r where r.roleName = :role")
	Role getRole(@Param("role")String string);

}
