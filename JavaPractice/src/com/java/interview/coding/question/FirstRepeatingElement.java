package com.java.interview.coding.question;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FirstRepeatingElement {
	
	public static int findFirstRepeating(int arr[],int n) {
		
		HashSet<Integer> seen =new HashSet<>();
		
		for(int num : arr) {
			if(seen.contains(num)) {
				return num;
			}
			seen.add(num);
		}
		
		return -1;
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = 7;
		
		int arr[] = {10, 5, 3, 4, 3, 5, 6};
		
		int ans = findFirstRepeating(arr,n);
		
		System.out.println("First Repeating Element based on the preference : "+ ans );
		sc.close();
		
	}

}
