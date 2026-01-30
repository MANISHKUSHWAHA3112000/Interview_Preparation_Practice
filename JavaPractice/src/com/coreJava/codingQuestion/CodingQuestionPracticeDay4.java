package com.coreJava.codingQuestion;

import java.util.Scanner;

public class CodingQuestionPracticeDay4 {

	/**
	 * Day 4 - Question 1: Given an array of integers arr[], 
	 * the task is to find the first equilibrium point in the array.
	 * The equilibrium point in an array is an index (0-based indexing) such that the sum of all elements 
	 * before that index is the same as the sum of elements after it. Return -1 if no such point exists. 
	 */
	public int findEquilibriumPoint(int arr[], int n) {

		int totalSum = 0;

		for (int num : arr) {
			totalSum += num;
		}

		int left = 0;

		for (int i = 0; i < n; i++) {
			int right = totalSum - left - arr[i];

			if (left == right) {
				return i;
			}
			left += arr[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		
		CodingQuestionPracticeDay4 sol = new CodingQuestionPracticeDay4();
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int ans = sol.findEquilibriumPoint(arr, n);

		System.out.println("Equilibrium point is : " + ans);
		
		sc.close();
	}
}
