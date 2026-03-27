package com.coreJava.codingQuestion;

import java.util.Arrays;
import java.util.Scanner;

public class Day1_Two_Pointer_Question {
	/**
	Question 1 : (Ishan Loves Chocolates(GFG))
	- As we know, Ishaan has a love for chocolates. He has bought a huge chocolate bar that contains N chocolate squares. 
	Each of the squares has a tastiness level which is denoted by an array A[].
	Ishaan can eat the first or the last square of the chocolate at once. 
	Ishaan has a sister who loves chocolates too and she demands the last chocolate square. 
	Now, Ishaan being greedy eats the more tasty square first. 
	Determine the tastiness level of the square which his sister gets
	
	Sample Input :
	/**
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
	public static int chocolates(int arr[],int n) {
		// First we solve the basic and greedy choice bases question
		
		/*
		int min = arr[0];
		
		for(int i=0;i<n;i++) {
			if(arr[i]<min) {
				min=arr[i];
			}
		}
		return min;
		*/
		
		// My solution using two pointer approach
		Arrays.sort(arr); // because two pointer approach only work in sorted array
		int ans = arr[0];
		
		int left=0;int right=arr.length-1;
		
		for(int i=0;i<n;i++) {
			if(arr[i]>ans) {
				left++;
			}
			else if(arr[i]==ans) {
				return arr[i];
			}
			else {
				right--;
			}
		}
		return ans;
	}
	
	/**
	 * Question 2 : (Sort the Half sorted)
	 * Given an integer array of which both the first halve and second halve are
	 * sorted. The task is to merge these two sorted halves of the array into a
	 * single sorted array. Note: The two halves can be of arbitrary sizes (i.e. if
	 * first halve of size k then the second halve is of size N-k where 0<=k<=N).
	 * 
	 * Example 1:

Input:
N = 6
arr[] = {2 3 8 -1 7 10}
Output: -1 2 3 7 8 10 
Explanation: {2 3 8} and {-1 7 10} are sorted 
in the original array. The overall sorted 
version is {-1 2 3 7 8 10}
Example 2:

Input:
N = 5
arr[] = {-4 6 9 -1 3}
Output: -4 -1 3 6 9 
Explanation: {-4 -1} and {3 6 9} are sorted 
in the original array. The overall sorted 
version is {-4 -1 3 6 9}
	 */
	
	public static void swap(int arr[],int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	public static void sortedHalves(int arr[],int n) {
		//Arrays.sort(arr);  // ye ek solution hai magar time complexity nlogn hai 
		
		// My solution this is brute force and its time complexity is o(n*n) --selection sort
//		int left=0;int right=arr.length-1;
//		for(int i=0;i<arr.length;i++) {
//			for(int j=i+1;j<arr.length;j++) {
//				if(arr[i]>arr[j])swap(arr,i,j);
//			}
//		}
		
		// optimal solution with o(n)Time and (n)space
		// Step 1: find split index
		int k = 0;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				k = i + 1;
				break;
			}
		}

		// Step 2: merge two sorted halves
		int[] temp = new int[n];
		int i = 0, j = k, idx = 0;

		while (i < k && j < n) {
			temp[idx++] = (arr[i] <= arr[j]) ? arr[i++] : arr[j++];
		}
		while (i < k)
			temp[idx++] = arr[i++];
		while (j < n)
			temp[idx++] = arr[j++];

		System.arraycopy(temp, 0, arr, 0, n);
	}

	/**
	 * Question 3 : Message Decoding 
	 * Given a string S, check whether it can be converted into the string "hello"
	 * by deleting some characters from it. Note : S can have both uppercase and
	 * lowercase letters.
	 * 
	 * Example 1:
	 * 
	 * Input: S = "bbbbbxxhhelllllooudd" Output: 1 Explanation: The string hello is
	 * marked in bold: bbbbbxxhhelllllooudd
	 **/
	public static boolean decode(String s) {
		int i=0;int j=0;
		String target="hello";
		
		while(i<s.length() && j<target.length()) {
			if(s.charAt(i)==target.charAt(j)) {
				j++;
			}
			i++;
		}
		return (j==target.length());
	}

	/**
	 * Question 4 : Reverse a string with spaces intact
	 * Given a string, your task is to reverse the string keeping the spaces intact
	 * to their positions.
	 * 
	 * Example 1:
	 * 
	 * Input: S = "Help others" Output: sreh topleH 
	 * Explanation: The space is intact
	 * at index 4 while all other characters are reversed.
	 **/
	public static String reverseWithSpacesIntact(String s) {
		char [] arr = s.toCharArray();
	      
	      int left=0;int right =arr.length-1;
	      
	      while(left<right){
	          if(arr[left]==' '){
	              left++;
	              continue;
	          }
	          if(arr[right]==' '){
	              right--;
	              continue;
	          }
	          
	          char temp = arr[left];
	          arr[left]=arr[right];
	          arr[right]=temp;
	          left++;right--;
	      }
	      
	      return new String(arr);
	}
	
	public static void main(String[] args) {
//		 Scanner sc = new Scanner(System.in);
		 
		// Number of test cases
//	        int T = sc.nextInt();
//
//	        for (int t = 1; t <= T; t++) {
//	            int n = sc.nextInt();
//	            int[] arr = new int[n];
//	            for (int i = 0; i < n; i++) {
//	                arr[i] = sc.nextInt();
//	            }

	            // Print which test case is running
//	            System.out.print("Test Case #" + t + ": ");

	            // Print the result
                // Day 1 : Chocolate problem
//	            int ans = chocolates(arr,n);
//	            System.out.println(ans);
	            
	            // Day 2 : Sorted halves
//	            sortedHalves(arr,n);
//	            System.out.println(Arrays.toString(arr));
	            
	            //Day 2 : Message Decoding
//	            String s = "bbbbbxxhhelllllooudd";
//	            if(decode(s)) {
//	            	System.out.println(true);
//	            }
//	            else {
//	            	System.out.println(false);
//	            }
	            
	            //Day 2 : Reverse a string with spaces intact
	            String s = "Hello World";
	            String ans2 = reverseWithSpacesIntact(s);
	            System.out.println(ans2);
	        }

//	        sc.close(); 
		
//	}

}
