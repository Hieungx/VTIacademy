package Day5Ex2Ques5;

public class DienThoaiCoDien extends DienThoaiDiDong implements VuKhi {

	@Override
	public void nghe() {
		super.nghe();
		System.out.println(" �?iện thoại đểu");
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

	@Override
	public void tanCongKeXau() {
		System.out.println("Ném vào đầu nó");
	}

	public void ngheRadio() {
		System.out.println("Tìm kênh .... ");
	}

}
