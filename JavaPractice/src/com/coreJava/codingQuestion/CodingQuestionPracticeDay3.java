package com.coreJava.codingQuestion;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class CodingQuestionPracticeDay3 {
	/**
	 * Day 3 - Question 1: You are given an array arr of positive integers. Your
	 * task is to find all the leaders in the array. An element is considered a
	 * leader if it is greater than or equal to all elements to its right. The
	 * rightmost element is always a leader.
	 **/
	public static ArrayList<Integer> findArrayLeaders(int arr[], int n) {
		ArrayList<Integer> result = new ArrayList<>();

		int rightMostElement = arr[n - 1];
		result.add(rightMostElement);

		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] > rightMostElement) {
				result.add(arr[i]);
				rightMostElement = arr[i];
			}
		}
		Collections.reverse(result);
		return result;
	}

	/**
	 * Day 3 - Question 2:Given an array arr[] of size n, containing elements from
	 * the range 1 to n, and each element appears at most twice, return an array of
	 * all the integers that appears twice.
	 */
	public static ArrayList<Integer> findArrayDuplicates(int arr[], int n) {

		ArrayList<Integer> res = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int index = Math.abs(arr[i]) - 1;

			if (arr[index] < 0) {
				res.add(index + 1);
			} else {
				arr[index] = -arr[index];
			}
		}
		Collections.sort(res);
		return res;
	}
	/**
	 * Day 3 - Question 3: Given a sorted array arr[] and an integer k, find the position(0-based indexing) at 
	 * which k is present in the array using binary search. If k doesn't exist in arr[] return -1. 
	 * Note: If multiple occurrences are there, please return the smallest index.
	 */
	public static int findKElement(int arr[], int n, int k) {
		int start = 0, end = n - 1, result = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == k) {
				result = mid;
				mid = end - 1;
			} else if (arr[mid] > k) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return result;
	}
	

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		ArrayList<Integer> ans = findArrayLeaders(arr, n);

		System.out.println("Array leaders are : " + ans);

		ArrayList<Integer> ans2 = findArrayDuplicates(arr, n);

		System.out.println("Duplicates array are : " + ans2);

		int k = sc.nextInt();

		int ans3 = findKElement(arr, n, k);

		System.out.println("k element using binary search : " + ans3);

		sc.close();
	}

}
