package Day3;

public class Person {
	String name;

	public void CaplocksName(String name) {
		String s1 = name.substring(0, 1).toUpperCase();
		this.name = s1 + name.substring(1);
		System.out.println(this.name);
	}

	public void PrintChar(String name) {
		for (int i = 0; i < name.length(); i++) {
			System.out.println(name.substring(i, i + 1));
		}
	}

	public void RevertByWord(String name) {
		String[] splits = name.split(" ");
//		for(String item : splits) {
//			System.out.println(item);
//		}
		for (int i = splits.length-1; i >= 0; i--) {
			System.out.print(splits[i] + " ");
		}
	}
}
