package com.java.interview.coding.question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayLeaders {
	
	public static ArrayList<Integer> findArrayLeaders(int arr[],int n){
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int rightMostElement = arr[arr.length-1];
		ans.add(rightMostElement);
		
		for(int i=n-2;i>=0;i--) {
			if(arr[i]>=rightMostElement) {
				ans.add(arr[i]);
				rightMostElement=arr[i];
			}
		}
		Collections.reverse(ans);
		return ans;
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int arr[] = new int [n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		ArrayList<Integer> ans = findArrayLeaders(arr,n);
		System.out.println(ans);
	}

}
