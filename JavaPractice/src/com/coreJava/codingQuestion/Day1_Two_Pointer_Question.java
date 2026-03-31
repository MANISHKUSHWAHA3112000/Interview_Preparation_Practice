package com.coreJava.codingQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	/**Question : Extract the Integer (GFG)
	 * Extract the integers Difficulty: BasicAccuracy: 48.37%Submissions:
	 * 18K+Points: 1 Given a string s, extract all the integers from s.
	 * 
	 * Example 1:
	 * 
	 * Input: s = "1: Prakhar Agrawal, 2: Manish Kumar Rai, 3: Rishabh Gupta56"
	 * Output: 1 2 3 56 Explanation: 1, 2, 3, 56 are the integers present in s.
	 **/
	public static ArrayList<String> extractIntegerWords(String s){
		 ArrayList<String> res = new ArrayList<>();
	        int n = s.length();
	        int start = 0;

	        while (start < n) {
	            // move start until we find a digit
	            if (Character.isDigit(s.charAt(start))) {
	                int end = start;
	                // move end until digits stop
	                while (end < n && Character.isDigit(s.charAt(end))) {
	                    end++;
	                }
	                // substring from start to end gives full number
	                res.add(s.substring(start, end));
	                start = end; // continue after the number
	            } else {
	                start++;
	            }
	        }
	        return res;
	}
	/**
	 * Sum Pair closest to target
Difficulty: EasyAccuracy: 44.75%Submissions: 75K+Points: 2
Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a ≤ b whose sum is closest to target.
Note: Return the pair in sorted order and if there are multiple such pairs return the pair with maximum absolute difference. If no such pair exists return an empty array.

Examples:

Input: arr[] = [10, 30, 20, 5], target = 25
Output: [5, 20]
Explanation: As 5 + 20 = 25 is closest to 25.
Input: arr[] = [5, 2, 7, 1, 4], target = 10
Output: [2, 7]
Explanation: As (4, 5), (2, 7) and (4, 7) both are closest to 10, but absolute difference of (4, 5) is 1, (2, 7) is 5 and (4, 7) is 3. Hence, [2, 7] has maximum absolute difference and closest to target. **/
	 public static ArrayList<Integer> sumClosest(int[] arr, int target) {
	        // code here
	         int n = arr.length;
	        if (n < 2) return new ArrayList<>(); // no pair possible

	        Arrays.sort(arr);
	        int left = 0, right = n - 1;
	        int minDiff = Integer.MAX_VALUE;
	        ArrayList<Integer> bestPair = new ArrayList<>();

	        while (left < right) {
	            int sum = arr[left] + arr[right];
	            int diff = Math.abs(sum - target);

	            if (diff < minDiff) {
	                minDiff = diff;
	                bestPair = new ArrayList<>(Arrays.asList(arr[left], arr[right]));
	            } else if (diff == minDiff) {
	                // choose pair with maximum absolute difference
	                if (Math.abs(arr[right] - arr[left]) > Math.abs(bestPair.get(1) - bestPair.get(0))) {
	                    bestPair = new ArrayList<>(Arrays.asList(arr[left], arr[right]));
	                }
	            }

	            if (sum < target) {
	                left++;
	            } else {
	                right--;
	            }
	        }

	        return bestPair;
	 }
	
	/** Question :  Three Sum Problem (Leetcode)
	 * Given an integer array nums, return all the triplets [nums[i], nums[j],
	 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
	 * nums[k] == 0.
	 * 
	 * Notice that the solution set must not contain duplicate triplets.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] Explanation:
	 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0. nums[1] + nums[2] + nums[4] =
	 * 0 + 1 + (-1) = 0. nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0. The
	 * distinct triplets are [-1,0,1] and [-1,-1,2]. Notice that the order of the
	 * output and the order of the triplets does not matter.
	 **/
	public static List<List<Integer>> threeSumProblem(int nums[]){
		List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            if(i > 0 && nums[i]==nums[i-1])continue;

            int left=i+1;
            int right=nums.length-1;

            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];

                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));

                    while(left<right && nums[left]==nums[left+1])left++;
                    while(left<right && nums[right]==nums[right-1])right--;
                    left++;
                    right--;
                }
                else if (sum <0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return res;
		
	}
	
	/**Question : Distinct triplet with the given sum (Three sum problem )
	 * Find all distinct triplets with given sum Difficulty: EasyAccuracy:
	 * 48.82%Submissions: 1K+Points: 2Average Time: 25m Given an array arr[], and an
	 * integer target, find all possible unique triplets in the array whose sum is
	 * equal to the given target value. We can return triplets in any order, but all
	 * the returned triplets should be internally sorted, i.e., for any triplet [q1,
	 * q2, q3], the condition q1 ≤ q2 ≤ q3 should hold.
	 * 
	 * Examples:
	 * 
	 * Input: arr[] = [12, 3, 6, 1, 6, 9], target = 24 Output: [[3, 9, 12], [6, 6,
	 * 12]] Explanation: Triplets with sum 24 are (3, 9, 12) and (6, 6, 12). Input:
	 * arr[] = [1, 1, 1, 1], target = 3 Output: [[1, 1, 1]] Explanation: Triplets
	 * with sum 3 are (1, 1, 1). Input: arr[] = [10, 12, 10, 15], target = 32
	 * Output: [[10, 10, 12]] Explanation: Triplets with sum 32 are (10, 10, 12).
	 */
	
	public static List<List<Integer>> distinctThreeSum(int arr[],int target){
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(arr);
		
		for(int i=0;i<arr.length-2;i++) {
			if(i>0 && arr[i]==arr[i-1])continue;
			
			int left=i+1;
			int right=arr.length-1;
			while(left<right) {
				int sum = arr[i]+arr[left]+arr[right];
				
				if(sum==target) {
					res.add(Arrays.asList(arr[i],arr[left],arr[right]));
					while(left<right && arr[left]==arr[left+1])left++;
					while(left<right && arr[right]==arr[right-1])right--;
					left++;
					right--;
				}
				else if (sum<target) {
					left++;
				}
				else {
					right--;
				}
			}
		}
		return res;
	}
	
	/**Question : Intersection of Arrays with Distint Difficulty(GFG)
	 * Intersection of Arrays with Distinct Difficulty: EasyAccuracy:
	 * 32.83%Submissions: 238K+Points: 2Average Time: 20m Given two unsorted integer
	 * arrays a[] and b[] each consisting of distinct elements, the task is to
	 * return the count of elements in the intersection (or common elements) of the
	 * two arrays.
	 * 
	 * Intersection of two arrays can be defined as the set containing distinct
	 * common elements between the two arrays.
	 * 
	 * Examples:
	 * 
	 * Input: a[] = [89, 24, 75, 11, 23], b[] = [89, 2, 4] Output: 1 Explanation: 89
	 * is the only element in the intersection of two arrays. Input: a[] = [1, 2, 4,
	 * 3, 5, 6], b[] = [3, 4, 5, 6, 7] Output: 4 Explanation: 3, 4, 5, and 6 are the
	 * elements in the intersection of two arrays.
	 **/
	public static int intersectSize(int a[], int b[]) {
		int ans =0;
		
		Set<Integer> seen1 = new HashSet<>();
		
		for(int num1:a) {
			seen1.add(num1);
		}
		for(int num2:b) {
			if(seen1.contains(num2)) {
				ans++;
			}
		}
		return ans;
	}
	
	/**
	 * Count increasing Subarrays Difficulty: EasyAccuracy: 55.05%Submissions:
	 * 9K+Points: 2 Given an array arr[] of integers, count the number of subarrays
	 * in arr[] which are strictly increasing with size greater or equal to 2. A
	 * subarray is a contiguous part of array. A subarray is strictly increasing if
	 * each element is greater then it's previous element if it exists.
	 * 
	 * Examples:
	 * 
	 * Input: arr[] = [1, 3, 3, 2, 3, 5] Output: 4 Explanation: Increasing Subarrays
	 * are : arr[0,1], arr[3,4], arr[3,5], arr[4,5]. Input: arr[] = [1, 5] Output: 1
	 * Explanation:The only Increasing Subarray is arr[0,1]. Expected Time
	 * Complexity: O(n) Expected Auxiliary Space: O(1)
	 **/
	public static int countIncreasing(int arr[]) {
		int count=0;
		int j=0;
		
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<=arr[i-1]) {
				int length= i-j;
				count+=(length*(length-1))/2;
				j=i;
			}
		}
		int length = arr.length-j;
		count+=(length*(length-1))/2;
		return count;
	}
	
	/**
	 * Maximum sum of subarray less than or equal to x Difficulty: EasyAccuracy:
	 * 43.78%Submissions: 17K+Points: 2 Given an array arr[] of integers and a
	 * number x, the task is to find the sum of subarray having a maximum sum less
	 * than or equal to the given value of x.
	 * 
	 * Examples:
	 * 
	 * Input: arr[] = [1, 2, 3, 4, 5], x = 11 Output: 10 Explanation: Subarray
	 * having maximum sum is [1, 2, 3, 4]. Input: arr[] = [2, 4, 6, 8, 10], x = 7
	 * Output: 6 Explanation: Subarray having maximum sum is [2, 4] or [6]. Expected
	 * Time Complexity: O(n). Expected Auxiliary Space: O(1).
	 **/
	
	public static long findMaxSubarraySum(int[] arr, long x) {
		long maxSum=0;
		long currSum=0;
		int j=0;
		
		for(int i=0;i<arr.length;i++) {
			currSum+=arr[i];
			
			while(currSum>x && j<=i) {
				currSum-=arr[j];
				j++;
			}
			if(currSum<=x) {
				maxSum=Math.max(maxSum, currSum);
			}
		}
		return maxSum;
	}
	
	/**
	 * Intersection of Two arrays with Duplicate Elements Difficulty: EasyAccuracy:
	 * 61.4%Submissions: 42K+Points: 2Average Time: 20m Given two integer arrays a[]
	 * and b[], you have to find the intersection of the two arrays. Intersection of
	 * two arrays is said to be elements that are common in both the arrays. The
	 * intersection should not have duplicate elements and the result should contain
	 * items in any order.
	 * 
	 * Note: The driver code will sort the resulting array in increasing order
	 * before printing.
	 * 
	 * Examples:
	 * 
	 * Input: a[] = [1, 2, 1, 3, 1], b[] = [3, 1, 3, 4, 1] Output: [1, 3]
	 * Explanation: 1 and 3 are the only common elements and we need to print only
	 * one occurrence of common elements. Input: a[] = [1, 1, 1], b[] = [1, 1, 1, 1,
	 * 1] Output: [1] Explanation: 1 is the only common element present in both the
	 * arrays. Input: a[] = [1, 2, 3], b[] = [4, 5, 6] Output: [] Explanation: No
	 * common element in both the arrays. Constraints: 1 ≤ a.size(), b.size() ≤ 105
	 * 0 ≤ a[i], b[i] ≤ 105
	 * 
	 * Expected Complexities Time Complexity: O(n + m) Auxiliary Space: O(n)
	 **/
	
	public static ArrayList<Integer> intersect(int[] a, int[] b) {
		
		ArrayList<Integer> res = new ArrayList<>();
		
		Set<Integer> seen1 = new HashSet<>();
		Set<Integer> seen2 = new HashSet<>();
		
		for(int num1:a) {
			seen1.add(num1);
		}
		
		for(int num2:b) {
			seen2.add(num2);
		}
		for(int ans : seen2) {
			if(seen1.contains(ans)) {
				res.add(ans);
			}
		}
		return res;
	}
	
	/**
	 * Two Sum in Sorted Array Difficulty: EasyAccuracy: 47.46%Submissions:
	 * 6K+Points: 2 You are given a 1-based indexed integer array arr[] that is
	 * sorted in non-decreasing order, along with an integer target. Your task is to
	 * find two elements in the array such that their sum is equal to target. If
	 * such a pair exists, return the indices of the two elements in increasing
	 * order. If no such pair exists, return [-1, -1]. Note: If your answer is
	 * correct then the driver code will print "true" otherwise "false".
	 * 
	 * Examples:
	 * 
	 * Input: arr[] = [2, 7, 11, 15], target = 9 Output: [1, 2] Explanation: Since
	 * arr[0] + arr[1] = 2 + 7 = 9 equals the target, return their 1-based indices :
	 * [1, 2] Input: arr[] = [1, 3, 4, 6, 8, 11], target = 10 Output: [3, 4]
	 * Explanation: Since arr[2] + arr[3] = 4 + 6 = 10 equals the target, return
	 * their 1-based indices : [3, 4] Constraints: 1 ≤ arr.size() ≤ 105 1 ≤ arr[i],
	 * target ≤ 106
	 **/
	public static ArrayList<Integer>twoSum(int arr[],int target){
		ArrayList<Integer> res = new ArrayList<>();
		
		int start=0;int end=arr.length-1;
		
		while(start<end) {
			int sum = arr[start]+arr[end];
			
			if(sum==target) {
				res.add(start+1);
				res.add(end+1);
				return res;
			}
			else if (sum<target) {
				start++;
			}
			else {
				end--;
			}
		}
		res.add(-1);
		res.add(-1);
		return res;
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
//	            String s = "Hello World";
//	            String ans2 = reverseWithSpacesIntact(s);
//	            System.out.println(ans2);
		
		        //Day 2 : Extract the Integer
//		        String s = "\"1: Prakhar Agrawal, 2: Manish Kumar Rai, \r\n"
//		        		+ "     3: Rishabh Gupta56";
//		        ArrayList<String> ans3 = extractIntegerWords(s);
//		        System.out.println(ans3);
		
		        //Day 3 : Sum pairs to closet
//		        int arr[] = {10, 30, 20, 5} , target = 25;
//		        ArrayList<Integer>ans3 = sumClosest(arr,target);
//		        System.out.println(ans3);
		
		        //Day 3 : Three sum problem
//		        int arr[]= {-1,0,1,2,-1,-4};
//		        List<List<Integer>> ans4 = threeSumProblem(arr);
//		        System.out.println(ans4);
		
		        //Day 3 : Distinct Element with the given sum (Three sum)
//		        int arr[]= {12, 3, 6, 1, 6, 9}, target=24;
//		        List<List<Integer>> ans5= distinctThreeSum(arr, target);
//		        System.out.println(ans5);
		        
		        //Day 3 : Intersection of Arrays with Distint 
//		        int a[] = {89, 24, 75, 11, 23}, b[] = {89, 2, 4};
//		        int ans6 = intersectSize(a, b);
//		        System.out.println(ans6);
		
		        //Day 4 : Count increasing Subarrays
//		        int arr[]= {1, 3, 3, 2, 3, 5};
//		        int ans7 = countIncreasing(arr);
//		        System.out.println(ans7);
		        
	            //Day 5 : Max sumbarray sum is <=x
//		        int arr[]= {46, 22 ,71, 76, 19};
//				int x = 73;
//		        long ans8=findMaxSubarraySum(arr,x);
//		        System.out.println(ans8);
		
		        //Day 5 : Intersection of two array
//		        int  a[] = {1, 2, 1, 3, 1}, b[] = {3, 1, 3, 4, 1};
//		        ArrayList<Integer> ans9 = intersect(a,b);
//		        System.out.println(ans9);
		
		        //Day 5 : Two Sum in Sorted Array 
		        int arr[]= {2, 7, 11, 15}, target = 9;
		        ArrayList<Integer> ans10 = twoSum(arr, target);
		        System.out.println(ans10);
		        
	        }

//	        sc.close(); 
		
//	}

}
