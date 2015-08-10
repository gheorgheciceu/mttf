package com.ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
