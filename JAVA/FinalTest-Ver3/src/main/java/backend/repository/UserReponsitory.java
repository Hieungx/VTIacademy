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

	public UserReponsitory() throws FileNotFoundException, IOException {
		jdbcUtils = new JdbcUtils();
	}

	public boolean isManagerExists(String email, String pass) throws SQLException {
		Connection con = jdbcUtils.getConnection();
		String query = "select * from `manager` where email = ? and pass = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, pass);

		boolean check = false;
		ResultSet set = preparedStatement.executeQuery();

		if (set.next())
			check = true;

		jdbcUtils.disconnect();
		return check;
	}

	public boolean isEmployeeExists(String email, String pass) throws SQLException {
		boolean check = false;
		Connection con = jdbcUtils.getConnection();
		String query = "select * from `employee` where email = ? and pass = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, pass);

		ResultSet set = preparedStatement.executeQuery();

		if (set.next())
			check = true;

		jdbcUtils.disconnect();
		return check;
	}

	public boolean isProjectExists(int id) throws SQLException {
		Connection con = jdbcUtils.getConnection();
		String query = "select idManager,idEmployee from `project` where id = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setInt(1, id);

		boolean check = false;
		ResultSet set = preparedStatement.executeQuery();

		if (set.next())
			check = true;

		jdbcUtils.disconnect();
		return check;
	}

	public List<Project> ShowUserInProject(int id) throws SQLException {
		List<Project> projects = new ArrayList<Project>();

		Connection connection = jdbcUtils.getConnection();

		String sql = "select * from project where id = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			int projectId = resultSet.getInt(1);
			int teamSize = resultSet.getInt(1);
			int idManager = resultSet.getInt(1);
			int idEmployees = resultSet.getInt(1);

			Project project = new Project(projectId, teamSize, idManager, idEmployees);
			projects.add(project);
		}
		jdbcUtils.disconnect();
		return projects;
	}



	public List<Project> ShowManager() throws SQLException {
		List<Project> projects = new ArrayList<Project>();

		Connection connection = jdbcUtils.getConnection();

		String sql = "select * from project";

		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int projectId = resultSet.getInt(1);
			int teamSize = resultSet.getInt(1);
			int idManager = resultSet.getInt(1);
			int idEmployees = resultSet.getInt(1);

			Project project = new Project(projectId, teamSize, idManager, idEmployees);
			projects.add(project);
		}
		jdbcUtils.disconnect();
		return projects;
	}

}
