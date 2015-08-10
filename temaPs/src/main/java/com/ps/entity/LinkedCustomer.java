package com.ps.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("1")
public class LinkedCustomer extends Customer {

	@ManyToMany
	private List<Customer> linkedCustomers;

	private int operationsLimit;

	private int transactionLimit;

	private int operations;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id")
	private Account account;

	public List<Customer> getLinkedCustomers() {
		return linkedCustomers;
	}

	public void setLinkedCustomers(List<Customer> linkedCustomers) {
		this.linkedCustomers = linkedCustomers;
	}

	public int getOperationsLimit() {
		return operationsLimit;
	}

	public void setOperationsLimit(int operationsLimit) {
		this.operationsLimit = operationsLimit;
	}

	public int getTransactionLimit() {
		return transactionLimit;
	}

	public void setTransactionLimit(int transactionLimit) {
		this.transactionLimit = transactionLimit;
	}

	public int getOperations() {
		return operations;
	}

	public void setOperations(int operations) {
		this.operations = operations;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	

}
