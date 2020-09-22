package Day5Ex2Ques5;

import java.util.Scanner;

public class DienThoaiThongMinh extends DienThoaiDiDong implements VuKhi {

	@Override
	public void tanCongKeXau() {
		System.out.println("Ném vào đầu nó");
	}

	@Override
	public void nghe() {
		super.nghe();
		System.out.println("Alo!!!");
	}

	@Override
	public void goi() {
		System.out.println("Nhap sdt muon goi: ");
		Scanner scanner = new Scanner(System.in);
		String inputPhoneNumber = scanner.nextLine();
		System.out.println("Ban dang goi den so: " + inputPhoneNumber);
		System.out.println("Alô!!! nghe gì không?");
	}

	@Override
	public void guiTinNhan() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("SDT: ");
		String phoneNumber = scanner.nextLine();
		System.out.println("Nhap tin nhan: ");
		String string = scanner.nextLine();
		System.out.println("Send to " + phoneNumber);
		System.out.println("Tin nhan la : " + string);
	}

	@Override
	public void nhanTinNhan() {
		System.out.println("Ting Ting!!!");
		System.out.println("VIETTEL thong bao ....");
	}

	public void suDung3g() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Bat 3g an so 1 - tat 3g an so 2");
		System.out.println("Moi ban nhap so: ");
		int macDinh = 2;
		int luaChon = scanner.nextInt();
		scanner.nextLine();
		switch (luaChon) {
		case 1:
			if (macDinh == luaChon) {
				System.out.println("3g da dc bat tu trc");
			} else {
				System.out.println("Ban da bat 3g");
				macDinh = luaChon;
			}
			for (int i = 0; i < 1; i++) {
				System.out.println("Nhap lai ");
				luaChon = scanner.nextInt();
				scanner.nextLine();
				if (luaChon != macDinh) {
					System.out.println("3g da dc tat");
				} else {
					System.out.println("3g da dc bat tu truoc");
					i--;
				}
			}
			break;
		case 2:
			if (macDinh == luaChon) {
				System.out.println("3g da dc tat tu trc");
			} else {
				System.out.println("Ban da tat 3g");
				macDinh = luaChon;
			}
			for (int i = 0; i < 1; i++) {
				System.out.println("Nhap lai ");
				luaChon = scanner.nextInt();
				scanner.nextLine();
				if (luaChon != macDinh) {
					System.out.println("3g da dc bat");
				} else {
					System.out.println("3g da dc tat tu truoc");
					i--;
				}
			}
			break;
		default:
			break;
		}

	}

	public void chupHinh() {
		System.out.println("Tách tách!!!");
	}

}
