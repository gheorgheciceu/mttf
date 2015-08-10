package com.ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
