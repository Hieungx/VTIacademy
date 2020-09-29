package Day7Ex5real;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Day7Ex5real.backend.entity.Student;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		File file = new File("F:\\StudentInformation.txt");
		FileWriter fW = null;
		FileInputStream fis = null;
		Student student = new Student();
		try {
			fW = new FileWriter(file);
			for (int i = 0; i < 3; i++) {
				System.out.print("Nhap vao id " + (i + 1) + " ");
				student.setId(scanner.nextLine());
				fW.write("Id " + (i + 1) + " :" + student.getId() + "\n");
				System.out.print("Nhap vao name ");
				student.setName(scanner.nextLine());
				fW.write("name : " + student.getName() + "\n");
			}
			fis = new FileInputStream("F:\\StudentInformation.txt");
// -------------------------------------------------
//			while ((check = fis.read()) != -1) {
//				System.out.print((char) check);
//			}	
// -------------------------------------------------
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fW.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		int check;
		try {
			while ((check = fis.read()) != -1) {
				System.out.print((char) check);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
