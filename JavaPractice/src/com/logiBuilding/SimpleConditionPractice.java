package com.logiBuilding;

import java.util.Scanner;

public class SimpleConditionPractice {
	
	/**
	// Logic:1 (Tumhara original)
	public static String isNumberValid(int n) {
	    if(n>0) return "Positive";
	    else if(n==0) return "Zero";
	    else return "Negative";
	}

	// Logic:2 (Ternary operator)
	public static String isNumberValid(int n) {
	    return n > 0 ? "Positive" : (n == 0 ? "Zero" : "Negative");
	}

	// Logic:3 (Java 8 Stream)
	public static String isNumberValid(int n) {
	    return java.util.stream.IntStream.of(n)
	            .mapToObj(x -> x > 0 ? "Positive" : (x == 0 ? "Zero" : "Negative"))
	            .findFirst().orElse("Unknown");
	}
	**/

	
	/**
	// Logic:1 (Tumhara original)
	public static boolean isNumberEvenOdd(int n) {
	    return n % 2 == 0;
	}

	// Logic:2 (Bitwise operator)
	public static boolean isNumberEvenOdd(int n) {
	    return (n & 1) == 0;
	}

	// Logic:3 (Java 8 Predicate)
	public static boolean isNumberEvenOdd(int n) {
	    java.util.function.IntPredicate isEven = x -> x % 2 == 0;
	    return isEven.test(n);
	}
	**/

	
	/**
	// Logic:1 (Tumhara original)
	public static boolean isDivisible(int n) {
	    return n % 5 == 0;
	}

	// Logic:2 (Ternary)
	public static boolean isDivisible(int n) {
	    return (n % 5 == 0) ? true : false;
	}

	// Logic:3 (Java 8 Stream)
	public static boolean isDivisible(int n) {
	    return java.util.stream.IntStream.of(n).anyMatch(x -> x % 5 == 0);
	}
	**/

	
	/**
	// Logic:1 (Tumhara original)
	public static String isDivisibleBy5And3(int n) {
	    if(n%3==0) return "Divisible by 3";
	    else if(n%5==0) return "Divisible by 5";
	    else if(n%3==0 || n%5==0) return "Divisible by 3 and 5";
	    else return "Neither divisible by 3 and 5";
	}

	// Logic:2 (Correct order)
	public static String isDivisibleBy5And3(int n) {
	    if(n % 3 == 0 && n % 5 == 0) return "Divisible by 3 and 5";
	    else if(n % 3 == 0) return "Divisible by 3";
	    else if(n % 5 == 0) return "Divisible by 5";
	    else return "Neither divisible by 3 and 5";
	}

	// Logic:3 (Java 8 Stream)
	public static String isDivisibleBy5And3(int n) {
	    return java.util.stream.Stream.of(
	        n % 3 == 0 && n % 5 == 0 ? "Divisible by 3 and 5" :
	        n % 3 == 0 ? "Divisible by 3" :
	        n % 5 == 0 ? "Divisible by 5" :
	        "Neither divisible by 3 and 5"
	    ).findFirst().get();
	}
	**/

	
	/**
	// Logic:1 (Tumhara original)
	public static boolean isLeapYear(int n) {
	    return (n % 4 == 0 && n % 100 != 0) || n % 400 == 0;
	}

	// Logic:2 (Ternary)
	public static boolean isLeapYear(int n) {
	    return ((n % 4 == 0 && n % 100 != 0) || (n % 400 == 0)) ? true : false;
	}

	// Logic:3 (Java 8 Predicate)
	public static boolean isLeapYear(int n) {
	    java.util.function.IntPredicate leapYear = 
	        year -> (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
	    return leapYear.test(n);
	}
	**/

	
	/**
	// Logic:1 (Tumhara original)
	public static int largestBetweenTwo(int n1, int n2) {
	    return n1 > n2 ? n1 : n2;
	}

	// Logic:2 (Math.max)
	public static int largestBetweenTwo(int n1, int n2) {
	    return Math.max(n1, n2);
	}

	// Logic:3 (Java 8 Stream)
	public static int largestBetweenTwo(int n1, int n2) {
	    return java.util.stream.Stream.of(n1, n2).max(Integer::compare).get();
	}
	**/

	/**
	// Logic:1 (Tumhara original)
	public static int largestBetweenThree(int n1, int n2, int n3) {
	    if(n1>n2 && n1>n3) return n1;
	    else if(n2>n1 && n2>n3) return n2;
	    else if(n3>n1 && n3>n2) return n3;
	    return 0;
	}

	// Logic:2 (Math.max)
	public static int largestBetweenThree(int n1, int n2, int n3) {
	    return Math.max(n1, Math.max(n2, n3));
	}

	// Logic:3 (Java 8 Stream)
	public static int largestBetweenThree(int n1, int n2, int n3) {
	    return java.util.stream.Stream.of(n1, n2, n3).max(Integer::compare).get();
	}
	**/

	/**
	// Logic:1 (Tumhara original)
	public static void temperatureRange(int temperature) {
	    if (temperature < 15) System.out.println("Cold");
	    else if (temperature >= 15 && temperature <= 30) System.out.println("Warm");
	    else System.out.println("Hot");
	}

	// Logic:2 (Switch with true)
	public static void temperatureRange(int temperature) {
	    switch(true) {
	        case true: if(temperature < 15) { System.out.println("Cold"); break; }
	        case true: if(temperature <= 30) { System.out.println("Warm"); break; }
	        default: System.out.println("Hot");
	    }
	}

	// Logic:3 (Java 8 Supplier)
	public static void temperatureRange(int temperature) {
	    java.util.function.Supplier<String> result = () -> 
	        temperature < 15 ? "Cold" : (temperature <= 30 ? "Warm" : "Hot");
	    System.out.println(result.get());
	}
	**/

	/**
	// Logic:1 (Tumhara original)
	public static String isVowel(char c) {
	    c = Character.toLowerCase(c);
	    if ("aeiou".indexOf(c) != -1) return "Vowel";
	    else return "It is a consonant";
	}

	// Logic:2 (Set)
	public static String isVowel(char c) {
	    java.util.Set<Character> vowels = java.util.Set.of('a','e','i','o','u');
	    return vowels.contains(Character.toLowerCase(c)) ? "Vowel" : "It is a consonant";
	}

	// Logic:3 (Java 8 Stream)
	public static String isVowel(char c) {
	    return java.util.stream.Stream.of('a','e','i','o','u')
	            .anyMatch(v -> v == Character.toLowerCase(c)) ? "Vowel" : "It is a consonant";
	}
	**/

	/**
	// Logic:1 (Tumhara original)
	public static void checkCharacter(char ch) {
	    if (Character.isUpperCase(ch)) System.out.println("Uppercase letter");
	    else if (Character.isLowerCase(ch)) System.out.println("Lowercase letter");
	    else if (Character.isDigit(ch)) System.out.println("Digit");
	    else System.out.println("Special character");
	}

	// Logic:2 (Switch with Character type)
	public static void checkCharacter(char ch) {
	    switch(Character.getType(ch)) {
	        case Character.UPPERCASE_LETTER: 
	            System.out.println("Uppercase letter"); 
	            break;
	        case Character.LOWERCASE_LETTER: 
	            System.out.println("Lowercase letter"); 
	            break;
	        case Character.DECIMAL_DIGIT_NUMBER: 
	            System.out.println("Digit"); 
	            break;
	        default: 
	            System.out.println("Special character");
	    }
	}

	// Logic:3 (Java 8 Predicate + Lambda)
	public static void checkCharacter(char ch) {
	    java.util.function.Predicate<Character> isUpper = Character::isUpperCase;
	    java.util.function.Predicate<Character> isLower = Character::isLowerCase;
	    java.util.function.Predicate<Character> isDigit = Character::isDigit;

	    if(isUpper.test(ch)) System.out.println("Uppercase letter");
	    else if(isLower.test(ch)) System.out.println("Lowercase letter");
	    else if(isDigit.test(ch)) System.out.println("Digit");
	    else System.out.println("Special character");
	}
	**/

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		int n = sc.nextInt();
//		int n1 = sc.nextInt();
//		int n2=sc.nextInt();
//		int n3 = sc.nextInt();
		char c = sc.next().charAt(0);
		
//		String ans = isNumberValid(n);
//		boolean ans2 =isNumberEvenOdd(n);
//		boolean ans3=isDivisible(n);
//		String ans4 = isDivisibleBy5And3(n);
//		boolean ans5 = isLeapYear(n);
//		int ans6=largestBetweenTwo(n1,n2);
//		int ans7 = largestBetweenThree(n1,n2,n3);
//		temperatureRange(n);
//		int ans8=isVowel(c);
//		checkCharacter(c);
		
	
//		System.out.println(ans);
//		System.out.println(ans2);
//		System.out.println(ans3);
//		System.out.println(ans4);
//		System.out.println(ans5);
//		System.out.println(ans6);
//		System.out.println(ans7);
//		System.out.println(ans8);
	}

}
