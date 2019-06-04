package com.aspire.gkeep.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.aspire.gkeep.dao.NoteDAO;
import com.aspire.gkeep.exceptions.CustomIOException;
import com.aspire.gkeep.exceptions.EmptyValueException;
import com.aspire.gkeep.exceptions.GenericException;
import com.aspire.gkeep.exceptions.UserNotFoundException;
import com.aspire.gkeep.models.Media;
import com.aspire.gkeep.models.Note;
import com.aspire.gkeep.models.Reminder;
import com.aspire.gkeep.models.User;

@Component
public class NoteServiceImplHibernate implements NoteService{


	@Autowired
	@Qualifier("noteDAOHibernateImpl")
	NoteDAO noteDAO;
	
	List<Note> notes;
	
	@Override
	public List<Note> getNotes(String userName) throws UserNotFoundException, GenericException, EmptyValueException {
		return noteDAO.getNotes(userName);
	}

	@Override
	public void addNote(String name, Note note) throws CustomIOException, UserNotFoundException, GenericException {
		notes = new ArrayList<Note>();
		notes.add(note);
		noteDAO.saveNotes(notes, name);
	}

	@Override
	public void removeNote(String userName, Note note)
			throws CustomIOException, UserNotFoundException, GenericException, EmptyValueException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String registerUser(User user) throws GenericException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean authenticateUser(String userName) throws UserNotFoundException, GenericException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addLabel(String user, String timeStamp, String label)
			throws CustomIOException, UserNotFoundException, GenericException, EmptyValueException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pinNote(String user, Note note)
			throws CustomIOException, UserNotFoundException, GenericException, EmptyValueException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String unPinNote(String user, Note note)
			throws UserNotFoundException, CustomIOException, GenericException, EmptyValueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String restoreFromTrash(String user, Note note)
			throws UserNotFoundException, CustomIOException, GenericException, EmptyValueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addReminder(String user, String reminder, String time)
			throws UserNotFoundException, GenericException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String makeItAsReminder(String user, String time, Note note)
			throws UserNotFoundException, CustomIOException, GenericException, EmptyValueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reminder> getAllReminders(String user) throws UserNotFoundException, GenericException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editNote(String user, Note editedNote)
			throws UserNotFoundException, CustomIOException, GenericException, EmptyValueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editReminder(String user, String editedReminder, String editedTime)
			throws UserNotFoundException, CustomIOException, GenericException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Note> getTrash(String user) throws GenericException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendNote(String user, Note note, Media media) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note copyNote(String user, String timeStamp) throws UserNotFoundException, GenericException {
		// TODO Auto-generated method stub
		return null;
	}

}
