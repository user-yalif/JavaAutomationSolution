package org.alifanov.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexHelper {
	// returns the first found integer in the string parameter or null if an integer is not found
	public static String getFirstIntegerFromString(String string) {
		Pattern pattern = Pattern.compile("[0-9]+");
		Matcher match = pattern.matcher(string.trim());

		if (match.find())
			return match.group();
		else
			return null;
	}
}