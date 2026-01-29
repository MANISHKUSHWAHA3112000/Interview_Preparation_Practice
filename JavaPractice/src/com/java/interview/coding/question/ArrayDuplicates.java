package com.java.interview.coding.question;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ArrayDuplicates {
	
	public static ArrayList<Integer> findArrayDuplicates(int arr[],int n){
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=0;i<n;i++) {
			int index = Math.abs(arr[i])-1;
			
			if(arr[index] < 0) {
				result.add(index+1);
			}
			else {
				arr[index] = - arr[index];
			}
		}
		Collections.sort(result);
		return result;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[]= new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]= sc.nextInt();
		}
		
		ArrayList<Integer> ans = findArrayDuplicates(arr,n);
		
		System.out.println("Duplicates of the array are : "+ans);
		sc.close();
	}

}
