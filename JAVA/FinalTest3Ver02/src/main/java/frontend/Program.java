package frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import backend.controller.UserController;
import entity.Project;
import utils.ScannerUtils;

/**
 * This class is .
 * 
 * @Description: .
 * @author: TrHieu
 * @create_date: Oct 7, 2020
 * @version: 1.0
 * @modifer: TrHieu
 * @modifer_date: Oct 7, 2020
 */
public class Program {

	private static UserController userController;

	public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
		userController = new UserController();

		int chon;

		do {
			System.out.println("\n*******************************************");
			System.out.println("**             Users system              **");
			System.out.println("*******************************************");
			System.out.println("**                                       **");
			System.out.println("**        1. ShowUserInProject      	 **");
			System.out.println("**        2. ShowManager		 **");
			System.out.println("**        3. Đăng Nhập		     	 **");
			System.out.println("**        0. Thoát chương trình          **");
			System.out.println("**                                       **");
			System.out.println("*******************************************");
			chon = ScannerUtils.inputInt("Vui lòng nhập vào một số");
			switch (chon) {
			case 1:
				// dangNhap();
				ShowUserInProject();
				break;
			case 2:
//				dangKy();
//				ShowManager(); chua lam dc
				break;
			case 3:
				dangNhap(); // da lam dc
				break;
			case 4:
//				dangNhap1();
				break;
			case 0:
				System.out.println("Chương trình đã thoát thành công!");
				break;
			default:
				System.err.println("Không có chức năng này, nhập lại!"); // in ra lỗi đỏ
				break;
			}
		} while (chon != 0);
	}

	private static void ShowUserInProject() throws SQLException {
		System.out.println("Nhap vao id Project: ");
		int id = ScannerUtils.inputInt("Nhap lai!");
		if (userController.isProjectExists(id)) {
			List<Project> projects = userController.ShowUserInProject();
			for (Project project : projects) {
				System.out.println(project.toString());
			}
		} else
			System.out.println("id không đúng, kiểm tra lại!");
	}

//	private static void dangNhap() throws SQLException {
//		System.out.println("Nhap Email:");
//		String email = ScannerUtils.inputString("Nhap lai!");
//		System.out.println("Nhap pass word:");
//		String pass = ScannerUtils.inputString("Nhap lai!");
//		if (userController.isUserExists(email, pass))
//			System.out.println("Đăng nhập thành công!");
//		else
//			System.out.println("Email hoặc password không đúng, kiểm tra lại!");
//
//	}
//	
//	private static void dangNhap1() throws SQLException {
//		System.out.println("Nhap Email:");
//		String email = ScannerUtils.inputString("Nhap lai!");
//		System.out.println("Nhap pass word:");
//		String pass = ScannerUtils.inputString("Nhap lai!");
//		if (userController.isEmployeeExists(email, pass))
//			System.out.println("Đăng nhập thành công!");
//		else
//			System.out.println("Email hoặc password không đúng, kiểm tra lại!");
//
//	}

//	private static void dangNhap() throws SQLException {
//		boolean check = false;
//		System.out.println("Nhap loai user muon tao (1-Manager ; 0-Employee): ");
//		while (!check) {
//			int loaiUser = ScannerUtils.inputInt("Nhập vào 1 số");
//			if (loaiUser == 1) {
//				dangNhapManager();
//				check = true;
//			} else if (loaiUser == 0) {
//				dangEmployee();
//				check = true;
//			} else
//				System.out.println("Khong co lua chon nay. nhap lai!");
//		}
//
//	}

	private static void dangNhap() throws SQLException {
		boolean check = false;
		System.out.println("Nhap loai user dang nhap (1-Manager ; 0-Employee): ");
		while (!check) {
			int loaiUser = ScannerUtils.inputInt("Nhập vào 1 số");
			if (loaiUser == 1) {
				System.out.println("Nhap Email:");
				String email = ScannerUtils.inputString("Nhap lai!");
				System.out.println("Nhap pass word:");
				String pass = ScannerUtils.inputString("Nhap lai!");
				if (userController.isUserExists(email, pass) == true)
					System.out.println("Đăng nhập thành công!");
				else
					System.out.println("Email hoặc password không đúng, kiểm tra lại!");
			} else if (loaiUser == 0) {
				System.out.println("Nhap Email:");
				String email = ScannerUtils.inputString("Nhap lai!");
				System.out.println("Nhap pass word:");
				String pass = ScannerUtils.inputString("Nhap lai!");
				if (userController.isEmployeeExists(email, pass) == true)
					System.out.println("Đăng nhập thành công!");
				else
					System.out.println("Email hoặc password không đúng, kiểm tra lại!");
			} else
				System.out.println("Khong co lua chon nay. nhap lai!");
		}

	}

	private static void dangKy() throws SQLException {
		boolean check = false;
		System.out.println("Nhap loai user muon tao (1-Manager ; 0-Employee): ");
		while (!check) {
			int loaiUser = ScannerUtils.inputInt("Nhập vào 1 số");
			if (loaiUser == 1) {
				dangKyManager();
				check = true;
			} else if (loaiUser == 0) {
				dangKyEmployee();
				check = true;
			} else
				System.out.println("Khong co lua chon nay. nhap lai!");
		}

	}

	private static void dangKyEmployee() throws SQLException {
		System.out.println("Nhap FirstName:");
		String firstName = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap LastName:");
		String lastName = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap Phone:");
		String phone = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap Email:");
		String email = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap pass word:");
		String pass = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap ExpInYear:");
		int expInYear = ScannerUtils.inputInt("Nhap lai!");
		userController.registerManager(firstName, lastName, phone, email, pass, expInYear);

	}

	private static void dangKyManager() throws SQLException {
		System.out.println("Nhap FirstName:");
		String firstName = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap LastName:");
		String lastName = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap Phone:");
		String phone = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap Email:");
		String email = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap pass word:");
		String pass = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap projectName:");
		String projectName = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap ProSkill:");
		String proSkill = ScannerUtils.inputString("Nhap lai!");
		userController.registerEmployee(firstName, lastName, phone, email, pass, projectName, proSkill);
	}

}
