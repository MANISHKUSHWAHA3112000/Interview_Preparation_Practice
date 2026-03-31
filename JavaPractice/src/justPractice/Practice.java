package justPractice;

import java.util.HashSet;
import java.util.Set;

public class Practice {

	public static void main(String[] args) {
		int arr[]= {46, 22 ,71, 76, 19};
				
		int x = 73;
		int start=0;
		int currSum=0;
		int maxSum = Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			currSum+=arr[i];
			System.out.print("CurrSum : "+ currSum+ " \n");
			
			while(currSum > x && start<=i) {
				currSum-=arr[start];
				start++;
			}
			if(currSum<=x) {
				maxSum=Math.max(maxSum, currSum);
				System.out.print("maxsum is : "+ maxSum + " \n");
			}
		}
		System.out.println("Final ans is : "+ maxSum);
		
		
	}
}
