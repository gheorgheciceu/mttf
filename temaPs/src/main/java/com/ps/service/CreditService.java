package com.ps.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.entity.Account;
import com.ps.entity.CashCredit;
import com.ps.entity.Credit;
import com.ps.entity.Customer;
import com.ps.entity.Loan;
import com.ps.entity.Overdraft;
import com.ps.repository.CreditRepository;
import com.ps.repository.CustomerRepository;

@Service
public class CreditService {

	@Autowired
	private CreditRepository creditRepository;
	
	@Autowired
	private CashCreditService cashCreditService;
	@Autowired
	private	LoanService loanService;
	@Autowired
	private OverdraftService overdraftService;

	@Autowired
	private CustomerRepository customerRepository;

	public Credit getCredit(String type) {
		if (type.equals("LOAN")) {
			return new Loan();
		}

		if (type.equals("CASHCREDIT")) {
			return new CashCredit();
		}
		if (type.equals("OVERDRAFT")) {
			return new Overdraft();
		}
		return null;
	}

	public void repay(int creditId, int ammount) {
		Credit c = creditRepository.findOne(creditId);

		

		overdraftService.setNextHandler(cashCreditService);
		cashCreditService.setNextHandler(loanService);

		overdraftService.repay(c, ammount);

	}

	public List<CashCredit> getCashCredits() {
		List<CashCredit> cash = new ArrayList<CashCredit>();
		for (Credit c : creditRepository.findAll()) {
			if (c instanceof CashCredit) {
				CashCredit cr = (CashCredit) c;
				cash.add(cr);
			}
		}
		return cash;
	}

	public List<Loan> getLoans() {
		List<Loan> cash = new ArrayList<Loan>();
		for (Credit c : creditRepository.findAll()) {
			if (c instanceof Loan) {
				Loan cr = (Loan) c;
				cash.add(cr);
			}
		}
		return cash;
	}

	public List<Overdraft> getOverdrafts() {
		List<Overdraft> cash = new ArrayList<Overdraft>();
		for (Credit c : creditRepository.findAll()) {
			if (c instanceof Overdraft) {
				Overdraft cr = (Overdraft) c;
				cash.add(cr);
			}
		}
		return cash;
	}

	public void save(Credit credit, int id) {

		credit.setCustomer(customerRepository.findOne(id));
		credit.setCreationDate(new Date());

		creditRepository.save(credit);
	}

	public void saveOverdraft(Overdraft credit, int id, int amm) {
		Customer cust = customerRepository.findOne(id);
		credit.setCustomer(cust);
		credit.setCreationDate(new Date());
		if (cust.getAccounts() != null) {
			Account acc = cust.getAccounts().get(0);
			acc.setBalance(acc.getBalance()+amm);
			credit.setAccount(acc);
			customerRepository.save(cust);
		} 
		creditRepository.save(credit);
	}
}
