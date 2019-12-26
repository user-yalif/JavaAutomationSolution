package org.alifanov.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexHelper {
	
	private static Pattern pattern = null;
	private static Matcher matcher = null;
	
	/**
	 * Method returns the first found integer in the string parameter or null if an integer is not found
	 * @param String an integer to be found
	 * @return First integer occurrence in string parameter or null 
	 */
	public static String getFirstIntegerFromString(String string) {
		pattern = Pattern.compile("[0-9]+");
		matcher = pattern.matcher(string.trim());

		if (matcher.find())
			return matcher.group();
		else
			return null;
	}
	
	/**
	 * Method returns the first separated integer from string (e.g. 100 000)
	 * @param String an integer to be found
	 * @return Separated integer or null
	 */
	public static String getSeparatedIntegerFromString(String string) {
		pattern = Pattern.compile("[0-9]+\\s[0-9]+");
		matcher = pattern.matcher(string.trim());

		if (matcher.find())
			return matcher.group();
		else
			return null;
	}
}
