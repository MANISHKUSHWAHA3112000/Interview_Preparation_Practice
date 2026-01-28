package com.java.interview.coding.question;

import java.util.Scanner;

public class SecondLargestElement {

	public static int secondLargestElement(int arr[], int n) {
		if (n < 2)
			return -1;

		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;

		for (int num : arr) {
			if (num > largest) {
				secondLargest = largest;
				largest = num;
			} else if (num > secondLargest && num != largest) {
				secondLargest = num;
			}
		}
		return (secondLargest == Integer.MIN_VALUE ? -1 : secondLargest);

	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}

		int ans = secondLargestElement(arr, n);

		System.out.println("Second largest element is : " + ans);
		scanner.close();
	}
	

}
