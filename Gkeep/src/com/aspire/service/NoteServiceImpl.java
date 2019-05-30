package com.aspire.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.aspire.dao.FileIO;
import com.aspire.modelbeans.Note;
import com.aspire.modelbeans.User;


@Path("/notes")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class NoteServiceImpl implements NoteService {

	List<Note> notes = new ArrayList<Note>();
	User user = new User();

	@Override
	@POST
	@Path("/{note}/add")
	public boolean addNote(@PathParam("note")Note note) {
		if(user	==	null || note == null) 
			return false;
		notes.add(note);
		return true;
	}

	@Override
	@DELETE
	@Path("/{note}/delete")
	public boolean removeNote(@PathParam("note")Note note) {
		if(user	==	null || note == null) 
			return false;
		notes.remove(note);
		return true;
	}

	@Override
	@GET
	@Path("/{user}/getUserNotes")
	public List<Note> getNotes(@PathParam("user")User user) {
		pushNotes();
		FileIO fileIO = new FileIO();
		notes = fileIO.getData(user);
		return notes;
	}
	@Override
	@GET
	@Path("/getInfo")
	public void display() {			
		pushNotes();
	}


	@Override
	@POST
	@Path("/save")
	public boolean pushNotes() {
		FileIO fileIO = new FileIO();
		return fileIO.dataIn(this.notes, user);
	}
}
