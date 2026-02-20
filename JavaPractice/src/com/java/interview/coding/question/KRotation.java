package com.java.interview.coding.question;

import java.util.Scanner;

public class KRotation {

	public static int findKRoation(int arr[], int n) {
		int minElement = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < n; i++) {
			if(arr[i]<minElement) {
				minElement=arr[i];
				index=i;
			}
		}
		return index;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int ans = findKRoation(arr, n);

		System.out.println("K Rotation : " + ans);
		sc.close();
	}

}
