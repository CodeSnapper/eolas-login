package org.eolas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.eolas.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class UserRep {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final static String USER_QUERY = "select count(1) from eolas_user where username =?";
	private final static String GET_USER_QUERY = "select userId,enable,credentialNotExpired,accountNotLocked,accountExpired,userName,password,roleId from eolas_user where userName=?";
	public boolean isUserNPassCorrect(String userName){
		int cnt =  jdbcTemplate.queryForObject(USER_QUERY, new Object[] {userName}, Integer.class);
		if(cnt>0)
			return true;
		else
			return false;
	}
	
	public User getUserDetails(String userName){
		return jdbcTemplate.queryForObject(USER_QUERY, new Object[] {userName}, User.class);
		
	}
	
	
}
