package Day7Ex5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class Student {

	public static void main(String[] args) {
		String id;
		String name;

		Scanner scanner = new Scanner(System.in);
		File file = new File("F:\\StudentInformation.txt");
		FileWriter fW = null;
		FileInputStream fis = null;
		try {
			fW = new FileWriter(file);
			for (int i = 0; i < 3; i++) {
				System.out.print("Nhap vao id " + (i + 1) + " ");
				id = scanner.nextLine();
				fW.write("Id " + (i + 1) + " :" + id + "\n");
				System.out.print("Nhap vao name ");
				name = scanner.nextLine();
				fW.write("name : " + name + "\n");
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
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
