package backend.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Project;
import utils.JdbcUtils;

public class UserReponsitory implements IUserReponsitory {
	private static JdbcUtils jdbcUtils;
	
	public UserReponsitory() throws FileNotFoundException, IOException{
		jdbcUtils = new JdbcUtils();
	}

	public void registerManager(String firstName, String lastName, String phone, String email, String pass,
			int expInYear) throws SQLException {
		
		Connection con = jdbcUtils.getConnection();
		String query = "insert into `users` (firstName, lastName, phone, email, pass, expInYear) values(?,?,?,?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1,firstName);
		preparedStatement.setString(2,lastName);
		preparedStatement.setString(3,phone);
		preparedStatement.setString(4,email);
		preparedStatement.setString(5,pass);
		preparedStatement.setInt(6,expInYear);
		
		int row = preparedStatement.executeUpdate();
		if(row==1)
			System.out.println("Tạo mới tài khoản thành công!");

		jdbcUtils.disconnect();
	}

	public void registerEmployee(String firstName, String lastName, String phone, String email, String pass,
			String projectName, String proSkill) throws SQLException  {
		Connection con = jdbcUtils.getConnection();
		String query = "insert into `users` (firstName, lastName, phone, email, pass, projectName, proSkill) values(?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1,firstName);
		preparedStatement.setString(2,lastName);
		preparedStatement.setString(3,phone);
		preparedStatement.setString(4,email);
		preparedStatement.setString(5,pass);
		preparedStatement.setString(6,projectName);
		preparedStatement.setString(7,proSkill);
		
		int row = preparedStatement.executeUpdate();
		if(row==1)
			System.out.println("Tạo mới tài khoản thành công!");

		jdbcUtils.disconnect();
		
	}

	public boolean isUserExists(String email, String pass) throws SQLException  {
		Connection con = jdbcUtils.getConnection();
		String query = "select * from `manager` where email = ? and pass = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1,email);
		preparedStatement.setString(2,pass);
		
		boolean check = false;
		ResultSet set = preparedStatement.executeQuery();
		
		if(set.next())
			check = true;

		jdbcUtils.disconnect();
		return check;
	}
	
	public boolean isEmployeeExists(String email, String pass) throws SQLException  {
		boolean check = false;
		Connection con = jdbcUtils.getConnection();
		String query = "select * from `employee` where email = ? and pass = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1,email);
		preparedStatement.setString(2,pass);
		
		ResultSet set = preparedStatement.executeQuery();
		
		if(set.next())
			check = true;

		jdbcUtils.disconnect();
		return check;
	}
	
	public boolean isProjectExists(int id) throws SQLException  {
		Connection con = jdbcUtils.getConnection();
		String query = "select idManager,idEmployee from `project` where id = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1,id);
		
		boolean check = false;
		ResultSet set = preparedStatement.executeQuery();
		
		if(set.next())
			check = true;

		jdbcUtils.disconnect();
		return check;
	}

	public List<Project> ShowUserInProject() throws SQLException {
		List<Project> projects= new ArrayList<Project>();

		Connection connection = jdbcUtils.getConnection();

		String sql = "select * from project";

		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int projectId = resultSet.getInt(1);
			int teamSize = resultSet.getInt(1);
			int idManager = resultSet.getInt(1);
			int idEmployees = resultSet.getInt(1);

			Project project= new Project(projectId, teamSize, idManager, idEmployees);
			projects.add(project);
		}
		jdbcUtils.disconnect();
		return projects;
	}
	
	public List<Project> ShowManager() throws SQLException {
		List<Project> projects= new ArrayList<Project>();

		Connection connection = jdbcUtils.getConnection();

		String sql = "select * from project";

		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int projectId = resultSet.getInt(1);
			int teamSize = resultSet.getInt(1);
			int idManager = resultSet.getInt(1);
			int idEmployees = resultSet.getInt(1);

			Project project= new Project(projectId, teamSize, idManager, idEmployees);
			projects.add(project);
		}
		jdbcUtils.disconnect();
		return projects;
	}
}
