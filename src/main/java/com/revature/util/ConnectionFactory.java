package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private static ConnectionFactory cf = null;
	private static Boolean build = true;
	
	private ConnectionFactory() {
		build = false;
	}
	
	public static synchronized ConnectionFactory getInstance() {
		if(build) cf = new ConnectionFactory();
		
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			Properties props = new Properties();
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
			Class.forName(props.getProperty("driver"));
			conn = DriverManager.getConnection(props.getProperty("url"), props.getProperty("usr"), props.getProperty("pwd"));
			return conn;
		} catch (SQLException sql) {
			sql.printStackTrace();
			//System.out.println("SQL Error " + sql.getErrorCode() + ": " + sql.getSQLState());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
