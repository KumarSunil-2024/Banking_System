package com.service;

import com.database.DatabaseHandler;
import com.model.Transaction;

public class TransactionService {
    public void recordTransaction(String transactionId, String accountId, double amount, String transactionType) {
        Transaction transaction = new Transaction(transactionId, accountId, amount, transactionType, new java.util.Date());
        DatabaseHandler.addTransaction(transaction);
    }
}
