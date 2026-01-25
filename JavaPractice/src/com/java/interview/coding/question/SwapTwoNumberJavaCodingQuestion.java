package com.java.interview.coding.question;

import java.util.Scanner;

public class SwapTwoNumberJavaCodingQuestion {

	// swap two number without third variable
	public static void swapTwoNumber(int a, int b) {

		a = b + a;
		b = a - b;
		a = a - b;

		System.out.println("Swap two number without using the third variable: " + a + " " + b);
	}

	// swap two number without third variable using array
	public static int[] swapTwoNumberUsingArray(int a, int b) {

		a = b + a;
		b = a - b;
		a = a - b;

		return new int[] { a, b };

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		swapTwoNumber(a, b);

		int[] ans = swapTwoNumberUsingArray(a, b);

		System.out.println(ans[0] + " " + ans[1]);

	}

}
