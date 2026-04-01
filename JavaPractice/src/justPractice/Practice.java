package justPractice;

import java.util.Arrays;
import java.util.List;

public class Practice {

	public static void main(String[] args) {
		
		int arr[]={6, 1, 8, 0, 4, -9, -1, -10, -6, -5};
		
		Arrays.sort(arr);
		int left=0;int right=arr.length-1;
		
		while(left<right) {
			int sum = arr[left]+arr[right];
			
			if(sum==0) {
				List<Integer> ans = Arrays.asList(arr[left],arr[right]);
				System.out.println(ans);
				left++;
				right--;
			}
			else if (sum<0) {
				left++;
			}
			else {
				right--;
			}
		}
		
	}
}
