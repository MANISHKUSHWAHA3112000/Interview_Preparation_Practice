package com.java.interview.coding.question;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class KSizedSubarrayMaximum {

	public static ArrayList<Integer> maxOfSubarrays(int arr[], int n, int k) {
		ArrayList<Integer> res = new ArrayList<>(); 
		Deque<Integer> dq = new LinkedList<>(); 
		for (int i = 0; i < n; i++) { 
			while (!dq.isEmpty() && dq.peekFirst() <= i - k) { dq.pollFirst(); 
			}  
			while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) { dq.pollLast(); } dq.offerLast(i);
			if (i >= k - 1) { res.add(arr[dq.peekFirst()]); } 
			} 
		return res;
		}


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int k = sc.nextInt();

		ArrayList<Integer> ans = maxOfSubarrays(arr, n, k);

		System.out.println("K sized Subarray Maximum :" + ans);
	}
}
