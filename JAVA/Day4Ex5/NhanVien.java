package Day4Ex5;

import java.util.Scanner;

public class NhanVien extends CanBo {
	
	private String work;

	public NhanVien(String name, int age, Gender gender, String address,String work) {
		super(name, age, gender, address);
		this.work = work;
	}
	
	public NhanVien() {
		
	}
	
	public String getWork() {
		return work;
	}
	
//	@override
	public void input() {
		super.input();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input Work: ");
		work = scanner.nextLine();
	}
	
	public void getInfor() {
		super.getInfo();
		System.out.println("Work: "+work);
	}

}
