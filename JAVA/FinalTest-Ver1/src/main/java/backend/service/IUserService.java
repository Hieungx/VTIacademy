package backend.service;

import java.sql.SQLException;
import java.util.List;

import entity.Project;

public interface IUserService {
	public void registerManager(String firstName, String lastName, String phone, String email, String pass,
			int expInYear) throws SQLException;

	public void registerEmployee(String firstName, String lastName, String phone, String email, String pass,
			String projectName, String proSkill) throws SQLException;

	public boolean isUserExists(String email, String pass) throws SQLException;
	public boolean isEmployeeExists(String email, String pass) throws SQLException;
	
	public boolean isProjectExists(int id) throws SQLException;
	
	public List<Project> ShowUserInProject() throws SQLException;
	
	public List<Project> ShowManager() throws SQLException;
}
