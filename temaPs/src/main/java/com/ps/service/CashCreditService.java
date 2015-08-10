package com.ps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.entity.CashCredit;
import com.ps.entity.Credit;
import com.ps.repository.CreditRepository;

@Service
public class CashCreditService implements CreditHandler{

	@Autowired
	private LoanService loanService;
	
	@Autowired
	private CreditRepository creditRepository;

	
	private CreditHandler next;

	public void repay(Credit c, int ammount) {

		if (c instanceof CashCredit) {
			System.out.println("CASH CREDT REPAY");
			CashCredit cred  =(CashCredit)c;
			cred.setAmmountTaken(cred.getAmmountTaken()-ammount);
			
			creditRepository.save(cred);
		} else if(this.next != null){
			this.next.repay(c, ammount);
		}

	}

	@Override
	public void setNextHandler(CreditHandler c) {
		this.next = c;
		
	}

	

}
