package com.aspire.gkeep.dao;

import com.aspire.gkeep.exceptions.GenericException;
import com.aspire.gkeep.exceptions.UserNotFoundException;

public interface UserDAO {

	public boolean searchUserName(String username) throws UserNotFoundException, GenericException;

	public String createUser(String name) throws GenericException;
}
