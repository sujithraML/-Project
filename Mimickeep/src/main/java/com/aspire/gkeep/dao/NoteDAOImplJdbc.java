package com.aspire.gkeep.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.aspire.gkeep.exceptions.CustomIOException;
import com.aspire.gkeep.exceptions.EmptyValueException;
import com.aspire.gkeep.exceptions.GenericException;
import com.aspire.gkeep.exceptions.UserNotFoundException;
import com.aspire.gkeep.mapper.NotesResultSetExtractor;
import com.aspire.gkeep.models.Note;
import com.aspire.gkeep.utils.ErrorCodes;
import com.aspire.gkeep.utils.MySqlQueries;

@Component
public class NoteDAOImplJdbc implements NoteDAO {

	JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;
	NamedParameterJdbcTemplate simpleJdbcTemplate;

	@Autowired
	public NoteDAOImplJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}	

	@Override
	public void saveTrash(List<Note> notes, String user) throws GenericException {

	}

	@Override
	public List<Note> getTrash(String user) throws GenericException {

		return null;
	}

	@Override
	public void savePinnedNotes(List<Note> pinned, String user) throws GenericException {

	}

	@Override
	public void unpinNotes(Note note, String user) throws UserNotFoundException, GenericException {

	}

	@Override
	public List<Note> getNotes(String name) throws UserNotFoundException, GenericException, EmptyValueException {
		try {
			return jdbcTemplate.query(MySqlQueries.SELECTBYUSERID, new Object[] { 1 }, new NotesResultSetExtractor());
		} catch (NullPointerException e) {
			throw new EmptyValueException(ErrorCodes.ILLEGALARGUMENTEXCEPTION, e);
		} catch (Exception e) {
			throw new GenericException(ErrorCodes.ERRORCODE, e);
		}

	}

	@Override
	public int[] saveNotes(List<Note> notesToBeSaved, String userName) throws CustomIOException, GenericException {
		return jdbcTemplate.batchUpdate(MySqlQueries.INSERTNOTE, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(java.sql.PreparedStatement ps, int i) throws SQLException {

				for (Note note : notesToBeSaved) {

					ps.setInt(1, 1);
					if (StringUtils.isEmpty(note.getLabel()))
						ps.setString(2, null);
					else
						ps.setString(2, note.getLabel());
					ps.setString(3, note.getContent());
					ps.setString(4, note.getTimeStamp());
				}
			}

			@Override
			public int getBatchSize() {
				return notesToBeSaved.size();
			}
		});
	}

	@Override
	public List<Note> getPinnedNotes(String name) throws UserNotFoundException, GenericException {
		return null;
	}



//	public String unpinNotes2(Note note, String user) throws UserNotFoundException, GenericException {
//		BasicDataSource dataSource = new BasicDataSource();
//		return null;
//	}
}
