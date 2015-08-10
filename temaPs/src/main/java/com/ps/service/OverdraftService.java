package com.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.entity.Account;
import com.ps.entity.Credit;
import com.ps.entity.Overdraft;
import com.ps.repository.AccountRepository;
import com.ps.repository.CreditRepository;
import com.ps.repository.OverdraftRepository;

@Service
public class OverdraftService implements CreditHandler {

	private CreditHandler next;

	@Autowired
	private CreditRepository creditRepository;
	
	@Autowired
	private OverdraftRepository overdraftRepository;
	
	@Autowired
	private AccountRepository accountRepository;

	public void repay(Credit c, int ammount) {

		if (c instanceof Overdraft) {
			System.out.println("OVERDRAFT repay");
			Overdraft o = (Overdraft) c;
			Account acc = o.getAccount();
			acc.setBalance(acc.getBalance()-ammount+(int)(ammount*o.getInterestRate()));
			o.setAccount(acc);
			
			creditRepository.save(o);
			//overdraftRepository.save(o);
			accountRepository.save(acc);
		} else if (this.next != null) {
			this.next.repay(c, ammount);
		}

	}

	@Override
	public void setNextHandler(CreditHandler c) {
		this.next = c;

	}

}
