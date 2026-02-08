package com.java.interview.coding.question;

import java.util.HashMap;
import java.util.Scanner;

public class SubArraySumZero {
	
	
	// largest subarray sum with sum equal  0 (find the length)
	public static int findSubArraySumZero(int arr[],int n) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int prefixSum = 0; int maxLength = 0;
		for (int i = 0; i < n; i++) { prefixSum += arr[i]; 
		// Case 1: If prefixSum itself is 0, subarray from 0 to i has sum 0 
		if (prefixSum == 0) { maxLength = i + 1; } 
		// Case 2: If prefixSum seen before, subarray between indices has sum 0
		if (map.containsKey(prefixSum)) { maxLength = Math.max(maxLength, i - map.get(prefixSum)); } else { 
			// Store first occurrence of prefixSum 
			map.put(prefixSum, i); } } 
		return maxLength;
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]= sc.nextInt();
		}
		
		int ans = findSubArraySumZero(arr,n);
		
		System.out.println("Sub array sum is zero : "+ ans);
		sc.close();
	}

}
