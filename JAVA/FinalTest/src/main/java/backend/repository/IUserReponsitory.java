package backend.repository;

import java.sql.SQLException;
import java.util.List;

import entity.Project;

public interface IUserReponsitory {

	public boolean isManagerExists(String email, String pass) throws SQLException;

	public boolean isEmployeeExists(String email, String pass) throws SQLException;

	public boolean isProjectExists(int id) throws SQLException;

	List<Project> ShowUserInProject(int id) throws SQLException;

	List<Project> ShowManager() throws SQLException;
}
