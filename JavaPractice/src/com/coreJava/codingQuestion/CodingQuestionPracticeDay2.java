package com.coreJava.codingQuestion;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CodingQuestionPracticeDay2 {
	
	// Day 2 : Even occuring elements
	public static int findEvenOccurrences(int arr[]){
		
		List<Integer> result = new ArrayList<>();
		int count=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==arr[i-1]) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		
		// Day 2 : Question 1
		int arr[]= new int[n];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		
//		List<Integer> ans = findEvenOccurrences(arr);
		int ans1= findEvenOccurrences(arr);
		
		System.out.println(ans1);
		
//		for(int num : ans) {
//			System.out.println(num + " ");
//		}
		
	}

}
