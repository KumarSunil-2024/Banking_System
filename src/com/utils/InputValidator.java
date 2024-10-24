package com.utils;

public class InputValidator {
    public static boolean isValidAccountId(String accountId) {
        return accountId != null && !accountId.trim().isEmpty();
    }

    public static boolean isValidUserId(String userId) {
        return userId != null && !userId.trim().isEmpty();
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }
}