package com.java.interview.coding.question;

public class RemoveElement {
	
	public static int removeElement(int nums[],int val) {
		int index=0;
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=val) {
				nums[index]=nums[i];
				System.out.print(nums[index]+ " ");
				index++;
				
			}
		}
		System.out.println("final answer"+ index);
		return index;
	}

	public static void main(String[] args) {
		
		int nums[] = {0,1,2,2,3,0,4,2};
		int val = 2;
		
		int ans = removeElement(nums,val);
		
		System.out.println(ans);
	}
}
