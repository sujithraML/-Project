package com.aspire.gkeep.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.aspire.gkeep.models.Note;

public class NotesResultSetExtractor implements ResultSetExtractor<List<Note>>{

	@Override
	public List<Note> extractData(ResultSet rs) throws SQLException, DataAccessException {
		List<Note> notes = new ArrayList<Note>();
		while(rs.next()) {
			Note note = new Note();
			note.setLabel(rs.getString(2));
			note.setContent(rs.getString(3));
			note.setTimeStamp(rs.getString(4));
			notes.add(note);
		}
		return notes;
	}

}
