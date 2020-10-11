package backend.service;

import java.sql.SQLException;
import java.util.List;

import entity.Project;

public interface IUserService {

	public boolean isManagerExists(String email, String pass) throws SQLException;

	public boolean isEmployeeExists(String email, String pass) throws SQLException;

	public boolean isProjectExists(int id) throws SQLException;

	public List<Project> ShowUserInProject(int id) throws SQLException;

	public List<Project> ShowManager() throws SQLException;
}
