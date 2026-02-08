package com.java.interview.coding.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KadaneAlgorithm {
	
	public static int findKadaneAlgorithmWithSum(int arr[],int n,int k) {
		Map<Integer, Integer> prefixMap = new HashMap<>();
		int sum = 0, maxLen = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum == k) {
				maxLen = i + 1;
			}
			if (prefixMap.containsKey(sum - k)) {
				maxLen = Math.max(maxLen, i - prefixMap.get(sum - k));
			} // store first occurrence of sum
			if (!prefixMap.containsKey(sum)) {
				prefixMap.put(sum, i);
			}
		}

	return maxLen;

	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int n=sc.nextInt();
		
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		int k =sc.nextInt();
		
		int ans = findKadaneAlgorithmWithSum(arr,n,k);
		
		System.out.println("Kadane Algorithm is : "+ ans );
	}

}
