package Day5Ex2Ques5;

import java.util.Scanner;

public abstract class DienThoaiDiDong {

	public void nghe() {
		String inputNumber = "VIETTEL";
		System.out.print(inputNumber + " is calling ");
	};

	public abstract void goi();

	public abstract void guiTinNhan();

	public abstract void nhanTinNhan();

}
