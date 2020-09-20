package Day4Ex5;

import java.util.Scanner;

public class CanBo {
	private String name;
	private int age;
	private Gender gender;
	private String address;

	public CanBo(String name, int age, Gender gender, String address) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	
	public CanBo() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(int gender) {
		if (gender == 0) {
			this.gender = Gender.valueOf("MALE");
		} else if (gender == 1) {
			this.gender = Gender.valueOf("FEMALE");
		} else {
			this.gender = Gender.valueOf("UNKNOW");
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void input() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Input name: ");
		name = scanner.nextLine();
		System.out.println("Input age: ");
		age = scanner.nextInt();
		System.out.println("Input gender: (0-Male ; 1-Femal ; OtherNumber - Unknow)");
		setGender(scanner.nextInt());
		System.out.println("Input address: ");
		address = scanner.nextLine();
	}

	public void getInfo() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Gener: " + gender);
		System.out.println("Address: " + address);
	}

//	@Override
	public String toString() {
		return "Can Bo: ( " + name + "-" + age + "-" + gender + "-" + address + " )";
	}

}
