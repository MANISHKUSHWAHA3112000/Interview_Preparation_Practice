package com.coreJava.codingQuestion;

import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CodingQuestionPracticeDay1 {
	
	// Day 1 : Print Elements of Array (GFG)
//	public static void printArray(int[] arr) {
//		
//		for(int i=0;i<arr.length;i++)
//		System.out.print(arr[i]+ " ");
//	}
	
	// Day 1 : Remove Duplicates from unsorted array
//	public static ArrayList<Integer>removeDuplicate(int arr[]){
		// O(N) - Time complexity
		Set<Integer> set = new HashSet<>();
//		ArrayList<Integer> ans = new ArrayList<>();
//		
//		for(int i=0;i<arr.length;i++) {
//			if(set.add(arr[i])) {
//				ans.add(arr[i]);
//			}
//		}
//		return ans;
		
		// O(N * logN) - Time complexity
//		ArrayList<Integer>res2 = new ArrayList<>();
//		 Arrays.sort(arr);
//		 
//		 for(int i=0;i<arr.length;i++) {
//			 if(i==0 || arr[i]!=arr[i-1]) {
//				 res2.add(arr[i]);
//			 }
//		 }
//		 return res2;
		
		// O(N*N) - Time complexity
//		ArrayList<Integer>res3= new ArrayList<>();
//		for(int i=0;i<arr.length;i++) {
//			int j;
//			for(int j=0;j<i;j++) {
//				if(arr[i]==arr[j]) 
//					break;
//				if(i==j)
//					res3.add(arr[i]);
//			}
//		}
//		return res3;
//	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		// Day 1 : Question 1
		
//		int arr[]= new int[n];
//		
//		for(int i=0;i<arr.length;i++) {
//			arr[i]=sc.nextInt();
//		}
//		
//		 printArray(arr);
		
		// Day 1 : Question 2
//		int arr[] = new int [n];
//		
//		for(int i=0;i<arr.length;i++) {
//			arr[i]=sc.nextInt();
//		}
//		
//		ArrayList<Integer> ans = removeDuplicate(arr);
//		
//		for(int i=0;i<ans.size();i++) {
//			System.out.print(ans.get(i) + " ");
//		}
		
		
		sc.close();
		
	}

	

}
