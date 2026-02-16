package com.java.interview.coding.question;

import java.util.Scanner;

public class MinimumJumps {

	public static int findMinimumJumps(int arr[], int n) {
		int jumps = 0;
		int currentJumps = 0;
		int longest = 0;

		if (arr[0] == 0) {
			return -1;
		}
		if (n <= 1) {
			return 0;
		}

		for (int i = 0; i < n-1; i++) {
			longest = Math.max(longest, i + arr[i]);
			
			if(longest==i)return -1;

			if (i == currentJumps) {
				jumps++;
				currentJumps = longest;

				if (currentJumps >= n-1)
					return jumps;
			}
		}
		return -1;

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int ans = findMinimumJumps(arr, n);

		System.out.println("Minimum Jumps required to read the end : " + ans);

		sc.close();
	}

}
