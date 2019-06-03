package com.aspire.gkeep.utils;

public class MySqlQueries {
	public static final String SELECTBYUSERID = "SELECT * FROM keep.Note where user_id = ?";

	public static final String INSERTNOTE = "INSERT INTO keep.Note(user_id, label, content, timeStamp) values(?,?,?,?)";
}
