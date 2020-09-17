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
		Date date = new Date();
//		System.out.println(date);
		String[] accounts = new String[4];
		for (int i = 0; i <= 3; i++) {
			switch (i) {
			case 0:
				accounts[i] = "Email 1";
				break;
			case 1:
				accounts[i] = "User name 1";
			case 2:
				accounts[i] = "Full name 1";
			default:
				accounts[i] = date.toString();
				break;
			}
		}
		System.out.println();
		System.out.println("EX 4 - QUESTION 3");
		Person test = new Person();
		test.CaplocksName("hieu");
		System.out.println();
		System.out.println("EX 4 - QUESTION 4");
		test.PrintChar("Hieu");
		System.out.println("EX 4 - QUESTION 15");
		test.RevertByWord("I am developer");
		
	}
}
