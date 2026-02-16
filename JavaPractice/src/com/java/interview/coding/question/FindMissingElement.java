package com.java.interview.coding.question;

import java.util.Arrays;
import java.util.Scanner;

public class FindMissingElement {

	public static int findMissing(int arr[], int n) {

		// first method to iterated with the help of xor (^) operator
//		int sum1 = 0;
//		int sum2 = 0;
//
//		for (int i = 0; i < n - 1; i++) {
//			sum1 ^= arr[i];
//		}
//
//		for (int i = 1; i <= n; i++) {
//			sum2 ^= i;
//		}
//		return sum1 ^ sum2;

//		 second method using the sum of n natural number method

//	     n = arr.length + 1;   // total numbers should be n
//        long totalSum = (long) n * (n + 1) / 2;  // sum of 1..n
//        long arrSum = 0;
//
//        for (int num : arr) {
//            arrSum += num;  // accumulate into long
//        }
//
//        return (int) (totalSum - arrSum);
		
		 Arrays.sort(arr);

		  n = arr.length;
	        int sum1=0;
	        int sum2=0;
	        
	        for(int i=0;i<n;i++){
	            sum1^=arr[i];
	        }
	        
	        for(int i=1;i<=n+1;i++){
	            sum2^=i;
	        }
	        
	        
	        return sum1^sum2;
	    
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int ans = findMissing(arr, n);

		System.out.println(ans);
		sc.close();

	}

}
