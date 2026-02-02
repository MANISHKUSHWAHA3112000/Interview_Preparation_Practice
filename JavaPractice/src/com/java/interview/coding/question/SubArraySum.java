package com.java.interview.coding.question;

import java.util.ArrayList;
import java.util.Scanner;

public class SubArraySum {
	
	public static ArrayList<Integer>findSubArraySum(int arr[], int n, int target){
		ArrayList<Integer> result = new ArrayList<>();
		
		int sum = 0; int start =0;
		for(int i=0;i<n;i++) {
			sum+=arr[i];
			
			while(sum> target && start <i) {
				sum-=arr[start];
				start++;
				
			}
			if(sum==target) {
				result.add(start+1);
				result.add(i+1);
				return result;
			}
		}
		result.add(-1);
		return result;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt();
		int arr[] = new int [n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		int target = sc.nextInt();
		
		ArrayList<Integer>  ans = findSubArraySum(arr,n,target);
		
		System.out.println("Subarray sum of the array are : "+ ans );
	}

}
