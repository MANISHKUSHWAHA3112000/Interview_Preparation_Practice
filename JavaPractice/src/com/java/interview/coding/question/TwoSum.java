package com.java.interview.coding.question;

import java.util.*;

public class TwoSum {

	// time complexity is o(n) with 0 ms
    public static int[] findTwoSum(int arr[], int n, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; // no solution
    }
    
    // Time complexity is o(n) with 2 ms
//    public static int [] findTwoSum(int arr[],int n,int target) {
//    	Map<Integer,Integer> mp = new HashMap<>();
//    	
//    	 for(int i=0;i<n;i++) {
//    		 int checkTarget = target-arr[i];
//    		 if(mp.containsKey(checkTarget)) {
//    			 return new int [] {mp.get(checkTarget),i};
//    		 }
//    		 mp.put(arr[i], i);
//    	 }
//    	 return new int [] {-1,-1};
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int ans[] = findTwoSum(arr, n, target);

        System.out.println(Arrays.toString(ans));
    }
}
