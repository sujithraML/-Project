package com.aspire.gkeep.services;

import java.util.List;

import com.aspire.gkeep.exceptions.CustomIOException;
import com.aspire.gkeep.exceptions.EmptyValueException;
import com.aspire.gkeep.exceptions.GenericException;
import com.aspire.gkeep.exceptions.UserNameUnAvailableException;
import com.aspire.gkeep.exceptions.UserNotFoundException;
import com.aspire.gkeep.models.Media;
import com.aspire.gkeep.models.Note;
import com.aspire.gkeep.models.Reminder;
import com.aspire.gkeep.models.User;

public interface NoteService {
	public List<Note> getNotes(String userName) throws UserNotFoundException, GenericException, EmptyValueException;
	
	public void addNote(String name, Note note) throws CustomIOException, UserNotFoundException, GenericException;
	
	public void removeNote(String userName, Note note) throws CustomIOException, UserNotFoundException, GenericException, EmptyValueException;
	
	public String registerUser(User user) throws GenericException;
	
	public boolean authenticateUser(String userName) throws UserNotFoundException, GenericException;
	
	public void addLabel(String user, String timeStamp,String label) throws CustomIOException, UserNotFoundException, GenericException, EmptyValueException;
	
	public void pinNote(String user, Note note) throws CustomIOException, UserNotFoundException, GenericException, EmptyValueException, UserNameUnAvailableException;
	
	public String unPinNote(String user, Note note) throws UserNotFoundException, CustomIOException, GenericException, EmptyValueException, UserNameUnAvailableException;
	
	public String restoreFromTrash(String user, Note note) throws UserNotFoundException, CustomIOException, GenericException, EmptyValueException;
	
	public String addReminder(String user, String reminder, String time) throws UserNotFoundException, GenericException;
	
	public String makeItAsReminder(String user, String time, Note note) throws UserNotFoundException, CustomIOException, GenericException, EmptyValueException;
	
	public List<Reminder> getAllReminders(String user) throws UserNotFoundException, GenericException;
	
	public String editNote(String user, Note editedNote) throws UserNotFoundException, CustomIOException, GenericException, EmptyValueException;
	
	public String editReminder(String user, String editedReminder, String editedTime) throws UserNotFoundException, CustomIOException, GenericException;
	
	public List<Note> getTrash(String user) throws GenericException;
	
	public String sendNote(String user, Note note, Media media);
	
	public Note copyNote(String user,  String timeStamp) throws UserNotFoundException, GenericException;
	
	//public String groupNotes(String user, String groupName, List<Note> notes);
}
