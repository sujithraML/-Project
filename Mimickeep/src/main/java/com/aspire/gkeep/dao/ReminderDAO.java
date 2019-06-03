package com.aspire.gkeep.dao;

import java.util.List;

import com.aspire.gkeep.exceptions.GenericException;
import com.aspire.gkeep.exceptions.UserNotFoundException;
import com.aspire.gkeep.models.Reminder;

public interface ReminderDAO {
	
	public boolean findReminderFile(String userName);
	
	public String saveReminders(List<Reminder> reminders, String user) throws UserNotFoundException, GenericException;
	
	public List<Reminder> getReminders(String user) throws UserNotFoundException, GenericException;
	
}
