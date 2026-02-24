package com.java.interview.coding.question;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelConvertIntoUpper {

	// 1. Classic Loop (Your Method)
	public static String findVowelConvertIntoUpper(String s) {
		StringBuilder str = new StringBuilder();

		for (char c : s.toCharArray()) {
			if (".*[aeiou]*.".indexOf(Character.toLowerCase(c)) != -1) {
				str.append(Character.toUpperCase(c));
			} else {
				str.append(c);
			}
		}
		return str.toString();
	}

	// 2. Java 8 – Streams API
	public static String convertUsingStreams(String s) {
		return s.chars().mapToObj(code -> {
			char ch = (char) code;
			if ("aeiou".indexOf(Character.toLowerCase(ch)) != -1) {
				return String.valueOf(Character.toUpperCase(ch));
			} else {
				return String.valueOf(ch);
			}
		}).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
	}

	// 3. Java 11 – Using Pattern + Matcher (correct approach)
	public static String convertUsingJava11(String s) {
		Pattern p = Pattern.compile("[aeiouAEIOU]");
		Matcher m = p.matcher(s);

		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, m.group().toUpperCase());
		}
		m.appendTail(sb);

		return sb.toString();
	}

	// 4. Java 17 – Pattern + Matcher (same logic, still valid)
	public static String convertUsingJava17(String s) {
		Pattern p = Pattern.compile("[aeiouAEIOU]");
		Matcher m = p.matcher(s);

		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, m.group().toUpperCase());
		}
		m.appendTail(sb);

		return sb.toString();
	}

	public static String convertUsingRegex(String s) {

		String ans = " ";

		if (s == null || s.isEmpty()) {
			return "-1";
		}

		for (char c : s.toCharArray()) {
			if ("aeiou".indexOf(Character.toLowerCase(c)) != -1) {
				ans += Character.toUpperCase(c);
			} else {
				ans += c;
			}
		}
		return ans;
	}

	// MAIN METHOD
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		System.out.println("Classic Loop: " + findVowelConvertIntoUpper(s));
		System.out.println("Java 8 Streams: " + convertUsingStreams(s));
		System.out.println("Java 11 Pattern/Matcher: " + convertUsingJava11(s));
		System.out.println("Java 17 Pattern/Matcher: " + convertUsingJava17(s));
		System.out.println("Regex Shortest: " + convertUsingRegex(s));
	}
}
