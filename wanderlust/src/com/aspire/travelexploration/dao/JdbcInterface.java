package com.aspire.travelexploration.dao;

import java.util.List;

public interface JdbcInterface {
	public boolean addDetails(Object object);
	public List<Object> selectDetails(Object object);
}
