package justPractice;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice {

	public static void main(String[] args) {
		int arr[] = {10, 30, 20, 5}; int target = 25;
//				Output: [5, 20]
//				Explanation: As 5 + 20 = 25 is closest to 25.
		
		Arrays.sort(arr);
		int left=0;int right=arr.length-1;
		
		while(left<right) {
			int sum = arr[left]+ arr[right];
			
			if(sum<target)left++;
			else if(sum==target) {
				System.out.println(arr[left]+ " "+arr[right]);
				left++;
				right--;
			}
			else {
				right--;
			}
		}
	}
}
