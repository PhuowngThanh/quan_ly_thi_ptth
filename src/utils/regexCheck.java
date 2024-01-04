package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexCheck {
	private static Pattern pattern;
	private static Matcher matcher;
	private static String ngay_sinhRGX = "\\b(0?[1-9]|[12]\\d|3[01])[\\/\\-.](0?[1-9]|[12]\\\\d|3[01])[\\\\/\\\\-.](\\d{2}|\\d{4})\\b";

	public static boolean validateNgay_sinh(String str) {
		pattern = Pattern.compile(ngay_sinhRGX);
		matcher = pattern.matcher(str);
		if (!matcher.find()) {
			return false;
		}
		return true;
	}

}
