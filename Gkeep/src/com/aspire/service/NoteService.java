package com.aspire.service;

import java.util.List;

import com.aspire.modelbeans.Note;
import com.aspire.modelbeans.User;

public interface NoteService {
	
	public boolean addNote(Note note);
	
	public boolean removeNote(Note note);
	
	public List<Note> getNotes(User user);
	
	public void display();
	
	public boolean pushNotes();
}
