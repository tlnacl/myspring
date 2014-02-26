package com.tl.myspring.model;

import javax.persistence.Entity;

@Entity
public class Wallet extends BaseEntity{
	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
