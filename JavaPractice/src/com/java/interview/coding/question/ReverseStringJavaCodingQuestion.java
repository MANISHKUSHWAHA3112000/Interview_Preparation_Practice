package com.java.interview.coding.question;

import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Q. Reverse a String (core java,java 8,java 11,java 17)
 **/

public class ReverseStringJavaCodingQuestion {

	// Using Loop
	public static String reverseString(String s) {

		String res = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			res += s.charAt(i);
		}
		return res;
	}

	// using inbuilt StringBuilder class
	public static String reverseStringUsingInBuilt(String s) {
		String str = new StringBuilder(s).reverse().toString();
		return str;
	}

	// using java 8
	public static String reverseStringUsingJava8(String s) {
		String reversed = IntStream.rangeClosed(1, s.length()).mapToObj(i -> s.charAt(s.length() - i))
				.map(String::valueOf).collect(Collectors.joining());

		return reversed;
	}

	// Using Java 11
	public static String reverseStringUsingJava11(String s) {
		String reversed = s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
					Collections.reverse(list);
					return list.stream().map(String::valueOf).collect(Collectors.joining());
				}));
		return reversed;
	}

	// Using Java 17
	public static String reverseStringUsingJava17(String s) {
		String reversed = s.codePoints().mapToObj(c -> String.valueOf((char) c))
				.collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
					java.util.Collections.reverse(list);
					return String.join("", list);
				}));
		return reversed;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();

		String ans = reverseString(s);
		String ans2 = reverseStringUsingInBuilt(s);
		String ans3 = reverseStringUsingJava8(s);
		String ans4 = reverseStringUsingJava11(s);
		String ans5 = reverseStringUsingJava17(s);

		System.out.println("String using loop: " + ans);
		System.out.println("String using inBuiltFunction: " + ans2);
		System.out.println("String using java8: " + ans3);
		System.out.println("String using java11: " + ans4);
		System.out.println("String using java17: " + ans5);
		sc.close();
	}

}
