package Day4Ex4;

public class main {

	public static void main(String[] args) {
		Student student = new Student();
		student.Student("Nguyen Trung Hieu", "Ha Noi");
		System.out.println(student.getScored());
		student.setScored(6);
		System.out.println(student.getScored());
		student.setSocred(4);
		System.out.println(student.getScored());
		student.showInfo();
	}

}
