package com.java.interview.coding.question;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuyStellStock {
	
	public static int findBuySellStock(List<Integer> nums) {
		int min = Integer.MAX_VALUE;
		
		
		int result =0;
		
		for(int i=0;i<nums.size();i++) {
			if(nums.get(i)<min) {
				min=nums.get(i);
			}
			else {
				result = Math.max(result, nums.get(i)-min);
			}
		}
		
		return result;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			list.add(sc.nextInt());
		}
		
		int ans = findBuySellStock(list);
		
		System.out.println(ans);
		
	}

}
