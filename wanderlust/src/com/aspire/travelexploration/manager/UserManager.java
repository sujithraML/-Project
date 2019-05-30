package com.aspire.travelexploration.manager;

import java.sql.SQLException;
import com.aspire.travelexploration.daoimpl.UserDAO;
import com.aspire.travelexploration.entity.User;

public class UserManager {
	UserDAO userDao=new UserDAO();
	public boolean isUserPresent(User user) {
		try {
			return userDao.userLogin(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean register(User user) {
		boolean flag=userDao.addDetails(user);
		return flag;
	}
	public int selectUser(User user) {
		return userDao.getId(user).getUserId();
	}
}
