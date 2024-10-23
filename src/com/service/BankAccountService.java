package com.service;

import com.database.DatabaseHandler;
import com.model.BankAccount;

public class BankAccountService {

	public void createAccount(BankAccount bankAccount) {
		DatabaseHandler.addAccount(bankAccount);
	}
	
	public BankAccount getAccount(String accountId) {
		return DatabaseHandler.getAccount(accountId);
	}
	public void deposit(String accountId,double balance) {
	 BankAccount account=getAccount(accountId);
	 if(account!=null) {
		 account.deposit(balance);
		 DatabaseHandler.updateAccount(account);
	 }
	}
	public boolean withdraw(String accountId,double balance) {
		BankAccount account=getAccount(accountId);
		account.withdraw(balance);
		if(account!=null && account.withdraw(balance)) {
			DatabaseHandler.updateAccount(account);
			return true;
		}else {
			return false;
		}
	 }
}
