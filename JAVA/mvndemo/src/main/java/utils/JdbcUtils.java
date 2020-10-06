package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utils.properties.DatabaseProperties;

/**
 * class Jdbc viet gi thi viet
 * 
 * @author TrHieu
 *
 */
public class JdbcUtils {

	private Connection connection;
	private DatabaseProperties databaseProperties;

	public JdbcUtils() throws FileNotFoundException, IOException {
		databaseProperties = new DatabaseProperties();
	}

	public Connection connect() throws SQLException {
		String url = databaseProperties.getProperty("dbUrl");
		String user = databaseProperties.getProperty("user");
		String password = databaseProperties.getProperty("password");
		
		connection = DriverManager.getConnection(url,user,password);
		
		return connection;
	}
	
	public void disconnect() throws SQLException {
		connection.close();
	}
	
}
