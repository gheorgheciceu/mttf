package com.ps.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.command.PaymentPlan;
import com.ps.entity.Credit;
import com.ps.entity.Loan;
import com.ps.repository.CreditRepository;

@Service
public class LoanService implements CreditHandler {

	@Autowired
	private CreditRepository creditRepository;

	@Autowired
	private PaymentPlan paymentPlan;
	
	private CreditHandler next;

	public void repay(Credit c, int ammount) {
		if (c instanceof Loan) {
			Loan l = (Loan) c;	
			paymentPlan.addPayment(ammount, l);
			Date d = new Date();
			Date creationDate = l.getCreationDate();
			creationDate.setDate(creationDate.getDate()+l.getPeriod());
			if(creationDate.after(d)){
				paymentPlan.executePayments(l);
				creditRepository.save(l);
			}
		} else if (this.next != null) {
			this.next.repay(c, ammount);
		}

	}

	@Override
	public void setNextHandler(CreditHandler c) {
		this.next = c;

	}

}
