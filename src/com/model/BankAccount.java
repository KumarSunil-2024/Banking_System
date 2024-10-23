package com.model;

public class BankAccount {
	private String accountId;
    private String customerId;
    private double balance;
    private String accountType;
	public BankAccount(String accountId, String customerId, double balance, String accountType) {
		
		this.accountId = accountId;
		this.customerId = customerId;
		this.balance = balance;
		this.accountType = accountType;
	}
	public String getAccountId() {
		return accountId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public double getBalance() {
		return balance;
	}
	public String getAccountType() {
		return accountType;
	}
    public void deposit(double amount) {
    	balance+=amount;
    }
    public boolean withdraw(double amount) {
		if(balance>=amount) {
			balance-=amount;
			return true;
		}else {
			return false;
		}
    }
}
