package com.model;

import java.util.Date;

public class Transaction {
private String transactionId;
private String accountId;
private double amount;
private String transactionType;
private Date transactionDate;
public Transaction(String transactionId, String accountId, double amount, String transactionType,
		Date transactionDate) {
	this.transactionId = transactionId;
	this.accountId = accountId;
	this.amount = amount;
	this.transactionType = transactionType;
	this.transactionDate = transactionDate;
}
}
