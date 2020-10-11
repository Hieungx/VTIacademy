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

	public boolean isManagerExists(String email, String pass) throws SQLException {
		return userService.isManagerExists(email, pass);
	}

	public boolean isEmployeeExists(String email, String pass) throws SQLException {
		return userService.isEmployeeExists(email, pass);
	}

	public boolean isProjectExists(int id) throws SQLException {
		return userService.isProjectExists(id);
	}

	public List<Project> ShowUserInProject(int id) throws SQLException {
		return userService.ShowUserInProject(id);
	}

	public List<Project> ShowManager() throws SQLException {
		return userService.ShowManager();
	}
}
