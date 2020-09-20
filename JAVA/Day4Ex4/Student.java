package Day4Ex4;

public class Student {
	private int id;
	private String name;
	private String homeTown;
	private float scored;

	public void Student(String name, String homeTown) {
		this.name = name;
		this.homeTown = homeTown;
		this.scored = 0;
	}

	public void setScored(float scored) {
		this.scored = scored;
	}

	public void setSocred(float bonusPoint) {
		if (scored + bonusPoint <= 10 && scored + bonusPoint >= 0) {
			setScored(scored + bonusPoint);
		}
	}

	public String getName() {
		return name;
	}

	public float getScored() {
		return scored;
	}

	public void showInfo() {
		System.out.print("Tên sinh viên : ");
		getName();
		System.out.println();
		System.out.print("�?iểm : ");
		getScored();
		System.out.println();
		System.out.print("H�?c lực : ");
		if (getScored() < 4.00) {
			System.out.println("Yếu");
		} else if (getScored() > 4 && getScored() < 6) {
			System.out.println("Trung bình");
		} else if (getScored() > 6 && getScored() < 8) {
			System.out.println("Khá");
		} else {
			System.out.println("Gi�?i");
		}
		;
	}

}
