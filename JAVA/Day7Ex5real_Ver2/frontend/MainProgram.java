package Day7Ex5real.frontend;

import java.io.IOException;
import java.util.ArrayList;

import Day7Ex5real.backend.entity.Student;
import Day7Ex5real.common.FileUtils;

public class MainProgram {

	public static void main(String[] args) throws IOException {
		Student s1 = new Student("1", "Hung");
		Student s2 = new Student("2", "Hieu");
		Student s3 = new Student("3", "Tan");
		Student[] stdList = {s1, s2, s3};
		String filePath = "src/Day7Ex5real/studentlist.txt";
		FileUtils.writeStudentList(stdList, filePath);
		ArrayList<Student> stds = FileUtils.readStudentsIntoArray(filePath);
		for (Student student : stds) {
			System.out.println(student.toString());
		}
	}

}
