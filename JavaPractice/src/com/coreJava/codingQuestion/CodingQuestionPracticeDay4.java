package com.coreJava.codingQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CodingQuestionPracticeDay4 {

	/**
	 * Day 4 - Question 1: Given an array of integers arr[], the task is to find the
	 * first equilibrium point in the array. The equilibrium point in an array is an
	 * index (0-based indexing) such that the sum of all elements before that index
	 * is the same as the sum of elements after it. Return -1 if no such point
	 * exists.
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

	/**
	 * Given an unsorted array arr[] of size n, containing elements from the range 1
	 * to n, it is known that one number in this range is missing, and another
	 * number occurs twice in the array, find both the duplicate number and the
	 * missing number.
	 */

	public static ArrayList<Integer> findArrayDuplicates(int arr[], int n) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int index = Math.abs(arr[i]) - 1;

			if (arr[index] < 0) {
				result.add(index + 1);
			} else {
				arr[index] = -arr[index];
			}
		}
		Collections.sort(result);
		return result;
	}

	public static ArrayList<Integer> findMissing(int arr[], int n) {
		ArrayList<Integer> res = new ArrayList<>();
		boolean[] present = new boolean[n + 1];

		for (int num : arr) {
			if (num >= 1 && num <= n) {
				present[num] = true;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (!present[i]) {
				res.add(i);
			}
		}
		return res;
	}

	// Combine missing + repeating
	public static ArrayList<Integer> findMissingAndRepeating(int arr[], int n) {
		ArrayList<Integer> result = new ArrayList<>();
		result.addAll(findMissing(arr, n));
		result.addAll(findArrayDuplicates(arr, n));
		return result;
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

		ArrayList<Integer> ans2 = findMissingAndRepeating(arr, n);
		System.out.println("Missing and Repeating element are : " + ans2);

		sc.close();
	}
}
