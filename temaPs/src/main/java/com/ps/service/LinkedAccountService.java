package com.ps.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.entity.Account;
import com.ps.entity.Customer;
import com.ps.entity.LinkedCustomer;
import com.ps.repository.AccountRepository;
import com.ps.repository.CustomerRepository;

@Service
public class LinkedAccountService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AccountRepository accountRepository;

	public void save(int id, int link1, int link2, int link3, int link4,
			int transactionLimit, int operationLimitLimit, Account account) {

		Customer cc = new LinkedCustomer();
		LinkedCustomer c = (LinkedCustomer) cc;

		c.setAccount(account);
		c.setOperations(0);
		c.setOperationsLimit(operationLimitLimit);
		c.setTransactionLimit(transactionLimit);

		Customer owner = customerRepository.findOne(id);
		c.setAdress(owner.getAdress());
		c.setCnp(owner.getCnp());
		c.setFirstName(owner.getFirstName());
		c.setLastName(owner.getLastName());
		c.setAccounts(null);

		List<Customer> links = new ArrayList<Customer>();
		links.add(customerRepository.findOne(link1));
		links.add(customerRepository.findOne(link2));
		links.add(customerRepository.findOne(link3));
		links.add(customerRepository.findOne(link4));

		c.setLinkedCustomers(links);
		cc.setId(getMax() + 1);
		System.out.println(cc.getId());
		customerRepository.save(cc);

	}

	public List<LinkedCustomer> findAll() {

		List<Customer> customers = customerRepository.findAll();
		List<LinkedCustomer> linked = new ArrayList<LinkedCustomer>();
		for (Customer c : customers) {
			if (c instanceof LinkedCustomer) {
				linked.add((LinkedCustomer) c);
			}
		}

		return linked;
	}

	public void delete(int id) {
		customerRepository.delete(id);

	}

	public int getMax() {
		int max = customerRepository.findAll().get(0).getId();

		for (Customer c : customerRepository.findAll()) {
			if (c.getId() > max) {
				max = c.getId();
			}
		}
		return max;
	}

	public LinkedCustomer findOne(int id) {

		LinkedCustomer l = null;
		try {
			l = (LinkedCustomer) customerRepository.findOne(id);
		} catch (Exception e) {

		}
		return l;
	}

	public List<Customer> findAllNonLinked() {
		List<Customer> c = new ArrayList<Customer>();

		for (Customer cu : customerRepository.findAll()) {
			if (!(cu instanceof LinkedCustomer)) {
				c.add(cu);
			}
		}
		return c;
	}

	public void transfer(int from, int to, int amount) {

		LinkedCustomer c1 = (LinkedCustomer) customerRepository.findOne(from);
		

		Account a1 = c1.getAccount();
		Account a2 = accountRepository.findOne(to);

		if (amount <= c1.getTransactionLimit()
				&& c1.getOperations() < c1.getOperationsLimit() && amount <= c1.getAccount().getBalance()) {
			a1.setBalance(a1.getBalance() - amount);
			a2.setBalance(a2.getBalance() + amount);
			c1.setOperations(c1.getOperations()+1);
		}

		c1.setAccount(a1);
	
		accountRepository.save(a2);
		customerRepository.save(c1);
		

	}

	public void save(LinkedCustomer customer, int link1, int link2, int link3,
			int link4) {
		List<Customer> links = new ArrayList<Customer>();
		links.add(customerRepository.findOne(link1));
		links.add(customerRepository.findOne(link2));
		links.add(customerRepository.findOne(link3));
		links.add(customerRepository.findOne(link4));

		customer.setLinkedCustomers(links);
		customerRepository.save(customer);
		
	}
}
