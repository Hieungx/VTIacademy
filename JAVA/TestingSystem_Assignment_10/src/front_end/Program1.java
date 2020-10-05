package front_end;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import backend.Exercise1;

public class Program1 {

	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		Exercise1 program = new Exercise1();
		Scanner scanner = new Scanner(System.in);
		
//question 1
		program.connect();
		
//question 2
		program.readDataPosition();
		
////question 3
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Nhap vao ten: ");
//		String name = scanner.nextLine();
//		program.createPosition(name);
//		
//		//check lai
//		program.readDataPosition();
		
////question 4
//		System.out.println("Nhap vao id muon update: ");
//		int id= scanner.nextInt();
//		scanner.nextLine();
//		System.out.println("Nhap vao ten: ");
//		String positionName = scanner.nextLine();
//		program.updatePositionName(id,positionName);
//		
//		//check lai
//		program.readDataPosition();
		
//question 5
//		System.out.println("id muon xoa : ");
//		int id1 = scanner.nextInt();
//		scanner.nextLine();
//		program.deletePosition(id1);

		
//Close connect
		program.closeConnection();

	}

}
