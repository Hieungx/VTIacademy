package backend.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backend.service.IUserService;
import backend.service.UserService;
import entity.Project;

public class UserController {
	private IUserService userService;

	public UserController() throws FileNotFoundException, IOException {
		userService = new UserService();
	}

	public void registerManager(String firstName, String lastName, String Phone, String email, String pass,
			int expInYear) throws SQLException {
		userService.registerManager(firstName, lastName, Phone, email, pass, expInYear);
	}

	public void registerEmployee(String firstName, String lastName, String Phone, String email, String pass,
			String projectName, String proSkill) throws SQLException {
		userService.registerEmployee(firstName, lastName, Phone, email, pass, projectName, proSkill);
	}

	public boolean isUserExists(String email, String pass) throws SQLException {
		return userService.isUserExists(email, pass);
	}
	
	public boolean isEmployeeExists(String email, String pass) throws SQLException {
		return userService.isEmployeeExists(email, pass);
	}
	
	public boolean isProjectExists(int id) throws SQLException {
		return userService.isProjectExists(id);
	}
	
	public List<Project> ShowUserInProject() throws SQLException {
		return userService.ShowUserInProject();
	}

	
	public List<Project> ShowManager() throws SQLException {
		return userService.ShowUserInProject();
	}
}
