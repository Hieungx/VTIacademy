package Day4Ex5;

import java.util.Scanner;

public class KySu extends CanBo {

	private String major;

	public KySu(String name, int age, Gender gender, String address,String major) {
		super(name, age, gender, address);
		this.major = major;
	}
	
	public KySu() {
		
	}
	
	public String getMajor() {
		return major;
	}
	
//	@Overide
	public void input() {
		super.input();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Inpt Major: ");
		major = scanner.nextLine();
	}
	
	public void getInfor() {
		super.getInfo();
		System.out.println("major: "+ major);
	}

}
