package Day7Ex5real.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

import Day7Ex5real.backend.entity.Student;

public class FileUtils {
	private static Writer txtWrite = null;
	private static FileReader txtRead = null;
	private static BufferedReader bufRead = null;
	private static int c = -1;
	
	/**
	 * Mô tả về mục đích của function, mô tả các trường hợp cụ thể bên trong code
	 * @param std chỉ rõ từng thuộc tính là gì
	 * @param soThuTu
	 * @param filePath
	 * @throws IOException có thể có ngoại lệ xảy ra khi nào
	 */
	public static void writeStudent(Student std, int soThuTu, String filePath) throws IOException {
		txtWrite = new FileWriter(new File(filePath), true);
		txtWrite.write("Student " + soThuTu + ": " + std.toString() + "\n");
		txtWrite.close();
	}
	
	public static void writeStudentList(Student[] stds, String filePath) throws IOException {
		for (int i = 0; i < stds.length; i++) {
			writeStudent(stds[i], i+1, filePath);
		}
	}
	
	public static void readStudent(String filePath) throws IOException {
		txtRead = new FileReader(new File(filePath));
		while((c = txtRead.read()) != -1){
			System.out.println((char)c);
		}
		txtRead.close();
	}
	
	/**
	 * Đọc tất cả các student từ file và trả về một danh sách các Student
	 * @param filePath: Đường dẫn tới file
	 * @return ArrayList chứa thông tin tất cả student
	 * @throws IOException 
	 */
	public static ArrayList<Student> readStudentsIntoArray(String filePath) throws IOException{
		ArrayList<Student> stdList = new ArrayList<Student>();
		txtRead = new FileReader(new File(filePath));
		bufRead = new BufferedReader(txtRead);
		String line = null;
		while ((line = bufRead.readLine()) != null) {
			Student currentStudent = convertStringToStudent(line);
			stdList.add(currentStudent);
		}
		
		return stdList;
		
		
	}

	private static Student convertStringToStudent(String line) {
		String id = null;
		String name = null;
		// Phân tích cú pháp text để lấy được id và name
		// Substring(beginIndex, endIndex): "Hieu".substring(1,4) <=> "ieu"
		// beginIndex của id là sau dấu : 1 ký tự
		int beginIndexOfID = line.indexOf(":") + 1;
		int endIndexOfID = line.indexOf("-");
		int beginIndexOfName = endIndexOfID + 1;
		id = line.substring(beginIndexOfID, endIndexOfID);
		name = line.substring(beginIndexOfName);
		return new Student(id, name);
	}

}
