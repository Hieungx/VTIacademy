package entity;

public class Employee extends User {
	private String projectName;
	private String proSkill;

	public Employee(int id, String fullName, String email, String password, String projectName, String proSkill) {
		super(id, fullName, email, password);
		this.projectName = projectName;
		this.proSkill = proSkill;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProSkill() {
		return proSkill;
	}

	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}

}
