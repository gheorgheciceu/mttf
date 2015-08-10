package com.ps.service;

import org.springframework.stereotype.Service;

import com.ps.entity.Credit;

@Service
public interface CreditHandler {

	public void repay(Credit c, int ammount);
	
	public void setNextHandler(CreditHandler c);
}
