package com.tutorials.tms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.tutorials.tms.util.PropertyUtil;

public class DBConnection 
{
	private static final String JDBC_URL = PropertyUtil.getDBPropertyValue("jdbc.url");
	
	private static final String JDBC_USER = PropertyUtil.getDBPropertyValue("jdbc.user.name");
	
	private static final String JDBC_PASS = PropertyUtil.getDBPropertyValue("jdbc.user.pass");
	
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	
	private static Connection conn = null;
	
	private static void createConn() 
		throws SQLException, ClassNotFoundException
	{	
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
	}
	
	public static Connection getConn() 
		throws SQLException, ClassNotFoundException
	{
		if(null==conn || conn.isClosed()) {
			createConn();
		}
		
		return conn;
	}
}