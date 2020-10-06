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

import entity.Department;
import utils.JdbcUtils;

public class DepartmentRepository implements IDepartmentRepository {

	private JdbcUtils jdbcUtils;

	public DepartmentRepository() throws FileNotFoundException, IOException {
		jdbcUtils = new JdbcUtils();
	}

	@Override
	public List<Department> showDepartmentList() throws SQLException {
		List<Department> departments = new ArrayList<Department>();

		Connection connection = jdbcUtils.connect();

		String sql = "select * from department";

		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery(sql);

		while (resultSet.next()) {
			int id = resultSet.getInt(1);
			String name = resultSet.getString(2);

			Department department = new Department(id, name);
			departments.add(department);
		}
		jdbcUtils.disconnect();
		return departments;
	}

	@Override
	public boolean insertDepartment(String name) throws SQLException {
		Connection connection = jdbcUtils.connect();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into department(departmentName) values(?)");
		preparedStatement.setString(1, name);
		int rowsAffected = preparedStatement.executeUpdate();
		if (rowsAffected > 0) {
			return true;
		} else {
			return false;
		}
	}

}
