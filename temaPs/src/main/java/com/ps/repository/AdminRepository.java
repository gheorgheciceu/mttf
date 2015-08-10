package com.ps.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ps.entity.Admin;
import com.ps.entity.User;


public interface AdminRepository extends JpaRepository<Admin, Integer> {

	@Modifying
	@Transactional
	@Query("update Admin a set a.password=:password where a.email = :email")
	public void changePassword(@Param("password") String newPassword,
			@Param("email") String email);

	@Modifying
	@Transactional
	@Query("update Admin a set a.email=:oldEmail where a.email = :newEmail")
	public void changeEmail(@Param("oldEmail") String oldEmail,
			@Param("newEmail") String newEmail);

	@Query("select a from Admin a where a.email = :email")
	public Admin findByEmail(@Param("email") String name);

	@Query("select a from Admin a where upper(a.firstName) = :name")
	public List<Admin> findByFirstName(@Param("name") String trim);

	@Query("select a from Admin a where upper(a.lastName) = :name")
	public List<Admin> findByLastName(@Param("name") String trim);

	@Query("select a from Admin a where upper(a.lastName) = :lname and upper(a.firstName) =:fname")
	public List<Admin> findByFullName(@Param("fname") String firstName,
			@Param("lname") String lastName);

	@Query("select a from Admin a where a.email = :email")
	public Admin getAdminByEmail(@Param("email") String email);
	
/*	@Query("select a from Admin a where a.email = :email and a.password=: password")
	public Admin findByEmailAndPassword(@Param("email")String email, @Param("password")String password);*/

}
