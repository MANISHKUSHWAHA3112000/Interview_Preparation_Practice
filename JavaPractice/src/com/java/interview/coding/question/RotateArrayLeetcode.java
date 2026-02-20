package com.java.interview.coding.question;

import java.util.Scanner;

public class RotateArrayLeetcode {
	public static void reverseArray(int arr[],int left,int right) {
		while(left<right) {
			int temp=arr[left];
			arr[left]=arr[right];
			arr[right]=temp;
			left++;right--;
		}
	}
	public static void rotate(int arr[],int n,int k) {
		reverseArray(arr,0,n-1);
		reverseArray(arr,0,k-1);
		reverseArray(arr,k,n-1);
	}
	public static void main(String[] args) {
		
		int n= 7;
		
		int arr[]= {1,2,3,4,5,6,7};
		int k=3;
		
		rotate(arr,n,k);
		for(int i=0;i<n;i++) {
		System.out.print(arr[i] + " ");
		}

	}

}
