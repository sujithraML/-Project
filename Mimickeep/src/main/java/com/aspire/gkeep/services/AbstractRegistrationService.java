package com.aspire.gkeep.services;

import com.aspire.gkeep.models.User;

public abstract class AbstractRegistrationService{
	protected abstract boolean userRegistration(User user);
}
