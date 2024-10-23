package com.service;

import com.database.DatabaseHandler;
import com.model.User;

public class UserService {
public User login(String userId,String password) {
	return DatabaseHandler.getUser(userId, password);
}
public void register(String userId,String password,String role) {
	User user=new User(userId,password,role);
	DatabaseHandler.addUser(user);
}
}
