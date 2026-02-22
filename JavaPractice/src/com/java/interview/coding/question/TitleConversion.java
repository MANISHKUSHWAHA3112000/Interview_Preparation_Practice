package com.java.interview.coding.question;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TitleConversion {
	
	
	public static String findTitleConversion(String s) {
		
		String[] words = s.split(" ");
		StringBuilder result = new StringBuilder();
		
		for(String ans : words ) {
			if(ans.length() > 0) {
				result.append(Character.toUpperCase(ans.charAt(0)))
				.append(ans.substring(1).toLowerCase())
				.append(" ");
			}
		}
		return result.toString().trim();
		
	}
	
	// Using Java 8 
	public static String findTitleConversionUsingJava8(String s) {
		
		String result = Arrays.stream(s.split(" " ))
				.map(word ->  word.substring(0,1).toUpperCase()+word.substring(1).toLowerCase())
				.collect(Collectors.joining(" "));
		return result;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		String ans = findTitleConversion(s);
		String ans2 = findTitleConversionUsingJava8(s);
		
		System.out.println(ans);
		System.out.println(ans2);
		
		sc.close();
	}

}
