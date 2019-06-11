package com.aspire.simplemvc.services;

import com.aspire.simplemvc.models.Login;
import com.aspire.simplemvc.models.User;

public interface UserService {

	User validateUser(Login login);

	void register(User user);
	
}	
