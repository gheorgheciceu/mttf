package com.ps.command;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.entity.Loan;
import com.ps.repository.CreditRepository;

@Service
public class Payment {

	@Autowired
	private CreditRepository creditRepository;

	private int ammount;

	private Loan loan;

	private Date date;

	public void repay() {
		loan.setAmmountTaken(loan.getAmmountTaken() - ammount);
		//creditRepository.save(loan);
	}

	public int getAmmount() {
		return ammount;
	}

	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
