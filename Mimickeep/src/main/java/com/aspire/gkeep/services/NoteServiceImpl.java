package com.aspire.gkeep.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.aspire.gkeep.uncertain.DateComparator;
import com.aspire.gkeep.dao.NoteDAO;
import com.aspire.gkeep.dao.ReminderDAOImplFiles;
import com.aspire.gkeep.dao.UserDAO;
import com.aspire.gkeep.exceptions.CustomIOException;
import com.aspire.gkeep.exceptions.EmptyValueException;
import com.aspire.gkeep.exceptions.GenericException;
import com.aspire.gkeep.exceptions.UserNameUnAvailableException;
import com.aspire.gkeep.exceptions.UserNotFoundException;
import com.aspire.gkeep.models.Media;
import com.aspire.gkeep.models.Note;
import com.aspire.gkeep.models.Reminder;
import com.aspire.gkeep.models.User;
import com.aspire.gkeep.utils.ErrorCodes;

@Component
public class NoteServiceImpl implements NoteService {

	List<Note> notes = new ArrayList<Note>();;
	List<Note> pinned;
	List<Note> trash;
	List<Reminder> reminders;
	@Autowired
	Reminder reminder;
	@Autowired
	Note note;
	@Autowired
	@Qualifier("noteDAOImplFiles")
	NoteDAO noteDao;
	@Autowired
	@Qualifier("userDAOImplFiles")
	UserDAO userDAO;
	@Autowired 
	ReminderDAOImplFiles reminderDao;
	

	@Override
	public String registerUser(User user) throws GenericException {
		return userDAO.createUser(user.getName());
	}

	@Override
	public boolean authenticateUser(String userName) throws UserNotFoundException, GenericException {
		return userDAO.searchUserName(userName) ? false: true ;
	}

	/* Returns all the notes belong to the user */
	@Override
	public List<Note> getNotes(String userName) throws UserNotFoundException, GenericException, EmptyValueException {
		
		if (userDAO.searchUserName(userName)) {
			notes = noteDao.getNotes(userName);
		}else
			throw new UserNotFoundException(ErrorCodes.USERNOTFOUNDEXCEPTION);
		return notes;
	}

	/*
	 * adds note to user's storage(file) and returns the true if added successfully
	 */
	@Override
	public void addNote(String name, Note note) throws CustomIOException, UserNotFoundException, GenericException {
		try {
			if (userDAO.searchUserName(name)) {
				if (note.getTimeStamp().equalsIgnoreCase(""))
					note.setTimeStamp("");
				notes = noteDao.getNotes(name);
				notes.add(note);
				Collections.sort(notes, new DateComparator());
				/* should reverse the list */
			} else
				throw new UserNotFoundException(ErrorCodes.USERNOTFOUNDEXCEPTION);
		}catch (Exception e) {
			throw new GenericException(ErrorCodes.ERRORCODE, e);
		}
	}

	/*
	 * removes the note on the user's storage and returns true if removed
	 * successfully
	 */
	@Override
	public void removeNote(String userName, Note note) throws CustomIOException, UserNotFoundException, GenericException, EmptyValueException {
		try {
			if (userDAO.searchUserName(userName)) {
				notes = noteDao.getNotes(userName);
				for (int iteration = 0; iteration < notes.size(); iteration++) {
					if (notes.get(iteration).getTimeStamp().equalsIgnoreCase(note.getTimeStamp())) {
						trash = new ArrayList<Note>();
						trash = noteDao.getTrash(userName);
						trash.add(note);
						noteDao.saveTrash(trash, userName);
						notes.remove(iteration);
						noteDao.saveNotes(notes, userName);
					}
				}
			}
			else
				throw new UserNotFoundException(ErrorCodes.USERNOTFOUNDEXCEPTION);
		} catch (CustomIOException e) {
			throw new CustomIOException("IO operation failed");
		}
	}

	/* Adds label to a note specified */
	@Override
	public void addLabel(String user, String timeStamp, String label)
			throws CustomIOException, UserNotFoundException, GenericException, EmptyValueException {
		try {
			if (userDAO.searchUserName(user)) {
					notes = new ArrayList<Note>();
					notes = noteDao.getNotes(user);
					for (int iteration = 0; iteration < notes.size(); iteration++) {
						if (notes.get(iteration).getTimeStamp().equalsIgnoreCase(timeStamp)) {
							notes.get(iteration).setLabel(label);
							noteDao.saveNotes(notes, user);
						}
					}
			} else
				throw new UserNotFoundException(ErrorCodes.USERNOTFOUNDEXCEPTION);
		}
		catch (CustomIOException e) {
			throw new CustomIOException("IO operation failed");
		}
	}

	/* pins the specified note to the top of the list */

	@Override
	public void pinNote(String user, Note note) throws CustomIOException, UserNotFoundException, GenericException, EmptyValueException, UserNameUnAvailableException {
		try {
			if (userDAO.searchUserName(user)) {
				pinned = new ArrayList<Note>();
				pinned.add(note);
				notes = new ArrayList<Note>();
				notes = noteDao.getNotes(user);
				for (int iteration = 0; iteration < notes.size(); iteration++) {
					if (notes.get(iteration).getTimeStamp().equalsIgnoreCase(note.getTimeStamp())) {
						notes.remove(iteration);
						noteDao.saveNotes(notes, user);
						noteDao.savePinnedNotes(pinned, user);
					}
				}
			} else
				throw new UserNotFoundException(ErrorCodes.USERNOTFOUNDEXCEPTION);
		} catch (CustomIOException e) {
			throw new CustomIOException("IO operation failed");
		}
	}

	/* removes pin and adds it into */
	@Override
	public String unPinNote(String user, Note note) throws UserNotFoundException, CustomIOException, GenericException, EmptyValueException, UserNameUnAvailableException {
		String status = "";
		if(userDAO.searchUserName(user)) {
			pinned = new ArrayList<Note>();
			notes = new ArrayList<Note>();
			pinned = noteDao.getPinnedNotes(user);
			for (int iteration = 0; iteration < pinned.size(); iteration++) {
				if (pinned.get(iteration).getTimeStamp().equalsIgnoreCase(note.getTimeStamp())) {
					note = pinned.get(iteration);
					note.setTimeStamp("");
					notes = noteDao.getNotes(user);
					notes.add(note);
					pinned.remove(iteration);
					noteDao.saveNotes(notes, user);
					noteDao.savePinnedNotes(pinned, user);
					status = "note got unpinned successfully";
				}
			}
		}
		return status;
	}

	/*
	 * adds a reminder with time returns true if added successfully
	 */
	@Override
	public String addReminder(String user, String reminderMessage, String datetime) throws UserNotFoundException, GenericException {
		if (userDAO.searchUserName(user)) {
			reminders = new ArrayList<Reminder>();
			reminders = reminderDao.getReminders(user);
			reminder.setMessage(reminderMessage);
			reminder.setDatetime(datetime);
			reminders.add(reminder);
		}else 
			throw new UserNotFoundException(ErrorCodes.USERNOTFOUNDEXCEPTION);
		return reminderDao.saveReminders(reminders, user);
	}

	/*
	 * make a note as reminder with time as input returns true if added successfully
	 */

	@Override
	public String makeItAsReminder(String user, String time, @RequestBody Note note) throws UserNotFoundException, CustomIOException, GenericException, EmptyValueException {
		String status = "";
		reminders = new ArrayList<Reminder>();
		if(userDAO.searchUserName(user)) {
			notes = new ArrayList<Note>();
			notes = noteDao.getNotes(user);
			reminder.setMessage(note.getContent());
			reminder.setDatetime(time);
			if(notes != null) {
				for (int iteration = 0; iteration < notes.size(); iteration++) {
					if (notes.get(iteration).getTimeStamp().equalsIgnoreCase(note.getTimeStamp())) {
						reminders.add(reminder);
						notes.remove(iteration);
						noteDao.saveNotes(notes, user);
						reminderDao.saveReminders(reminders, user);
						status = "note saved as reminder successfully";
					}
				}
			}
		}
		else
			throw new UserNotFoundException(ErrorCodes.USERNOTFOUNDEXCEPTION);
		return status;
	}

	/* returns all the reminders saved for the specified user */

	@Override
	public List<Reminder> getAllReminders(String user) throws UserNotFoundException, GenericException {
		return reminderDao.getReminders(user);
	}

	/* edits the note and saves it in the user's storage */

	@Override
	public String editNote(String user, Note editedNote) throws UserNotFoundException, CustomIOException, GenericException, EmptyValueException {
		String status = "";
		if(userDAO.searchUserName(user)) {
			notes = noteDao.getNotes(user);
			Optional<Note> note = notes.stream().filter(tempNote ->tempNote.getTimeStamp().equalsIgnoreCase(editedNote.getTimeStamp())).findAny();
			System.out.println(note.isPresent());
			if(notes!=null) {
				for (int iteration = 0; iteration < notes.size(); iteration++) {
					if (notes.get(iteration).getTimeStamp().equalsIgnoreCase(editedNote.getTimeStamp())) {
						notes.remove(iteration);
						editedNote.setTimeStamp("");
						notes.add(editedNote);
						noteDao.saveNotes(notes, user);
						status = "note got edited successfully";
					}
				}
			}
		}
		else
			throw new UserNotFoundException(ErrorCodes.USERNOTFOUNDEXCEPTION);
		return status;
	}

	/* edits reminder and saves it */

	@Override
	public String editReminder(String user, String editedReminder, String editedTime) throws UserNotFoundException, CustomIOException, GenericException {
		String status = "";
		reminders = new ArrayList<Reminder>();
		if(userDAO.searchUserName(user)) {
			reminders = reminderDao.getReminders(user);
			reminder.setMessage(editedReminder);
			reminder.setDatetime(editedTime);
			if(reminders!=null) {
				for (int iteration = 0; iteration < reminders.size(); iteration++) {
					if (reminders.get(iteration).getMessage().equalsIgnoreCase(editedReminder) || reminders.get(iteration).getDatetime().equalsIgnoreCase(editedTime)) {
						reminders.remove(iteration);
						reminders.add(reminder);
						reminderDao.saveReminders(reminders, user);
						status = "note got edited successfully";
					}
				}
			}
		}
		else
			throw new UserNotFoundException(ErrorCodes.USERNOTFOUNDEXCEPTION);
		return status;
	}

	/* saves the last 10 deleted notes and returns it on demand */

	@Override
	public List<Note> getTrash(String user) throws GenericException {
		notes = new ArrayList<Note>();
		notes = noteDao.getTrash(user);
		return notes;
	}

	/* copies the note and returns the object */

	@Override
	public Note copyNote(String user, String timeStamp) throws UserNotFoundException, GenericException {
		if (userDAO.searchUserName(user)) {
			try {
					notes = noteDao.getNotes(user);
					for (int iteration = 0; iteration < notes.size(); iteration++) {
						if (notes.get(iteration).getTimeStamp().equalsIgnoreCase(timeStamp)) {
							note = notes.get(iteration);
						}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			throw new UserNotFoundException(ErrorCodes.USERNOTFOUNDEXCEPTION);
		return note;
	}

	/* restores a particular note */
	@Override
	public String restoreFromTrash(String user, Note note) throws UserNotFoundException, CustomIOException, GenericException, EmptyValueException {
		String status = "";
		notes = new ArrayList<Note>();
		trash = new ArrayList<Note>();
		if(userDAO.searchUserName(user)) {
			trash = noteDao.getTrash(user);
			notes = noteDao.getNotes(user);
			for (int iteration = 0; iteration < notes.size(); iteration++) {
				if (trash.get(iteration).getTimeStamp().equalsIgnoreCase(note.getTimeStamp())) {
					notes.add(note);
					notes.remove(iteration);
					noteDao.saveNotes(notes, user);
					noteDao.saveTrash(trash, user);
					status = "note pinned successfully";
				}
			}
		}
		else
			throw new UserNotFoundException(ErrorCodes.USERNOTFOUNDEXCEPTION);
		return status;
	}

	/* sends the note as email,message etc. */

	@Override
	public String sendNote(String user, Note note, Media media) {
		notes = new ArrayList<Note>();
		return "";
	}
//
//	/* group some notes and saves it in mentioned folder name */
//
//	@Override
//	public String groupNotes(String user, String groupName, List<Note> notes) {
//		notes = new ArrayList<Note>();
//		
//		return "";
//	}

}
