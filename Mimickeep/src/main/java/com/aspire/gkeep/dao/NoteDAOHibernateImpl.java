package com.aspire.gkeep.dao;

import java.util.List;

import org.hibernate.classic.Session;
import org.springframework.stereotype.Component;
import com.aspire.gkeep.exceptions.CustomIOException;
import com.aspire.gkeep.exceptions.EmptyValueException;
import com.aspire.gkeep.exceptions.GenericException;
import com.aspire.gkeep.exceptions.UserNotFoundException;
import com.aspire.gkeep.models.Note;
import com.aspire.gkeep.utils.HibernateUtil;

@Component
public class NoteDAOHibernateImpl implements NoteDAO{

	@Override
	public void saveTrash(List<Note> notes, String user) throws GenericException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Note> getTrash(String user) throws GenericException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String savePinnedNotes(List<Note> pinned, String user) throws GenericException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String unpinNotes(Note note, String user) throws UserNotFoundException, GenericException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Note> getNotes(String name) throws UserNotFoundException, GenericException, EmptyValueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] saveNotes(List<Note> notesToBeSaved, String userName) throws CustomIOException, GenericException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		for(Note note:notesToBeSaved)
			session.save(note);
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		return null;
	}

	@Override
	public List<Note> getPinnedNotes(String name) throws UserNotFoundException, GenericException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
