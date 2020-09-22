package Day5Ex2Ques5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap 1 neu muon su dung dien thoai thong minh");
		System.out.println("Nhap 2 neu muon su dung dien thoai co dien");
		System.out.println("Ban muon su dung dien thoai nao ?");
		int choose = scanner.nextInt();
		scanner.hasNextLine();
		if (choose == 1) {
			DienThoaiDiDong phone1 = new DienThoaiThongMinh();
			DienThoaiThongMinh chucNangThongMinh = new DienThoaiThongMinh();
			System.out.println("Chon chuc nang ban muon su dung");
			int chucNang = scanner.nextInt();
			scanner.nextLine();
			switch (chucNang) {
			case 1:
				phone1.nghe();
				break;
			case 2:
				phone1.goi();
				break;
			case 3:
				phone1.guiTinNhan();
				break;
			case 4:
				chucNangThongMinh.suDung3g();
			default:
				break;
			}
		}
		// lam truong hop tuong tu voi dien thoai co dien
	}

}
