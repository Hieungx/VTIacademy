package Day5;

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
		System.out.println("Alô!!! nghe gì không?");
	}

	@Override
	public void guiTinNhan() {
		System.out.println("Send!");
	}

	@Override
	public void nhanTinNhan() {
		System.out.println("Ting Ting!!!");
	}

	public void suDung3g() {
		System.out.println("Turn on 3g");
	}

	public void chupHinh() {
		System.out.println("Tách tách!!!");
	}

}
