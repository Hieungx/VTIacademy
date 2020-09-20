package Day4Ex5;

import java.util.Scanner;

public class CongNhan extends CanBo {

	private int rank;

	public CongNhan(String name, int age, Gender gender, String address,int rank) {
		super(name, age, gender, address);
		this.rank = rank;
	}
	
	public CongNhan() {
		
	}
	
	public int getRank() {
		return rank;
	}
	
//	@Override
	public void input() {
		super.input();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Input rank: ");
		this.rank = scanner.nextInt();
		
	}
	
	public void getInfor() {
		super.getInfo();
		System.out.println("Rank: "+rank);
	}

	
}
