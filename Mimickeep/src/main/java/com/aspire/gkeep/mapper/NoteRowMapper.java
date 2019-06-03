package com.aspire.gkeep.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.aspire.gkeep.models.Note;

public class NoteRowMapper implements RowMapper{

	@Override
	public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
		Note note = new Note();
		
		note.setLabel(rs.getString(2));
		note.setContent(rs.getString(3));
		note.setTimeStamp(rs.getString(4));
		return note;
	}
	
}
