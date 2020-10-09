//package utils;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//import utils.properties.DatabaseProperties;
//
///**
// * 
// * @author AD
// *
// */
//
//public class JdbcUtils {
//	private Connection connection;
//	private DatabaseProperties properties;
//
//	// ham khoi tao
//	public JdbcUtils() throws FileNotFoundException, IOException {
//		properties = new DatabaseProperties();
//	}
//
//	public Connection getConnection() throws SQLException {
//		String url = properties.getProperty("dbUrl");
//		String user = properties.getProperty("user");
//		String password = properties.getProperty("password");
//
//		connection = DriverManager.getConnection(url, user, password);
//		System.out.println("Connection Success!");
//		return connection;
//	}
//
//	public void disconnect() throws SQLException {
//		connection.close();
//	}
//}

package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utils.properties.DatabaseProperties;

public class JdbcUtils {
//	private static final String dbUrl = "jdbc:mysql://localhost:3306/qlyungvien";
//	private static final String username = "root";
//	private static final String pass = "hieu4438";
//	private Connection myConn;
//	
//	public static boolean isConnectedForTesting() throws SQLException {
//		boolean test = false;
//		
//		DriverManager.getConnection(dbUrl, username, pass);
//		System.out.println("Connect success!");
//		test = true;
//		
//		return test;
//	}
//	
//	public Connection getConnection() throws SQLException {
//		if (myConn == null || myConn.isClosed()) {
//			myConn = DriverManager.getConnection(dbUrl, username, pass);
//		}
//		
//		return myConn;
//	}
//	
//	public void disconnect() throws SQLException {
//		if(myConn != null && !myConn.isClosed()) {
//			myConn.close();
//		}
//	}

	private Connection myConn;
	private DatabaseProperties databaseProperties;

	public JdbcUtils() throws FileNotFoundException, IOException {
		databaseProperties = new DatabaseProperties();
	}
	
	public Connection getConnection() throws SQLException {
		String url = databaseProperties.getProperty("dbUrl");
		String user = databaseProperties.getProperty("user");
		String password = databaseProperties.getProperty("password");
		
		myConn = DriverManager.getConnection(url,user,password);
		
		return myConn;
	}
	
	public void disconnect() throws SQLException {
		myConn.close();
	}
}
