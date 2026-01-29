package com.coreJava.codingQuestion;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class CodingQuestionPracticeDay3 {
	/**
	Day 3 - Question 1: You are given an array arr of positive integers. 
	Your task is to find all the leaders in the array. 
	An element is considered a leader if it is greater than or equal to all elements to its right. The rightmost element is always a leader.
	**/
	public static ArrayList<Integer> findArrayLeaders(int arr[],int n){
		ArrayList<Integer> result = new ArrayList<>();
		
		int rightMostElement = arr[n-1];
		result.add(rightMostElement);
		
		for(int i=n-2;i>=0;i--) {
			if(arr[i]>rightMostElement) {
				result.add(arr[i]);
				rightMostElement=arr[i];
			}
		}
		Collections.reverse(result);
		return result;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int arr[]= new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
		ArrayList<Integer> ans = findArrayLeaders(arr,n);
		
		System.out.println("Array leaders are : " + ans);
	}

}
