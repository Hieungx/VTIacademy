package Day4Ex5;

import java.util.ArrayList;
import java.util.Scanner;

public class QLCB {
	private ArrayList<CanBo> canBos;

	public QLCB() {
		canBos = new ArrayList<>();
	}

	// a) Them moi canbo
	public void addCanbo() {
		// n = so can bo muon nhap
		int n;

		// choose = loai can bo ban muon chon
		byte choose;

		CanBo canBo = new CanBo();
		Scanner scanner = new Scanner(System.in);

		System.out.println("Nhap vao so can bo ban muon nhap: ");
		n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println("Nhập vào kiểu cán bộ: (1 - Công nhân ; 2 - Kỹ sư ; 3 - Nhân viên) ");
			choose = scanner.nextByte();
			switch (choose) {
			case 1:
				canBo = new CongNhan();
				break;
			case 2:
				canBo = new KySu();
				break;
			case 3:
				canBo = new NhanVien();
				break;

			default:
				System.out.println("Wrong!!!!");
				break;
			}
			
			canBo.input();
			canBos.add(canBo);
			
			scanner.close();
		}

	}
	//	b) Tim kiem can bo
	public void findCanBo() {
		Scanner scanner = new Scanner(System.in);
		
		String nameInput;
		System.out.println("Input name you want find: ");
		nameInput =  scanner.nextLine();
		for(CanBo canBo : canBos) {
			if(nameInput.equals(canBo.getName())) {
				canBo.getInfo();
			}
		}
		
	}
	
	// c) Hien thi thong tin va danh sach can bo
	public void showInfo() {
		for(CanBo canBo : canBos) {
			canBo.getInfo();
		}
	}
	
	// d)Nhap vao ten can bo va delete can bo
	public void deleteCanbo() {
		String nameInput;
		Scanner scanner = new Scanner(System.in);
		nameInput = scanner.nextLine();
		canBos.removeIf(canBo -> nameInput.equals(canBo.getName()));
	}

}
