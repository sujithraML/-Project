package com.aspire.gkeep.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.aspire.gkeep.models.Note;

public class NotesRowMapper implements RowMapper<List<Note>>{

	@Override
	public List<Note> mapRow(ResultSet rs, int rowNum) throws SQLException {
//		Note note = new Note();
		
		NotesResultSetExtractor extractor = new NotesResultSetExtractor();
		
//		note.setLabel(rs.getString(2));
//		note.setContent(rs.getString(3));
//		note.setTimeStamp(rs.getString(4));
//		
		return extractor.extractData(rs);
	}

}
