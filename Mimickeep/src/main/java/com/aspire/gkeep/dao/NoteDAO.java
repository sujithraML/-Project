package com.aspire.gkeep.dao;

import java.util.List;

import com.aspire.gkeep.exceptions.CustomIOException;
import com.aspire.gkeep.exceptions.EmptyValueException;
import com.aspire.gkeep.exceptions.GenericException;
import com.aspire.gkeep.exceptions.UserNotFoundException;
import com.aspire.gkeep.models.Note;

public interface NoteDAO {
	
	public void saveTrash(List<Note> notes, String user) throws GenericException;
	
	public List<Note> getTrash(String user) throws GenericException;
	
	public String savePinnedNotes(List<Note> pinned, String user) throws GenericException;
	
	public String unpinNotes(Note note, String user) throws UserNotFoundException, GenericException;
	
	public List<Note> getNotes(String name) throws UserNotFoundException, GenericException, EmptyValueException;

	public int[] saveNotes(List<Note> notesToBeSaved, String userName) throws CustomIOException, GenericException;

	public List<Note> getPinnedNotes(String name) throws UserNotFoundException, GenericException;

}
