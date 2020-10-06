package frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backend.controller.DepartmentController;
import entity.Department;

public class UserInterface {

	public static void main(String[] args) {
		String name;

		// question 1
		try {
			showDepartmentList();
			insertDepartment("rocket07");
		} catch (SQLException e) {
			System.out.println("Errors");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void showDepartmentList() throws SQLException, FileNotFoundException, IOException {
		DepartmentController dC = new DepartmentController();
		List<Department> departmentList = dC.showDepartmentList();
		for (Department department : departmentList) {
			System.out.println(department.toString());
		}
	}
	
	private static void insertDepartment(String name) throws SQLException, FileNotFoundException, IOException {
		DepartmentController dC = new DepartmentController();
		System.out.println(dC.insertDepartment(name));
	}

}
