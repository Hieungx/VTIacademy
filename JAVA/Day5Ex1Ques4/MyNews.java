package Day5Ex1Ques4;

import java.util.Scanner;

public class MyNews {
	int[] rate = new int[3];
	Scanner scanner = new Scanner(System.in);
	public void insertNew() {
		News news = new News();
		System.out.println("Nhap vao title: ");
		String title = scanner.nextLine();
		news.setTitle(title);
		System.out.println("Da nhap title");
		
		System.out.println("Nhap vao publishDate: ");
		String publishDate = scanner.nextLine();
		news.setPublishDate(publishDate);;
		System.out.println("Da nhap publishDate");
		
		System.out.println("Nhap vao content: ");
		String content = scanner.nextLine();
		news.setContent(content);;
		System.out.println("Da nhap content");
		
		System.out.println("Nhap vao author: ");
		String author = scanner.nextLine();
		news.setAuthor(author);;
		System.out.println("Da nhap author");
		
		System.out.println("Nhap vao 3 danh gia cua ban: ");
		for (int i = 0; i < rate.length; i++) {
			System.out.println("danh gia thu "+ (i+1) + ": ");
			rate[i] = scanner.nextInt();
		}
		
	}

	public void viewListNews() {
		News news = new News();
		news.display();
	}

	public void averageRate() {
		News news = new News();
		for (int i = 0; i < rate.length; i++) {
			
		}
		news.caculate();
	}

	public void exist() {
		
	}
}
