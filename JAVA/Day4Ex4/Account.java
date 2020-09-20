package Day4Ex4;

public class Account {
	private String id;
	private String name;
	private int balance;

	public Account(String id, String name, int balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	};

	public void credit(int amount) {
		System.out.println();
	};
	
	public void debit(int amount) {
		System.out.println();
	}
	public void tranferTo(Account account,int amount ) {
		System.out.println();
	}
}

