package com.main;

import com.model.BankAccount;
import com.model.User;
import com.service.BankAccountService;
import com.service.TransactionService;
import com.service.UserService;
import com.utils.ConsoleUtils;

public class BankingSystem {
    private static UserService userService = new UserService();
    private static BankAccountService bankAccountService = new BankAccountService();
    private static TransactionService transactionService = new TransactionService();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Register\n2. Login\n3. Exit");
            int choice = ConsoleUtils.readInput("Choose an option: ").charAt(0) - '0';

            switch (choice) {
                case 1:
                    String userId = ConsoleUtils.readInput("Enter User ID: ");
                    String password = ConsoleUtils.readInput("Enter Password: ");
                    String role = ConsoleUtils.readInput("Enter Role (Customer/Employee): ");
                    userService.register(userId, password, role);
                    System.out.println("User registered successfully!");
                    break;
                case 2:
                    userId = ConsoleUtils.readInput("Enter User ID: ");
                    password = ConsoleUtils.readInput("Enter Password: ");
                    User user = userService.login(userId, password);
                    if (user != null) {
                        if ("Customer".equals(user.getRole())) {
                            handleCustomer(userId);
                        } else {
                            System.out.println("Employee functionalities can be implemented here.");
                        }
                    } else {
                        System.out.println("Invalid credentials!");
                    }
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private static void handleCustomer(String userId) {
        while (true) {
            System.out.println("Customer Menu:\n1. Create Account\n2. Deposit\n3. Withdraw\n4. Exit");
            int choice = ConsoleUtils.readInput("Choose an option: ").charAt(0) - '0';

            switch (choice) {
                case 1:
                    String accountId = ConsoleUtils.readInput("Enter Account ID: ");
                    String accountType = ConsoleUtils.readInput("Enter Account Type (Saving/Checking): ");
                    BankAccount account = new BankAccount(accountId, userId, 0, accountType);
                    bankAccountService.createAccount(account);
                    System.out.println("Account created successfully!");
                    break;
                case 2:
                    accountId = ConsoleUtils.readInput("Enter Account ID to deposit: ");
                    double amount = ConsoleUtils.readDouble("Enter amount to deposit: ");
                    bankAccountService.deposit(accountId, amount);
                    transactionService.recordTransaction("T" + System.currentTimeMillis(), accountId, amount, "Deposit");
                    System.out.println("Deposit successful!");
                    break;
                case 3:
                    accountId = ConsoleUtils.readInput("Enter Account ID to withdraw: ");
                    amount = ConsoleUtils.readDouble("Enter amount to withdraw: ");
                    if (bankAccountService.withdraw(accountId, amount)) {
                        transactionService.recordTransaction("T" + System.currentTimeMillis(), accountId, amount, "Withdrawal");
                        System.out.println("Withdrawal successful!");
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
