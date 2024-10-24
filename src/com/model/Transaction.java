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
public String getTransactionId() {
	return transactionId;
}
public void setTransactionId(String transactionId) {
	this.transactionId = transactionId;
}
public String getAccountId() {
	return accountId;
}
public void setAccountId(String accountId) {
	this.accountId = accountId;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public String getTransactionType() {
	return transactionType;
}
public void setTransactionType(String transactionType) {
	this.transactionType = transactionType;
}
public Date getTransactionDate() {
	return transactionDate;
}
public void setTransactionDate(Date transactionDate) {
	this.transactionDate = transactionDate;
}
}
