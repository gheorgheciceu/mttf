package com.ps.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("3")
public class Loan extends Credit {

	private int ammountTaken;

	public int getAmmountTaken() {
		return ammountTaken;
	}

	public void setAmmountTaken(int ammountTaken) {
		this.ammountTaken = ammountTaken;
	}
}
