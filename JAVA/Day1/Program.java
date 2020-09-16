package Day1;

import java.time.LocalDate;
import java.util.Date;

public class Program {

	public static void main(String[] args) {
		// DEPARTMENT
		Department department1 = new Department();
		department1.departmentID = 1;
		department1.departmentName = "Sale";

		Department department2 = new Department();
		department2.departmentID = 2;
		department2.departmentName = "Marketing";

		Department department3 = new Department();
		department3.departmentID = 3;
		department3.departmentName = "IT ";

//		POSITION
		Position position1 = new Position();
		position1.positionID = 1;
		position1.positionName = PositionName.TEST;

		Position position2 = new Position();
		position2.positionID = 2;
		position2.positionName = PositionName.PM;

		Position position3 = new Position();
		position3.positionID = 3;
		position3.positionName = PositionName.SCRUM_MASTER;

		Position position4 = new Position();
		position4.positionID = 4;
		position4.positionName = PositionName.DEV;

//		ACCOUNT
		Account account1 = new Account();
		account1.accountID = 1;
		account1.email = "hieuu99@gmail.com";
		account1.userName = "Hieungx";
		account1.fullName = "Nguyen Trung Hieu";
		account1.department = department1;
		account1.position = position1;
		account1.createDate = LocalDate.now();

		Account account2 = new Account();
		account2.accountID = 2;
		account2.email = "hoanganh@gmail.com";
		account2.userName = "HoangAnh";
		account2.fullName = "Pham Hoang Anh";
		account2.department = department2;
		account2.position = position2;
		account2.createDate = LocalDate.now();

		Account account3 = new Account();
		account3.accountID = 3;
		account3.email = "LeAnh@gmail.com";
		account3.userName = "LeAnh";
		account3.fullName = "Le Minh Anh";
		account3.department = department1;
		account3.position = position1;
		account3.createDate = LocalDate.now();

//		GROUP
		Group group1 = new Group();
		group1.groupID = 1;
		group1.groupName = "Avengers";
		group1.creator = account1;
		group1.createDate = LocalDate.now();

		Group group2 = new Group();
		group2.groupID = 2;
		group2.groupName = "Heroes";
		group2.creator = account2;
		group2.createDate = LocalDate.now();

		Group group3 = new Group();
		group3.groupID = 3;
		group3.groupName = "Arsenal Team";
		group3.creator = account3;
		group3.createDate = LocalDate.now();

		Group[] groupsOfAccount1 = { group1, group2 };
		account1.groups = groupsOfAccount1;

		Group[] groupsOfAccount2 = { group2, group3 };
		account2.groups = groupsOfAccount2;

		Group[] groupsOfAccount3 = { group1, group3 };
		account3.groups = groupsOfAccount3;

		Account[] accountsOfGroup1 = { account1, account2 };
		group1.accounts = accountsOfGroup1;

		Account[] accountsOfGroup2 = { account2, account3 };
		group2.accounts = accountsOfGroup2;

		Account[] accountsOfGroup3 = { account1, account3 };
		group3.accounts = accountsOfGroup3;

//		TYPE QUESTION
		TypeQuestion typeQuestion1 = new TypeQuestion();
		typeQuestion1.typeID = 1;
		typeQuestion1.typeName = TypeName.ESSAY;

		TypeQuestion typeQuestion2 = new TypeQuestion();
		typeQuestion2.typeID = 2;
		typeQuestion2.typeName = TypeName.MULTIPLE_CHOICES;

//		CATEGORY QUESTION
		CategoryQuestion caQuestion1 = new CategoryQuestion();
		caQuestion1.categoryID = 1;
		caQuestion1.categoryName = "Java";

		CategoryQuestion caQuestion2 = new CategoryQuestion();
		caQuestion2.categoryID = 2;
		caQuestion2.categoryName = "PHP";

		CategoryQuestion caQuestion3 = new CategoryQuestion();
		caQuestion3.categoryID = 3;
		caQuestion3.categoryName = "Python";

//		QUESTION
		Question question1 = new Question();
		question1.questionID = 1;
		question1.content = "Câu hỏi về Java";
		question1.category = caQuestion1;
		question1.type = typeQuestion1;
		question1.creator = account1;
		question1.createDate = LocalDate.now();

		Question question2 = new Question();
		question2.questionID = 2;
		question2.content = "Câu hỏi về PHP";
		question2.category = caQuestion1;
		question2.type = typeQuestion2;
		question2.creator = account2;
		question2.createDate = LocalDate.now();

		Question question3 = new Question();
		question3.questionID = 3;
		question3.content = "Câu hỏi về Python";
		question3.category = caQuestion1;
		question3.type = typeQuestion1;
		question3.creator = account3;
		question3.createDate = LocalDate.now();
		

//		ANSWER
		Answer answer1 = new Answer();
		answer1.answerID = 1;
		answer1.content = "Trả lời 01";
		answer1.question = question1;
		answer1.isCorrect = true;

		Answer answer2 = new Answer();
		answer2.answerID = 2;
		answer2.content = "Trả lời 02";
		answer2.question = question2;
		answer2.isCorrect = true;

		Answer answer3 = new Answer();
		answer3.answerID = 3;
		answer3.content = "Trả lời 03";
		answer3.question = question3;
		answer3.isCorrect = false;

//		EXAM
		Exam exam1 = new Exam();
		exam1.examID = 1;
		exam1.code = "A01";
		exam1.title = "Đề thi Java";
		exam1.category = caQuestion1;
		exam1.duration = 60;
		exam1.creator = account1;
		exam1.createDate = LocalDate.now();

		Exam exam2 = new Exam();
		exam2.examID = 2;
		exam2.code = "A02";
		exam2.title = "Đề thi PHP";
		exam2.category = caQuestion2;
		exam2.duration = 45;
		exam2.creator = account2;
		exam2.createDate = LocalDate.now();

		Exam exam3 = new Exam();
		exam3.examID = 3;
		exam3.code = "A03";
		exam3.title = "Đề thi Python";
		exam3.category = caQuestion3;
		exam3.duration = 90;
		exam3.creator = account3;
		exam3.createDate = LocalDate.now();

		Question[] questionsOfExam1 = { question1, question2 };
		exam1.questions = questionsOfExam1;

		Question[] questionsOfExam2 = { question2, question3 };
		exam2.questions = questionsOfExam2;

		Question[] questionsOfExam3 = { question1, question3 };
		exam3.questions = questionsOfExam3;
		
		Exam[] examsOfQuestion1 = {exam1,exam2};
		question1.exams = examsOfQuestion1;
		
		Exam[] examsOfQuestion2 = {exam2,exam3};
		question2.exams = examsOfQuestion2;
		
		Exam[] examsOfQuestion3 = {exam1,exam3};
		question3.exams = examsOfQuestion3;

//		PRINT
//		DEPARTMENT
		System.out.println("Dept ID: " + department1.departmentID);
		System.out.println("Dept Name: " + department1.departmentName);
		System.out.println();

//		POSITION
		System.out.println("Position ID: " + position1.positionID);
		System.out.println("Position Name: " + position2.positionName);
		System.out.println();

//		ACCOUNT
		System.out.println("ID: " + account1.accountID);
		System.out.println("Email: " + account1.email);
		System.out.println("User Name: " + account1.userName);
		System.out.println("Full Name: " + account1.fullName);
		System.out.println("Department ID: " + account1.department.departmentName);
		System.out.println("Position ID: " + account1.position.positionName);
		System.out.println("Create Date: " + account1.createDate);
		System.out.println("List groups of account1 :");
		for (int i = 0; i < account1.groups.length; i++) {
			System.out.println(account1.groups[i].groupName);
		}
		System.out.println();

//		GROUP
		System.out.println("GroupID: " + group1.groupID);
		System.out.println("Group Name: " + group1.groupName);
		System.out.println("Creator ID: " + group1.creator.accountID);
		System.out.println("Create Date" + group1.createDate);
		System.out.println("Accounts Of group 1: ");
		for (int i = 0;i < group1.accounts.length; i++) {
			System.out.println(group1.accounts[i].userName);
		}
		System.out.println();
		

//		TYPE QUESTION
		System.out.println("TypeID: " + typeQuestion1.typeID);
		System.out.println("Type Name: " + typeQuestion1.typeName);
		System.out.println();

//		CATEGORY QUESTION
		System.out.println("CategoryID: " + caQuestion1.categoryID);
		System.out.println("Category Name: " + caQuestion1.categoryName);
		System.out.println();

//		QUESTION
		System.out.println("QuestionID: " + question1.questionID);
		System.out.println("Content: " + question1.content);
		System.out.println("CategoryID: " + question1.category.categoryName);
		System.out.println("Type ID: " + question1.type.typeName);
		System.out.println("Creator ID: " + question1.creator.accountID);
		System.out.println("Create Date: " + question1.createDate);
		System.out.println("Exams of Question 1: ");
		for(int i = 0; i < question1.exams.length ; i++) {
			System.out.println(question1.exams[i].examID);
		}
		System.out.println();

//		ANSWER
		System.out.println("Answer ID: " + answer1.answerID);
		System.out.println("Content: " + answer1.content);
		System.out.println("Question ID: " + answer1.question.questionID);
		System.out.println("Is Correct: " + answer1.isCorrect);
		System.out.println();

//		EXAM
		System.out.println("Exam ID: " + exam1.examID);
		System.out.println("Code: " + exam1.code);
		System.out.println("Title: " + exam1.title);
		System.out.println("Category ID: " + exam1.category.categoryName);
		System.out.println("Duration: " + exam1.duration);
		System.out.println("Creator ID: " + exam1.creator.userName);
		System.out.println("Create Date: " + exam1.createDate);
		System.out.println("List questions of exam 1: ");
		for (int i = 0; i < exam1.questions.length; i++) {
			System.out.println(exam1.questions[i].questionID);
		}
		System.out.println();
	
	}

}
