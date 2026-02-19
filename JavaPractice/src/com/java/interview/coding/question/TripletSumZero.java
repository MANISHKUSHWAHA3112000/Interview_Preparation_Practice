package com.java.interview.coding.question;

import java.util.Arrays;
import java.util.Scanner;

public class TripletSumZero {
	
	public static boolean findTripletSumZero(int arr[],int n) {
		
		Arrays.sort(arr);

		for (int i = 0; i < n-2; i++) {
		    int left = i+1, right = n-1;
		    while (left < right) {
		        int sum = arr[i] + arr[left] + arr[right];
		        if (sum == 0) {
		            return true;
		        } else if (sum < 0) {
		            left++;
		        } else {
		            right--;
		        }
		    }
		}
		return false;

	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n=sc.nextInt();
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		boolean ans = findTripletSumZero(arr,n);
		
		System.out.println("Triplet sum is zero: "+ ans);
		sc.close();
	}

}
