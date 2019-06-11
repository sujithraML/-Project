package com.aspire.simplemvc.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.aspire.simplemvc.dao.UserDao;
import com.aspire.simplemvc.models.Login;
import com.aspire.simplemvc.models.User;

public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userDao;

	@Override
	public User validateUser(Login login) {
		return userDao.validateUser(login);
	}

	@Override
	public void register(User user) {
		userDao.register(user);
	}
}
