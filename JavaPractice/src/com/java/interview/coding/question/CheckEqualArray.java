package com.java.interview.coding.question;

import java.util.Scanner;

public class CheckEqualArray {
	
	public static boolean isCheckEqual(int arr1[],int arr2[],int n) {
		
	
		int sum1 =0,sum2=0;
		for(int i=0;i<n;i++) {
			sum1+=arr1[i];
		}
		for(int i=0;i<n;i++) {
			sum2+=arr2[i];
		}
		if(sum1==sum2) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr1[]= new int[n];
		int arr2[]=new int[n];
		
		for(int i=0;i<n;i++) {
			arr1[i]=sc.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			arr2[i]=sc.nextInt();
		}
		
		boolean ans = isCheckEqual(arr1,arr2,n);
		
		System.out.println("The two array are equal or not :"+ans);
		
		
	}
}
