package com.coreJava.codingQuestion;

import java.util.Scanner;

public class Day1_Two_Pointer_Question {
	
	public static int chocolates(int arr[],int n) {
		// First we solve the basic and greedy choice bases question
		
		int min = arr[0];
		
		for(int i=0;i<n;i++) {
			if(arr[i]<min) {
				min=arr[i];
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		
		/**
		Question 1 : (Ishan Loves Chocolates(GFG))
		- As we know, Ishaan has a love for chocolates. He has bought a huge chocolate bar that contains N chocolate squares. 
		Each of the squares has a tastiness level which is denoted by an array A[].
		Ishaan can eat the first or the last square of the chocolate at once. 
		Ishaan has a sister who loves chocolates too and she demands the last chocolate square. 
		Now, Ishaan being greedy eats the more tasty square first. 
		Determine the tastiness level of the square which his sister gets
		**/
		 Scanner sc = new Scanner(System.in);
		 
		 /**
		  * sample input
		  * 4
            5
            3 1 6 9
            4
            5 9 2 6
            4
            4 4 4 4
            5
            1 2 3 4 5

		  * **/
		 
		// Number of test cases
	        int T = sc.nextInt();

	        for (int t = 1; t <= T; t++) {
	            int n = sc.nextInt();
	            int[] arr = new int[n];
	            for (int i = 0; i < n; i++) {
	                arr[i] = sc.nextInt();
	            }

	            // Print which test case is running
	            System.out.print("Test Case #" + t + ": ");

	            // Print the result
	            int ans = chocolates(arr,n);
	            System.out.println(ans);
	        }

	        sc.close();
		
	}

}
