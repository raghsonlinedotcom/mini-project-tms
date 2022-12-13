package com.tutorials.tms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	
		

		
			private static final String JDBC_URL = "jdbc:mysql://localhost:3306/TMS";
			
			private static final String JDBC_USER = "root";
			
			private static final String JDBC_PASS = "root123";
			
			private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
			
			private static Connection conn = null;
			
			//static String connURL = "jdbc:mysql://localhost:3306/jdbcTest";

			
			private static void createConn() throws SQLException, ClassNotFoundException
			{	
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
			}
			
			public static Connection getConn() throws SQLException, ClassNotFoundException
			{
				if(null==conn) {
					createConn();
				}
				
				return conn;
			}

		

		// TODO Auto-generated constructor stub
	}


