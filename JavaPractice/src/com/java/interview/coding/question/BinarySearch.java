package com.java.interview.coding.question;

import java.util.Scanner;

public class BinarySearch {

	public static int findBinarySearch(int arr[], int n, int k) {
		int start = 0;
		int end = arr.length - 1;
		int result = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == k) {
				result = mid;
				end = mid - 1;
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
		int k = sc.nextInt();

		int ans = findBinarySearch(arr, n, k);

		System.out.println("Sorted array using Binary Search : " + ans);
	}

}
