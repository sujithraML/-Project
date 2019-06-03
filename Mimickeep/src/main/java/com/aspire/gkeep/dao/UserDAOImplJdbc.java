package com.aspire.gkeep.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.aspire.gkeep.exceptions.GenericException;
import com.aspire.gkeep.exceptions.UserNotFoundException;
import com.aspire.gkeep.mapper.NoteRowMapper;
import com.aspire.gkeep.mapper.NotesResultSetExtractor;

@Component
public class UserDAOImplJdbc implements UserDAO{

	JdbcTemplate jdbcTemplate;
	@Autowired
	DataSource dataSource;
	NamedParameterJdbcTemplate simpleJdbcTemplate;

	@Autowired
	public UserDAOImplJdbc(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public boolean searchUserName(String userName) throws UserNotFoundException, GenericException {
		
		return jdbcTemplate.query("SELECT * FROM keep.User where username = ?", new  Object[] { userName }, new NotesResultSetExtractor()).size()>0 ? true:false;
	}

	@Override
	public String createUser(String name) throws GenericException {
		
		return jdbcTemplate.update("insert into keep.user values(?", new NoteRowMapper())+"";
	}
}
