package com.java.interview.coding.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayDuplicates {
	
	// this is one more approach using Two pointer (Floyd Cycle detection)
//	public static int duplicateArray(int arr[],int n) {
//		//{1,3,5,4}
//		int slow = arr[0];
//		int fast= arr[0];
//		
//		do {
//			slow=arr[slow];
//			fast=arr[arr[fast]];
//		}while(slow!=fast);
//		
//		slow = arr[0];
//		while(slow!=fast) {
//			slow=arr[slow];
//			fast=arr[fast];
//		}
//		return slow;
//	}
	
	public static int duplicateArray(int arr[],int n) {
		Set<Integer> seen = new HashSet<>();
		
		for(int num : arr) {
			if(seen.contains(num)) {
				return num;
			}
			seen.add(num);
		}
		return -1;
	}
	
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
	
	public static ArrayList<Integer> findArrayDuplicatesUsingJava8(int arr[], int n) {
	    // Convert array to list
	    List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

	    // Build frequency map
	    Map<Integer, Long> mp = list.stream()
	            .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

	    // Collect duplicates
	    return mp.entrySet().stream()
	            .filter(entry -> entry.getValue() > 1)   // only duplicates
	            .map(Map.Entry::getKey)                  // extract the number
	            .collect(Collectors.toCollection(ArrayList::new));
	}

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[]= new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]= sc.nextInt();
		}
		
		int ans = duplicateArray(arr,n);
		ArrayList<Integer> ans1 = findArrayDuplicates(arr,n);
		ArrayList<Integer> ans2 = findArrayDuplicatesUsingJava8(arr,n);
		
		System.out.println("Duplicates of the array using set : "+ans);
		System.out.println("Duplicates of the array are : "+ans1);
		System.out.println("Duplicates of the array using java 8: "+ ans2);
		sc.close();
	}

}
