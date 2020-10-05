package backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Exercise1 {

	private Properties properties;
	private Connection connection;

	Statement myStatement;
	ResultSet resultSet;

	public Exercise1() throws FileNotFoundException, IOException {
		properties = new Properties();
		properties.load(new FileInputStream("src/backend/ConfigsDatabase.properties"));
	}

//Question 1
	public void connect() throws SQLException {
		String dbUrl = properties.getProperty("dbUrl"); // duong dan toi database
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");

		connection = DriverManager.getConnection(dbUrl, user, password);

		System.out.println("Connected!");

	}

//question2
	public void readDataPosition() throws SQLException {
		Statement myStatement = connection.createStatement(); // tao cau lenh

		ResultSet resultSet = myStatement.executeQuery("select * from position"); // chay cau lenh va hứng kết quả trả
																					// về
		while (resultSet.next()) {
			System.out.println(resultSet.getInt(1) + ", " + resultSet.getString(2));
		}
	}

//question 3
	public void createPosition(String name) throws SQLException {
		Statement myStatement = connection.createStatement();
		// insert
		int rowsAffected = myStatement.executeUpdate("insert into position (positionName) values ('" + name + "')");
	}

//question 4
	public void updatePositionName(int id, String positionName) throws SQLException {
		myStatement = connection.createStatement();
		int rowsAffected = myStatement
				.executeUpdate("update position set positionName = '" + positionName + "' where positionid = " + id);
	}

//question 5
	public void deletePosition(int id) throws SQLException {
		myStatement = connection.createStatement();
		int rowsAffected = myStatement.executeUpdate("delete from position where positionid = " + id);
	}

	public void closeConnection() throws SQLException {
		connection.close();
	}

}
