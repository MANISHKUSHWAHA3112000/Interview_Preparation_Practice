package justPractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Practice {
	

	public static void main(String[] args) {
		
		int nums[]= {0,1,2,2,3,0,4,2};
		
		int k =0;
		
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=k) {
				nums[k]=nums[i];
//				k++;
				System.out.println(nums[k]);
			}
		}
		
	}
}
