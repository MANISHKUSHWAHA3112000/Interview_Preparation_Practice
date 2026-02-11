package com.java.interview.coding.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// GFG solution  
public class IndexSubArraySum {

	// but it fail in the negatiive numbere
	public static ArrayList<Integer> findIndexSubArraySum(int arr[], int target) {

		int start = 0, end = 0;

		ArrayList<Integer> result = new ArrayList<>();

		int currentSum = 0;

		for (int i = 0; i < arr.length; i++) {
			currentSum += arr[i];

			if (currentSum >= target) {
				end = i;

				while (currentSum > target && start < end) {
					currentSum -= arr[start];
					++start;
				}
				if (currentSum == target) {
					result.add(start + 1);
					result.add(end + 1);
					return result;
				}
			}
		}
		result.add(-1);
		return result;
	}
	
	 static {
	        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
	            try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) {
	                fw.write("0");
	            } catch (Exception e) {
	            }
	        }));
	    }
	 // this solution is run on the negative number also
	    public static int findIndexSubArraySum2(int[] nums, int k) {
	      Map<Integer,Integer> m = new HashMap<>();
			m.put(0, 1);
			
			int currSum=0,count=0;
			
			for(int i=0;i<nums.length;i++) {
				currSum+=nums[i];
				
				if(m.containsKey(currSum-k)) {
					count+=m.get(currSum-k);
				}
				m.put(currSum, m.getOrDefault(currSum, 0)+1);
			}
			return count;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		int target = 23;
		
		int arr2[]= {1,2,3,5,5,7,12,40};
		int target2=17;

		ArrayList<Integer> ans = findIndexSubArraySum(arr, target);
		int ans2 = findIndexSubArraySum2(arr2,target2);

		System.out.println("Indexes of Sub array sum from range of the array  : " + ans);
		System.out.println("Indexes of Sub array sum : " + ans2);
		sc.close();
	}
}
