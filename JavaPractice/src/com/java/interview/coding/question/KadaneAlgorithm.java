package com.java.interview.coding.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KadaneAlgorithm {
	
	public static int findKadaneAlgorithmWithSum(int arr[],int n,int k) {
		Map<Integer, Integer> prefixMap = new HashMap<>();
		int sum = 0, maxLen = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum == k) {
				maxLen = i + 1;
			}
			if (prefixMap.containsKey(sum - k)) {
				maxLen = Math.max(maxLen, i - prefixMap.get(sum - k));
			} // store first occurrence of sum
			if (!prefixMap.containsKey(sum)) {
				prefixMap.put(sum, i);
			}
		}

	return maxLen;

	}
	
	public static int findMaxSubArray(int nums[]) {
		int maxSum=nums[0];
        int currSum=nums[0];
        for(int i=1;i<nums.length;i++){
            currSum=Math.max(nums[i],currSum+nums[i]);
            maxSum=Math.max(maxSum,currSum);
        }
        return maxSum;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		
		int n=sc.nextInt();
		
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		
//		int k =sc.nextInt();
		
//		int ans = findKadaneAlgorithmWithSum(arr,n,k);
		int ans2 = findMaxSubArray(arr);
		
//		System.out.println("Kadane Algorithm is : "+ ans );
		System.out.println("maximum subarray sum is :" + ans2 );
	}

}
