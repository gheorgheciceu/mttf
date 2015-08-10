package com.ps.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class CashCredit extends Credit{

	private int ammountTaken;

	public int getAmmountTaken() {
		return ammountTaken;
	}

	public void setAmmountTaken(int ammountTaken) {
		this.ammountTaken = ammountTaken;
	}
}
