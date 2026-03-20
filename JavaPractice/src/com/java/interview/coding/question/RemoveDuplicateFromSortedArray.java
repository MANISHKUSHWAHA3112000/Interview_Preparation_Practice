package com.java.interview.coding.question;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromSortedArray {
    
    // Method 1: In-place removal of duplicates
    // Time Complexity: O(n) - single pass through array
    // Space Complexity: O(1) - no extra data structures, modifies array directly
    // ✅ Most optimal in terms of performance
    public static int findDuplicate(int arr[]) {
        if(arr.length==0)return 0;
        
        int j=0;
        for(int i=1;i<arr.length;i++) {
            if(arr[i]!=arr[j]) {
                j++;
            }
            arr[j]=arr[i];
        }
        return j+1;
    }
    
    // Method 2: Build a new ArrayList of unique elements
    // Time Complexity: O(n) - single pass through array
    // Space Complexity: O(k) - stores only unique elements in ArrayList
    // ⚖️ Slightly more space than method 1, but preserves unique values cleanly
    public static ArrayList<Integer> findDuplicateList(int arr[]){
        ArrayList<Integer> result = new ArrayList<>();
        
        if(arr.length==0) {
            return result;
        }
        result.add(arr[0]);
        int j=0;
        for(int i=1;i<arr.length;i++) {
            if(arr[i]!=arr[j]) {
                result.add(arr[i]);
                j++;
            }
            arr[j]=arr[i];
        }
        return result;
    }
    
    // Method 3: Use a HashSet to track seen elements
    // Time Complexity: O(n) average - HashSet operations are O(1) on average
    // Space Complexity: O(k) + overhead - needs both ArrayList and HashSet
    // ⚠️ More memory overhead, ordering not guaranteed unless LinkedHashSet is used
    public static ArrayList<Integer> findDuplicateListUsingSet(int arr[]){
        ArrayList<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        
        for(int num : arr) {
            if(!seen.contains(num)) {
                result.add(num);
                seen.add(num);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        
        int arr[]= {1,2,2,2,3,4,4,5};
        
        int ans1 = findDuplicate(arr);
        ArrayList<Integer> ans2 = findDuplicateList(arr);
        ArrayList<Integer> ans3 = findDuplicateListUsingSet(arr);
        
        System.out.println("Duplicate array in the sorted array are : "+ ans1);
        System.out.println("Remove duplicate in the sorted array are  : "+ ans2);
        System.out.println("Remove duplicate in the sorted array using Set  : "+ ans3);

    }

}
