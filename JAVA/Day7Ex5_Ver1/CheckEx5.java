package Day7Ex5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CheckEx5 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		File file = new File("F:\\StudentInformation.txt");
		try {
			fis = new FileInputStream(file);
			int i;
			while ((i = fis.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
