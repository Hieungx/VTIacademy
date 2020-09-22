package Day5Ex1Ques4;

public class News implements INews {
	private int iD;
	private String title;
	private String publishDate, author, content;
	private float averageRate;

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public float getAverageRate() {
		return averageRate;
	}

	@Override
	public void display() {
		System.out.println(
				getTitle() + "\n" + getPublishDate() + "\n" + getAuthor() + "\n" + getContent() + "\n" + getAuthor());
	}

	@Override
	public float caculate() {
		int[] rates = new int[3];
		for(int i = 0 ; i < rates.length ; i ++) {
			averageRate = averageRate + i;
		}
		return averageRate/3;
	}

}
