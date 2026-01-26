package com.java.interview.coding.question;

import java.util.Scanner;
import java.util.Set;

public class CheckIsVowel {

	// find the string is vowel or not using string return type and using the Regex
	// pattern
	public static String findIsVowel(String s) {

		if (s.isEmpty() || s == null) {
			return "-1";
		}
		if (s.toLowerCase().matches(".*[aeiou].*")) {
			return s;
		} else {
			return "-1";
		}
	}

	// find the string is vowel or not using equalIgnoreCase method
	public static boolean findVowelUsingEqual(String s) {
		if (s == null || s.isEmpty()) {
			return false;
		}
		return s.equalsIgnoreCase("a") || s.equalsIgnoreCase("e") || s.equalsIgnoreCase("i") || s.equalsIgnoreCase("o")
				|| s.equalsIgnoreCase("u");
	}

	// find the string is vowel or not using boolean return type
	public static boolean findVowel8(String s) {
		if (s == null || s.length() != 1) {
			return false; // must be a single character
		}
		char ch = Character.toLowerCase(s.charAt(0));
		return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
	}

	private static final Set<String> VOWELS = Set.of("a", "e", "i", "o", "u");

	public static boolean isVowel11(String s) {
		if (s == null || s.length() != 1) {
			return false;
		}
		return VOWELS.contains(s.toLowerCase());
	}

	public static boolean isVowel17(String s) {
		if (s == null || s.length() != 1) {
			return false;
		}
		return switch (s.toLowerCase()) {
		case "a", "e", "i", "o", "u" -> true;
		default -> false;
		};
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String s = sc.nextLine();

		String ans = findIsVowel(s);
		boolean ans2 = findVowelUsingEqual(s);
		boolean ans3 = findVowel8(s);
		boolean ans4 = isVowel11(s);
		boolean ans5 = isVowel17(s);

		System.out.println("find the string is contain the vowel or not using string return type: " + ans);
		System.out.println("find the string is contain the vowel or not using the equalCase method :" + ans2);
		System.out.println("find the string is contain the vowel or not using java8 : " + ans3);
		System.out.println("find the string is contain the vowel or not using java 11: "+ ans4);
		System.out.println("find the string is contain the vowel or not using java 17:"+ ans5);
	}
}
