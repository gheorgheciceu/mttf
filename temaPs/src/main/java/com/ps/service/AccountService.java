package com.ps.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.entity.Account;
import com.ps.entity.Operation;
import com.ps.entity.OperationType;
import com.ps.repository.AccountRepository;
import com.ps.repository.OperationRepository;
import com.ps.repository.OperationTypeRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private OperationRepository operationRepository;
	
	@Autowired
	private OperationTypeRepository operationTypeRepository;

	public void save(Account account) {
		account.setCreationDate(new Date());
		accountRepository.save(account);

	}

	public void delete(int id) {
		accountRepository.delete(id);

	}

	public List<Account> findAll() {

		return accountRepository.findAll();
	}

	public Account findOne(int id) {
		// TODO Auto-generated method stub
		return accountRepository.findOne(id);
	}

	public void transfer(int from, int to, int ammount) {
		Account toAcc = accountRepository.findOne(to);
		Account fromAcc = accountRepository.findOne(from);

		toAcc.setBalance(toAcc.getBalance() + ammount);
		fromAcc.setBalance(fromAcc.getBalance() - ammount);
		
		OperationType opt = operationTypeRepository.findOne("transfer");
		int max = opt.getMaximum();
		if (ammount < max) {
			accountRepository.save(toAcc);
			accountRepository.save(fromAcc);

			Operation o = new Operation();
			o.setAmount(ammount);
			o.setDate(new Date());
			o.setDescription("transfer");
			o.setInterestRate("1/2");
			o.setOperationName("Transfer");
			o.setUser(null);
			operationRepository.save(o);
		}

	}

}
