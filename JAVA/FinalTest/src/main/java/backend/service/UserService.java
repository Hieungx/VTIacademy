package backend.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backend.repository.IUserReponsitory;
import backend.repository.UserReponsitory;
import entity.Project;
import utils.ScannerUtils;

public class UserService implements IUserService {
	private IUserReponsitory userReponsitory;

	public UserService() throws FileNotFoundException, IOException {
		userReponsitory = new UserReponsitory();
	}

	private boolean chuanHoaEmail(String email) {
//		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@vti.com.vn";
		// nguyen.vannam@vti.com.vn
		// Chú thích : \\w : đại diện cho bảng chữ cái và số
		// $ : đánh dấu kết thúc của 1 dòng
		// ^ : bắt đầu 1 dòng hoặc 1 chuỗi
		String email1 = email;
		Boolean check = email1.matches(EMAIL_REGEX);
		return check;
	}

	private boolean checkPassword(String pass) {
		// Password chi trog khoang tu 6-12 ky tuu
		// Password phai co 1 chu cai viet hoa
		boolean check = false;
		boolean check2 = false;

		for (int i = 0; i < pass.length(); i++) {
			if (Character.isUpperCase(pass.charAt(i)))
				check = true;
		}

		if (pass.length() > 5 && pass.length() < 13 && check == true) {
			check2 = true;
		}

		return check2;
	}


	public boolean isManagerExists(String email, String pass) throws SQLException {

		String email1 = email;
		String pass1 = pass;
		boolean check = false;

		while (!check) {
			if (chuanHoaEmail(email1)) {
				check = true;
			} else {
				System.out.println("Email nhap chua dung dinh dang. Nhap lai!");
				email1 = ScannerUtils.inputString("Vui long nhap!");
			}
		}
		check = false;
		while (!check) {
			if (checkPassword(pass1)) {
				check = true;
			} else {
				System.out.println("Pass nhập sai định dạng. Nhap lai!");
				pass1 = ScannerUtils.inputString("Vui long nhap!");
			}
		}

		return userReponsitory.isManagerExists(email1, pass1);
	}

	public boolean isEmployeeExists(String email, String pass) throws SQLException {

		String email1 = email;
		String pass1 = pass;
		boolean check = false;

		while (!check) {
			if (chuanHoaEmail(email1)) {
				check = true;
			} else {
				System.out.println("Email nhap chua dung dinh dang. Nhap lai!");
				email1 = ScannerUtils.inputString("Vui long nhap!");
			}
		}
		check = false;
		while (!check) {
			if (checkPassword(pass1)) {
				check = true;
			} else {
				System.out.println("Pass nhập sai định dạng. Nhap lai!");
				pass1 = ScannerUtils.inputString("Vui long nhap!");
			}
		}

		return userReponsitory.isEmployeeExists(email1, pass1);
	}

	public boolean isProjectExists(int id) throws SQLException {

		return userReponsitory.isProjectExists(id);
	}

	public List<Project> ShowUserInProject(int id) throws SQLException {

		return ((UserReponsitory) userReponsitory).ShowUserInProject(id);
	}
	

	public List<Project> ShowManager() throws SQLException {

		return ((UserReponsitory) userReponsitory).ShowManager();
	}

}
