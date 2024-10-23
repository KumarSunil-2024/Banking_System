package com.database;


import java.sql.*;

import com.model.BankAccount;
import com.model.Transaction;
import com.model.User;

public class DatabaseHandler {
    private static Connection conn;

    static {
        try {
            conn = DBConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addUser(User user) {
        String query = "INSERT INTO users (user_id, password, role) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getRole());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static User getUser(String userId, String password) {
        String query = "SELECT * FROM users WHERE user_id = ? AND password = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, userId);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("user_id"), rs.getString("password"), rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void addAccount(BankAccount account) {
        String query = "INSERT INTO accounts (account_id, customer_id, balance, account_type) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, account.getAccountId());
            pstmt.setString(2, account.getCustomerId());
            pstmt.setDouble(3, account.getBalance());
            pstmt.setString(4, account.getAccountType());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static BankAccount getAccount(String accountId) {
        String query = "SELECT * FROM accounts WHERE account_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, accountId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new BankAccount(rs.getString("account_id"), rs.getString("customer_id"), rs.getDouble("balance"), rs.getString("account_type"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateAccount(BankAccount account) {
        String query = "UPDATE accounts SET balance = ? WHERE account_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDouble(1, account.getBalance());
            pstmt.setString(2, account.getAccountId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addTransaction(Transaction transaction) {
        String query = "INSERT INTO transactions (transaction_id, account_id, amount, transaction_type, transaction_date) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, transaction.getTransactionId());
            pstmt.setString(2, transaction.getAccountId());
            pstmt.setDouble(3, transaction.getAmount());
            pstmt.setString(4, transaction.getTransactionType());
            pstmt.setDate(5, new java.sql.Date(transaction.getTransactionDate().getTime()));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
