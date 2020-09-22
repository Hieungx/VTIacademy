package Day5;

import java.util.Scanner;

public abstract class DienThoaiDiDong {
	
	
	public void nghe() {
		Scanner scanner = new Scanner(System.in);
		String inputNumber = scanner.nextLine();
		System.out.print(inputNumber + " is calling ");
	};

	public abstract void goi();

	public abstract void guiTinNhan();

	public abstract void nhanTinNhan();

}
