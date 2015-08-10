package com.ps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.entity.Account;
import com.ps.entity.Customer;
import com.ps.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public void save(Customer customer) {
		/*List<Account> list = new ArrayList<Account>();
		customer.setAccounts(list);*/
		customer.setAccounts(new ArrayList<Account>());
		customerRepository.save(customer);
		
	}

	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	public Customer findOne(int id) {
		// TODO Auto-generated method stub
		return customerRepository.findOne(id);
	}

}
