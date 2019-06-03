package com.aspire.gkeep.dao;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Component;

import com.aspire.gkeep.exceptions.GenericException;
import com.aspire.gkeep.exceptions.UserNotFoundException;
import com.aspire.gkeep.utils.Constants;
import com.aspire.gkeep.utils.ErrorCodes;

@Component
public class UserDAOImplFiles implements UserDAO{

	@Override
	public boolean searchUserName(String username) throws UserNotFoundException, GenericException {
		try {
		if (username != null) {
			File file = new File(Constants.DIRECTORY  + username + "/");
			String[] files = file.list();
			for (String tempFile : files) {
				if (tempFile.equals(username + Constants.FILEEXTENSION)) {
					return true;
				}
			}
		}
		}
		catch(Exception e) {
			throw new GenericException(ErrorCodes.ERRORCODE, e);
		}
		return false;
	}

	@Override
	public String createUser(String name) throws GenericException {
		File file = new File(Constants.DIRECTORY  + name +"/");
		String status ="";
		file.mkdirs();
		try {
			file = new File(Constants.DIRECTORY  + name + "/" + Constants.LOG);
			file.createNewFile();
			file = new File(Constants.DIRECTORY  + name + "/" + Constants.BIN);
			file.createNewFile();
			file = new File(Constants.DIRECTORY  + name + "/" + Constants.REMINDER);
			file.createNewFile();
			file = new File(Constants.DIRECTORY  + name + "/" + Constants.PINNED);
			file.createNewFile();
			file = new File(Constants.DIRECTORY  + name + "/" + name + Constants.FILEEXTENSION);
			if(file.createNewFile())
				status = ErrorCodes.STATUSSUCCESS;
		} catch (IOException e) {
			status = ErrorCodes.ERRORCODE;
		}catch (Exception e) {
			throw new GenericException(ErrorCodes.ERRORCODE, e);
		}
		return status;
	}
}
