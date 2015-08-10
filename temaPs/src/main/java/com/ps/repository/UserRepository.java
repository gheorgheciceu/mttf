package com.ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ps.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.username = :email")
	public User findByEmail(@Param("email")String email);

	@Query("select u from User u where u.username = :email and u.password=:password")
	public User findByEmailAndPassword(@Param("email")String email, @Param("password")String password);
	
	
}
