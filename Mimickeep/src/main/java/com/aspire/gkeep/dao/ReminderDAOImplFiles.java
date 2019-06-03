package com.aspire.gkeep.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aspire.gkeep.exceptions.GenericException;
import com.aspire.gkeep.exceptions.UserNotFoundException;
import com.aspire.gkeep.models.Reminder;
import com.aspire.gkeep.utils.Constants;
import com.aspire.gkeep.utils.ErrorCodes;

@Component
public class ReminderDAOImplFiles implements ReminderDAO {

	@Autowired
	FileIO fileIO;
	List<Reminder> reminders = new ArrayList<Reminder>();

	@Override
	public boolean findReminderFile(String userName) {
		return false;
	}

	@Override
	public String saveReminders(List<Reminder> reminders, String userName)
			throws UserNotFoundException, GenericException {
		String status = "";
		File file = new File(Constants.DIRECTORY + userName + "/" + Constants.REMINDER);
		if (fileIO.searchUserName(userName)) {
			try {
				FileWriter fileWriter = new FileWriter(file);
				Iterator<Reminder> iterator = reminders.iterator();
				while (iterator.hasNext()) {
					Reminder reminder = new Reminder();
					reminder = iterator.next();
					fileWriter.write(reminder.getDatetime() + " : " + reminder.getMessage() + Constants.DOLLARPATTERN
							+ System.lineSeparator());
				}
				fileWriter.flush();
				fileWriter.close();
				status = ErrorCodes.STATUSSUCCESS;
			} catch (IOException e) {
				throw new GenericException(ErrorCodes.ERRORCODE, e);
			} catch (Exception e) {
				throw new GenericException(ErrorCodes.ERRORCODE, e);
			}
		}
		return status;
	}

	@Override
	public List<Reminder> getReminders(String name) throws UserNotFoundException, GenericException {

		File file = new File(Constants.DIRECTORY + name + "/" + Constants.REMINDER);
		if (fileIO.searchUserName(name)) {
			try {
				FileReader fileReader = new FileReader(file);
				StringBuffer stringBuffer = new StringBuffer();
				int numCharsRead;
				char[] charArray = new char[1024];
				try {
					while ((numCharsRead = fileReader.read(charArray)) > 0) {
						stringBuffer.append(charArray, 0, numCharsRead);
					}
					if (stringBuffer != null)
						reminders = new ArrayList<Reminder>();
					StringTokenizer stringTokenizer = new StringTokenizer(stringBuffer.toString(),
							Constants.DOLLARPATTERN + System.lineSeparator());
					while (stringTokenizer.hasMoreTokens()) {
						Reminder reminder = new Reminder();
						String string = stringTokenizer.nextToken();
						reminder.setDatetime(string.substring(0, 17));
						reminder.setMessage(string.substring(20, string.length()));
						reminders.add(reminder);
					}
				} catch (IOException e) {

				}
			} catch (FileNotFoundException e) {
				throw new GenericException(ErrorCodes.ERRORCODE, e);
			} catch (Exception e) {
				throw new GenericException(ErrorCodes.ERRORCODE, e);
			}
		} else
			throw new UserNotFoundException(ErrorCodes.USERNOTFOUNDEXCEPTION);
		return reminders;
	}

}
