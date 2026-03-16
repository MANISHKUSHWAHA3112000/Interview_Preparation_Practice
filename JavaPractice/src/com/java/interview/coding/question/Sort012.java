package com.java.interview.coding.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sort012 {
	
	public static List<Integer> sort0123(List<Integer> nums){
		int low=0;
		int mid=0;
		int high=nums.size()-1;
		
		while (mid <= high) {
            if (nums.get(mid) == 0) {
                // swap nums[low] and nums[mid]
                int temp = nums.get(low);
                nums.set(low, nums.get(mid));
                nums.set(mid, temp);
                low++;
                mid++;
            } else if (nums.get(mid) == 1) {
                mid++;
            } else { // nums[mid] == 2
                // swap nums[mid] and nums[high]
                int temp = nums.get(mid);
                nums.set(mid, nums.get(high));
                nums.set(high, temp);
                high--;
            }
        }
        return nums;
		
		
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        System.out.println("Enter " + n + " elements (only 0,1,2):");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        List<Integer> ans = sort0123(list);
        System.out.println("Sorted list: " + ans);

        sc.close();
	}

}
