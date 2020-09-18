package Day3;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		System.out.println("EX 1 - QUESTION 2");
		Random random = new Random();
		int number = 10000 + random.nextInt(89999);
		System.out.println("Số vừa được sinh ra là " + number + "\n");

		System.out.println("EX 1 - QUESTION 3");
		String s = String.valueOf(number);
		System.out.println(s.substring(3) + "\n");

		System.out.println("EX 2 - QUESTION 1");
//		Date date = new Date();
//		String[] accounts = new String[4];
//		for (int i = 0; i <= 3; i++) {
//			switch (i) {
//			case 0:
//				accounts[i] = "Email 1";
//				break;
//			case 1:
//				accounts[i] = "User name 1";
//			case 2:
//				accounts[i] = "Full name 1";
//			default:
//				accounts[i] = date.toString();
//				break;
//			}
//		}

		System.out.println();
		System.out.println("EX 4 - QUESTION 3");
		Person test = new Person();
		test.CaplocksName("hieu");
		System.out.println();
		System.out.println("EX 4 - QUESTION 4");
		test.PrintChar("Hieu");
		System.out.println("EX 4 - QUESTION 15");
		test.RevertByWord("I am developer");
		System.out.println();
		System.out.println("Ex2");

		Person[] students = new Person[5];
		for (int i = 0; i < students.length; i++) {
			students[i] = new Person();
			students[i].email = "Email " + i;
			students[i].userName = "User name " + i;
			students[i].fullName = "Full name " + i;
			students[i].createDate = LocalDate.now();
		}

		for (int i = 0; i < students.length; i++) {
			System.out.println("Email: " + students[i].email);
			System.out.println("UserName: " + students[i].userName);
			System.out.println("FullName: " + students[i].email);
			System.out.println("CreateDate: " + students[i].createDate);
			System.out.println();
			System.out.println();
		}
		System.out.println("EX 5 - QUESTION 6");
		Department[] departments = new Department[5];
		for (int i = 0; i < departments.length; i++) {
			departments[i].name = "Accounting";
			departments[i].name = "Boss of director";
			departments[i].name = "Sale";
			departments[i].name = "Waiting room";
			departments[i].name = "Marketing";
			
		}
		
	}
}
