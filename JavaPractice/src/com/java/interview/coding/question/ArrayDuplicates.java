package com.java.interview.coding.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

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
		
		ArrayList<Integer> ans = findArrayDuplicates(arr,n);
		ArrayList<Integer> ans1 = findArrayDuplicatesUsingJava8(arr,n);
		
		System.out.println("Duplicates of the array are : "+ans);
		System.out.println("Duplicates of the array using java 8: "+ ans1);
		sc.close();
	}

}
