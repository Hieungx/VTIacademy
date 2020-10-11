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
				ShowUserInProject();
				break;
			case 2:
				ShowManager();
				break;
			case 3:
				dangNhap(); // da lam dc
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

	private static void ShowManager() throws SQLException {
		List<Project> projects = userController.ShowManager();
		for (Project project : projects) {
			System.out.println(project.toString1());
		}
	}

	private static void ShowUserInProject() throws SQLException {
		System.out.println("Nhap vao id Project: ");
		int id = ScannerUtils.inputInt("Nhap lai!");
		if (userController.isProjectExists(id)) {
			List<Project> projects = userController.ShowUserInProject(id);
			for (Project project : projects) {
				System.out.println(project.toString());
			}
		} else
			System.out.println("id không đúng, kiểm tra lại!");
	}

//	private static void dangNhap() throws SQLException {
//		boolean check = false;
//		System.out.println("Nhap loai user dang nhap (1-Manager ; 0-Employee): ");
//		while (!check) {
//			int loaiUser = ScannerUtils.inputInt("Nhập vào 1 số");
//			if (loaiUser == 1) {
//				System.out.println("Nhap Email:");
//				String email = ScannerUtils.inputString("Nhap lai!");
//				System.out.println("Nhap pass word:");
//				String pass = ScannerUtils.inputString("Nhap lai!");
//				if (userController.isManagerExists(email, pass) == true)
//					System.out.println("Đăng nhập thành công!");
//				else
//					System.out.println("Email hoặc password không đúng, kiểm tra lại!");
//			} else if (loaiUser == 0) {
//				System.out.println("Nhap Email:");
//				String email = ScannerUtils.inputString("Nhap lai!");
//				System.out.println("Nhap pass word:");
//				String pass = ScannerUtils.inputString("Nhap lai!");
//				if (userController.isEmployeeExists(email, pass) == true)
//					System.out.println("Đăng nhập thành công!");
//				else
//					System.out.println("Email hoặc password không đúng, kiểm tra lại!");
//			} else
//				System.out.println("Khong co lua chon nay. nhap lai!");
//		}
//
//	}

	private static void dangNhap() throws SQLException {
		System.out.println("Nhập email: ");
		String email = ScannerUtils.inputString("Nhap lai!");
		System.out.println("Nhap pass word:");
		String pass = ScannerUtils.inputString("Nhap lai!");
		if (userController.isManagerExists(email, pass) == true) {
			System.out.println("Đăng nhập thành công!");
		} else if (userController.isEmployeeExists(email, pass) == true) {
			System.out.println("Đăng nhập thành công!");
		} else {
			System.out.println("Email hoặc password chưa chính xác!");
		}
	}

}
