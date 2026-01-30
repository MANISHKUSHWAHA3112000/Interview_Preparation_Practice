package com.java.interview.coding.question;

import java.util.Scanner;

public class EquilibriumPoint {
	
	public static int findEquilibriumPoint(int arr[],int n) {
		
		int totalSum = 0;
		for(int num : arr) {
			totalSum += num;
		}
		
		int left = 0;
		
		for(int i=0;i<n;i++) {
			int right = totalSum - left - arr[i];
			
			if(left==right) {
				return i;
			}
			left+=arr[i];
		}
		return -1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int arr[]= new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		int ans = findEquilibriumPoint(arr,n);
		
		System.out.println("Equilibrium point is : "+ans);
		sc.close();
	}
}
