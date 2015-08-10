package com.ps.command;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ps.entity.Loan;

@Service
public class PaymentPlan {

	private static List<Payment> payments;

	public void addPayment(int ammount, Loan loan) {
		Payment p = new Payment();
		p.setLoan(loan);
		p.setAmmount(ammount);
		p.setDate(new Date());
		PaymentPlan.payments.add(p);

	}

	public void executePayments(Loan l) {

		List<Payment> remove = new ArrayList<Payment>();
		for (Payment p : PaymentPlan.payments) {
			if (p.getLoan().getId() == l.getId()) {
				p.repay();
				remove.add(p);
			}
		}
		for(Payment p: remove){
			PaymentPlan.payments.remove(p);
		}
	}

	public static List<Payment> getPayments() {
		return payments;
	}

	public static void setPayments(ArrayList<Payment> arrayList) {
		PaymentPlan.payments = arrayList;
	}
	
}
