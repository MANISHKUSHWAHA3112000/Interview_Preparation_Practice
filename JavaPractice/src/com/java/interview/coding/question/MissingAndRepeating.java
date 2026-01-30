package com.java.interview.coding.question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MissingAndRepeating {

	// Find repeating element(s)
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

	// Find missing element(s)
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
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		ArrayList<Integer> ans = findMissingAndRepeating(arr, n);
		System.out.println("Missing and Repeating element are : " + ans);
	}
}
