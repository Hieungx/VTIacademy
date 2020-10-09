package utils;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

public class ScannerUtils {

	private static Scanner scanner = new Scanner(System.in);

	public static int inputInt(String errorMessage) {
		while (true) {
			try {
				int number = Integer.parseInt(scanner.nextLine().trim()); // trim để xóa khoảng trắng

				if (number >= 0) {
					return number;
				} else
					System.err.println(errorMessage);

			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static float inputFloat(String errorMessage) {
		while (true) {
			try {
				float number = Float.parseFloat(scanner.nextLine().trim());
				return number;

			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static double inputDouble(String errorMessage) {
		while (true) {
			try {
				return Double.parseDouble(scanner.nextLine().trim());
			} catch (Exception e) {
				System.err.println(errorMessage);
			}
		}
	}

	public static String inputString(String errorMessage) {
		while (true) {
			String str = scanner.nextLine().trim();
			if (!str.isEmpty()) {
				return str;
			} else {
				System.err.println(errorMessage);
			}
		}
	}

	public static LocalDate inputLocalDate() {
		while (true) {
			String date = "";
			LocalDate localDate = null;
			DateTimeFormatter formatter = null;
			try {
				date = ScannerUtils.inputString("ChÆ°a nháº­p ngÃ y. Vui lÃ²ng nháº­p láº¡i!");
				formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				localDate = LocalDate.parse(date, formatter);
				return localDate;
			} catch (DateTimeParseException e) {
				System.err.println("Vui lÃ²ng nháº­p ngÃ y theo format dd-MM-yyyy!");
			}
		}
	}

	public static LocalDateTime inputLocalDateTime() {
		while (true) {
			String date = "";
			LocalDateTime localDate = null;
			DateTimeFormatter formatter = null;
			try {
				date = ScannerUtils.inputString("ChÆ°a nháº­p ngÃ y. Vui lÃ²ng nháº­p láº¡i!");
				formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
				localDate = LocalDateTime.parse(date, formatter);
				return localDate;
			} catch (DateTimeParseException e) {
				System.err.println("Vui lÃ²ng nháº­p ngÃ y theo Ä‘á»‹nh dáº¡ng dd-MM-yyyy HH:mm:ss!");
			}
		}
	}

	public static String convertLocalDateTimeToString(LocalDateTime date) {

		String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		return formattedDate;
	}

	public static LocalDate convertStringToLocalDate(String dateStr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate localDate = LocalDate.parse(dateStr, formatter);
		return localDate;
	}

	public static String convertLocalDateToString(LocalDate date) {

		String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		return formattedDate;
	}

	public static String convertDoubleToMoneyVND(double total) {
		Locale localeVN = new Locale("vi", "VN");
		NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		String str = currencyVN.format(total);

		return str;
	}
}
