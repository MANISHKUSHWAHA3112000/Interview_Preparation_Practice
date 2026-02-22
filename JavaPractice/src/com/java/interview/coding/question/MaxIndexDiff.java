package com.java.interview.coding.question;

import java.util.Scanner;

public class MaxIndexDiff {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int arr[]=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
//		int ans = findMaxIndexDiff(arr,n);
		
//		System.out.println("Max Index difference are : "+ ans);
		sc.close();
	}

}
